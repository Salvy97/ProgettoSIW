package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.DatabaseManager;
import model.ContenutoGuardato;

public class DammiFilmGuardati extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String username = req.getParameter("username");
		
		List<ContenutoGuardato> contenuti = DatabaseManager.getInstance().getDaoFactory().getContenutiGuardatiDAO().searchFilmsWatchedByUser(username);
		req.setAttribute("contenutiGuardati", contenuti);
		
		RequestDispatcher rd = req.getRequestDispatcher("filmGuardati.jsp");
		rd.forward(req, resp);
	}
}