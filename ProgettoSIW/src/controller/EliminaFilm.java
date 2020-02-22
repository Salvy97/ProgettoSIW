package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Film;
import persistence.DatabaseManager;

public class EliminaFilm extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException 
	{
		int idFilm = Integer.parseInt(req.getParameter("id"));
		
		Film film = new Film();
		film.setId_film(idFilm);
		
		DatabaseManager.getInstance().getDaoFactory().getFilmDAO().delete(film);
		
		res.sendRedirect("gestioneFilm");
	}
}