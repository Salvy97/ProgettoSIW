package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ContenutoPreferito;
import model.Film;
import model.Profilo;
import model.SerieTV;
import persistence.DatabaseManager;
import persistence.dao.ProfiloDAO;

@SuppressWarnings("serial")
public class DammiProfilo extends HttpServlet 
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		RequestDispatcher rd = req.getRequestDispatcher("ottieniIndex");
		String username = req.getParameter("username");
		if (username != null) 
		{
			ProfiloDAO pDao = DatabaseManager.getInstance().getDaoFactory().getProfiloDAO();		
			
			Profilo profilo = pDao.findByUsername(username);
			req.setAttribute("profilo", profilo);
			
			List<ContenutoPreferito> filmPreferiti = DatabaseManager.getInstance().getDaoFactory().getContenutiPreferitiDAO().findFilmsByUsername(username);
			List<Film> films = DatabaseManager.getInstance().getDaoFactory().getFilmDAO().findFavouriteFilms(filmPreferiti);
			req.setAttribute("favFilms", films);
			
			List<ContenutoPreferito> serieTVPreferite = DatabaseManager.getInstance().getDaoFactory().getContenutiPreferitiDAO().findSerieTVsByUsername(username);
			List<SerieTV> serieTVs = DatabaseManager.getInstance().getDaoFactory().getSerieTVDAO().findFavouriteSerieTVs(serieTVPreferite);
			req.setAttribute("favSerieTVs", serieTVs);
			
			rd = req.getRequestDispatcher("profilo.jsp");
		}
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		doGet(req, resp);
	}
}