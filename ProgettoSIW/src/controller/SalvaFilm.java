package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Film;
import persistence.DatabaseManager;

public class SalvaFilm extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		DatabaseManager dbm = DatabaseManager.getInstance();

		int anno;
		int durata;
		String titolo;
		String locandina;
		String genere;
		String regista;
		String filmato;
		String immagineForum;
		String sinossi;

		anno = Integer.parseInt(req.getParameter("anno"));
		durata = Integer.parseInt(req.getParameter("durata"));
		titolo = req.getParameter("titolo");;
		locandina = req.getParameter("locandina");
		genere = req.getParameter("genere");
		regista = req.getParameter("regista");
		filmato = req.getParameter("filmato");
		immagineForum = req.getParameter("immagineForum");
		sinossi = req.getParameter("sinossi"); 

		Film newFilm = new Film();
		newFilm.setId_film(-1);
		newFilm.setTitolo(titolo);
		newFilm.setAnno(anno);
		newFilm.setDurata(durata);
		newFilm.setGenere(genere);
		newFilm.setRegista(regista);
		newFilm.setLocandina(locandina);
		newFilm.setFilmato(filmato);
		newFilm.setImmagineForum(immagineForum);
		newFilm.setSinossi(sinossi);

		dbm.getDaoFactory().getFilmDAO().save(newFilm);
		
		res.sendRedirect("gestioneFilm");
	}
}