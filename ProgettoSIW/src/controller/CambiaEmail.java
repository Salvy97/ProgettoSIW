package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Utente;
import persistence.DatabaseManager;

public class CambiaEmail extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String newEmail = req.getParameter("email");
		
		String username = (String) req.getSession().getAttribute("name");
		Utente utente = DatabaseManager.getInstance().getDaoFactory().getUtenteDAO().findByUsername(username);
		
		Utente utenteNewEmail = DatabaseManager.getInstance().getDaoFactory().getUtenteDAO().findByEmail(newEmail);
		if (utenteNewEmail == null)
		{
			utente.setEmail(newEmail);
			DatabaseManager.getInstance().getDaoFactory().getUtenteDAO().update(utente);
				
			req.getSession().setAttribute("error", "none");
			RequestDispatcher rd = req.getRequestDispatcher("user?username=" + utente.getUsername());
			rd.forward(req, resp);
		}
		else
		{
			req.getSession().setAttribute("error", "emailUsed");
			RequestDispatcher rd = req.getRequestDispatcher("cambiaEmail.jsp");
			rd.forward(req, resp);
		}
	}
}