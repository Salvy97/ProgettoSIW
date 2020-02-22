package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Utente;
import persistence.DatabaseManager;

public class CambiaPassword extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String oldPassword = req.getParameter("oldPassword");
		String newPassword = req.getParameter("newPassword");
		String repeatNewPassword = req.getParameter("repeatNewPassword");
		
		String username = (String) req.getSession().getAttribute("name");
		Utente utente = DatabaseManager.getInstance().getDaoFactory().getUtenteDAO().findByUsername(username);
		
		if (oldPassword.equals(utente.getPassword()))
		{
			if (newPassword.equals(repeatNewPassword))
			{
				utente.setPassword(newPassword);
				DatabaseManager.getInstance().getDaoFactory().getUtenteDAO().update(utente);
				
				RequestDispatcher rd = req.getRequestDispatcher("user?username=" + utente.getUsername());
				rd.forward(req, resp);
				req.getSession().setAttribute("error", "none");
			}
			else
			{
				req.getSession().setAttribute("error", "newPassword");
				RequestDispatcher rd = req.getRequestDispatcher("cambiaPassword.jsp");
				rd.forward(req, resp);
			}
		}
		else
		{
			req.getSession().setAttribute("error", "oldPassword");
			RequestDispatcher rd = req.getRequestDispatcher("cambiaPassword.jsp");
			rd.forward(req, resp);
		}
	}
}