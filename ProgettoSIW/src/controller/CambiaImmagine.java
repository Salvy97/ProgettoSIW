package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Profilo;
import persistence.DatabaseManager;

public class CambiaImmagine extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String username = (String) req.getSession().getAttribute("name");
		String url = req.getParameter("url");
		
		Profilo profilo = DatabaseManager.getInstance().getDaoFactory().getProfiloDAO().findByUsername(username);
		profilo.setImmagineDiProfilo(url);
		
		DatabaseManager.getInstance().getDaoFactory().getProfiloDAO().update(profilo);
		
		RequestDispatcher rd = req.getRequestDispatcher("user?username=" + username);
		rd.forward(req, resp);
	}
}