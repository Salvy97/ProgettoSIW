package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Utente;
import persistence.DatabaseManager;

public class CambiaUsername extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String newUsername = req.getParameter("newUsername");
		
		String username = (String) req.getSession().getAttribute("name");
		Utente utente = DatabaseManager.getInstance().getDaoFactory().getUtenteDAO().findByUsername(username);
		
		Utente existsUtente = DatabaseManager.getInstance().getDaoFactory().getUtenteDAO().findByUsername(newUsername);
		
		if (existsUtente == null)
		{
			utente.setUsername(newUsername);
			DatabaseManager.getInstance().getDaoFactory().getUtenteDAO().update(utente);
				
			RequestDispatcher rd = req.getRequestDispatcher("user?username=" + utente.getUsername());
			rd.forward(req, resp);
		}
		else
		{
			req.getSession().setAttribute("message", "L'username è già in uso. Riprova.");
			RequestDispatcher rd = req.getRequestDispatcher("cambiaUsername.jsp");
			rd.forward(req, resp);
		}
	}
}