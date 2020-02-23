package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Episodio;
import model.Stagione;
import persistence.DatabaseManager;

public class SalvaEpisodio extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		int idStagione = Integer.parseInt(req.getParameter("id"));
		
		String titolo = req.getParameter("titolo");
		int durata = Integer.parseInt(req.getParameter("durata"));
		String filmato = req.getParameter("filmato");
		int numeroEpisodio = Integer.parseInt(req.getParameter("numeroEpisodio"));
		
		Episodio episodio = new Episodio();
		episodio.setTitolo(titolo);
		episodio.setDurata(durata);
		episodio.setFilmato(filmato);
		episodio.setNumero_episodio(numeroEpisodio);
		
		Stagione stagione = new Stagione();
		stagione.setId_stagione(idStagione);
		episodio.setStagione(stagione);
		
		DatabaseManager.getInstance().getDaoFactory().getEpisodioDAO().save(episodio);
		res.sendRedirect("gestioneEpisodi?id=" + idStagione);
	}
}