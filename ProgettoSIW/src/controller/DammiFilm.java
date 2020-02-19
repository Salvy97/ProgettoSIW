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
import persistence.dao.FilmDao;

public class DammiFilm extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		FilmDao fDao = DatabaseManager.getInstance().getDaoFactory().getFilmDAO();
		List<Film> films = fDao.findAll();
		
        req.setAttribute("films", films);
		
		RequestDispatcher rd = req.getRequestDispatcher("film.jsp");
		rd.forward(req, resp);
	}
}