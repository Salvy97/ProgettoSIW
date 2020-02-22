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
		String operation = (String) req.getParameter("operation");
		int anno;
		int durata;
		String titolo;
		String locandina;
		String genere;
		String regista;
		String filmato;
		String immagineForum;
		System.out.println("Operazione " + operation);

//		case "del":
//			subject = Integer.parseInt(req.getParameter("id"));
//			Film film = dbm.getDaoFactory().getFilmDAO().findByPrimaryKey(subject);
//			dbm.getDaoFactory().getFilmDAO().delete(film);
//			System.out.println("Soggetto da eliminare: " + subject);
//			res.setStatus(200);
//			break;
//
//		case "edit":
//			subject = Integer.parseInt(req.getParameter("id"));
//			anno = Integer.parseInt(req.getParameter("anno"));
//			durata = Integer.parseInt(req.getParameter("durata"));
//			titolo = req.getParameter("titolo");;
//			locandina = req.getParameter("locandina");
//			genere = req.getParameter("genere");
//			regista = req.getParameter("regista");
//			filmato = req.getParameter("filmato");
//			immagineForum = req.getParameter("immagineForum");
//			System.out.println("Soggetto da modificare | anno " + anno + " durata " + durata + " titolo: " + titolo + " locandina " + locandina + " genere " + genere + " regista " + regista + " filmato " + filmato + " immagine forum " + immagineForum);
//			Film editedFilm = new Film();
//			editedFilm.setId_film(subject);
//			editedFilm.setTitolo(titolo);
//			editedFilm.setAnno(anno);
//			editedFilm.setDurata(durata);
//			editedFilm.setGenere(genere);
//			editedFilm.setRegista(regista);
//			editedFilm.setLocandina(locandina);
//			editedFilm.setFilmato(filmato);
//			editedFilm.setImmagineForum(immagineForum);
//			System.out.println("FILMATO " + editedFilm.getFilmato());
//			dbm.getDaoFactory().getFilmDAO().update(editedFilm);
//			res.setStatus(200);
//			break;

		anno = Integer.parseInt(req.getParameter("anno"));
		durata = Integer.parseInt(req.getParameter("durata"));
		titolo = req.getParameter("titolo");;
		locandina = req.getParameter("locandina");
		genere = req.getParameter("genere");
		regista = req.getParameter("regista");
		filmato = req.getParameter("filmato");
		immagineForum = req.getParameter("immagineForum");

		System.out.println("Soggetto da aggiungere | anno " + anno + " durata " + durata + " titolo: " + titolo + " locandina " + locandina + " genere " + genere + " regista " + regista + " filmato " + filmato + " immagine forum " + immagineForum);
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
		System.out.println("FILMATO " + newFilm.getFilmato());
		dbm.getDaoFactory().getFilmDAO().save(newFilm);
		
		res.sendRedirect("gestionecontenuti");
	}
}