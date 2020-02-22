package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Episodio;
import model.Film;
import model.SerieTV;
import model.Stagione;
import persistence.DatabaseManager;
import persistence.dao.EpisodioDao;
import persistence.dao.FilmDao;
import persistence.dao.SerieTVDao;
import persistence.dao.StagioneDao;


public class DammiIndex extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		

		FilmDao fDao = DatabaseManager.getInstance().getDaoFactory().getFilmDAO();
		List<Film> ultimiFilmInseriti = fDao.cercaUltimiInseriti();
		req.setAttribute("ultimiFilmInseriti", ultimiFilmInseriti);
		
		List<Film> filmPiuVisti = fDao.cercaPiuVisti();
		req.setAttribute("filmPiuVisti", filmPiuVisti);
		
		
				
		SerieTVDao sDao = DatabaseManager.getInstance().getDaoFactory().getSerieTVDAO();
		List<SerieTV> ultimeSerieTVInserite = sDao.cercaUltimiInseriti();
		req.setAttribute("ultimeSerieTVInserite", ultimeSerieTVInserite);
		
		List<SerieTV> serieTVPiuViste = sDao.cercaPiuVisti();
		req.setAttribute("serieTVPiuViste", serieTVPiuViste);
		
		StagioneDao stDao = DatabaseManager.getInstance().getDaoFactory().getStagioneDAO();
		List<Stagione> ultimeStagioniInserite = stDao.cercaUltimiInseriti();
		req.setAttribute("ultimeStagioniInserite", ultimeStagioniInserite);
		
		List<Stagione> stagioniPiuViste = stDao.cercaPiuVisti();
		req.setAttribute("stagioniPiuViste", stagioniPiuViste);
		
		EpisodioDao eDao = DatabaseManager.getInstance().getDaoFactory().getEpisodioDAO();
		List<Episodio> ultimiEpisodiInseriti = eDao.cercaUltimiInseriti();
		req.setAttribute("ultimiEpisodiInseriti", ultimiEpisodiInseriti);
		
		List<Episodio> episodiPiuVisti = eDao.cercaPiuVisti();
		req.setAttribute("episodiPiuVisti", episodiPiuVisti);
		
		RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
		rd.forward(req, resp);
		
	}
}