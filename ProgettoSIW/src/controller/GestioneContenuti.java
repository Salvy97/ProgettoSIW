package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Film;
import persistence.DatabaseManager;

@SuppressWarnings("serial")
public class GestioneContenuti extends HttpServlet 
{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		List<Film> films = DatabaseManager.getInstance().getDaoFactory().getFilmDAO().findAll();
		req.setAttribute("films", films);
			
		RequestDispatcher rd  = req.getRequestDispatcher("GestioneContenuti.jsp");
		rd.forward(req, resp);
	}
}
