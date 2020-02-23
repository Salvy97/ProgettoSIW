package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Episodio;
import model.Stagione;
import persistence.DatabaseManager;

public class AggiornaEpisodio extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		DatabaseManager dbm = DatabaseManager.getInstance();

		int idEpisodio;
		int idStagione;
		String titolo;
		int durata;
		String filmato;
		int numeroEpisodio;
		String sinossi;

		idEpisodio = Integer.parseInt(req.getParameter("idEpisodio"));
		idStagione = Integer.parseInt(req.getParameter("idStagione"));
		durata = Integer.parseInt(req.getParameter("durata"));
		titolo = req.getParameter("titolo");
		filmato = req.getParameter("filmato");
		numeroEpisodio = Integer.parseInt(req.getParameter("numeroEpisodio"));
		sinossi = req.getParameter("sinossi");
		
		Episodio editedEpisodio = new Episodio();
		editedEpisodio.setId_episodio(idEpisodio);
		editedEpisodio.setTitolo(titolo);
		editedEpisodio.setDurata(durata);
		editedEpisodio.setFilmato(filmato);
		editedEpisodio.setNumero_episodio(numeroEpisodio);
		editedEpisodio.setSinossi(sinossi);
		
		Stagione stagione = new Stagione();
		stagione.setId_stagione(idStagione);
		editedEpisodio.setStagione(stagione);

		dbm.getDaoFactory().getEpisodioDAO().update(editedEpisodio);
		
		res.sendRedirect("gestioneSerieTV");
	}
}