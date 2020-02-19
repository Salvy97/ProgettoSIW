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


public class DammiIndex extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		

		FilmDao fDao = DatabaseManager.getInstance().getDaoFactory().getFilmDAO();
		
		List<Film> ultimiFilmInseriti = fDao.cercaUltimiInseriti();
		req.setAttribute("ultimiFilmInseriti", ultimiFilmInseriti);
		
		List<Film> filmPiuVisti = fDao.cercaPiuVisti();
		req.setAttribute("filmPiuVisti", filmPiuVisti);
		
		
		
		/*SerieTVDao sDao = DatabaseManager.getInstance().getDaoFactory().getFilmDAO();
		
		List<Film> ultimiInseriti = sDao.cercaUltimiInseriti();
		req.setAttribute("ultimiInseriti", ultimiInseriti);
		
		List<Film> piuVisti = fDao.cercaPiuVisti();
		req.setAttribute("piuVisti", piuVisti);*/
		
		RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
		rd.forward(req, resp);
		
	}
}