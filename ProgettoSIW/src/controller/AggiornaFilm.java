package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Film;
import persistence.DatabaseManager;

public class AggiornaFilm extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		DatabaseManager dbm = DatabaseManager.getInstance();

		int idFilm;
		int anno;
		int durata;
		String titolo;
		String locandina;
		String genere;
		String regista;
		String filmato;
		String immagineForum;
		String sinossi;

		idFilm = Integer.parseInt(req.getParameter("idFilm"));
		anno = Integer.parseInt(req.getParameter("anno"));
		durata = Integer.parseInt(req.getParameter("durata"));
		titolo = req.getParameter("titolo");;
		locandina = req.getParameter("locandina");
		genere = req.getParameter("genere");
		regista = req.getParameter("regista");
		filmato = req.getParameter("filmato");
		immagineForum = req.getParameter("immagineForum");
		sinossi = req.getParameter("sinossi");
		
		Film film = dbm.getDaoFactory().getFilmDAO().cercaPerId(idFilm);
		Film editedFilm = new Film();
		editedFilm.setId_film(idFilm);
		editedFilm.setTitolo(titolo);
		editedFilm.setAnno(anno);
		editedFilm.setDurata(durata);
		editedFilm.setGenere(genere);
		editedFilm.setRegista(regista);
		editedFilm.setLocandina(locandina);
		editedFilm.setFilmato(filmato);
		editedFilm.setImmagineForum(immagineForum);
		editedFilm.setSinossi(sinossi);
		editedFilm.setVisualizzazioni(film.getVisualizzazioni());
		editedFilm.setData_inserimento(film.getData_inserimento());

		dbm.getDaoFactory().getFilmDAO().update(editedFilm);
		
		res.sendRedirect("gestioneFilm");
	}
}