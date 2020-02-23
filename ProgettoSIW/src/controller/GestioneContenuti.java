package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Film;
import persistence.DatabaseManager;

@SuppressWarnings("serial")
public class GestioneContenuti extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("no.jsp");
		if (req.getSession(false).getAttribute("role").equals("admin")) {
			rd = req.getRequestDispatcher("GestioneContenuti.jsp");
		}
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		DatabaseManager dbm = DatabaseManager.getInstance();
		String operation = (String) req.getParameter("operation");
		int subject;
		int anno;
		int durata;
		String titolo;
		String locandina;
		String genere;
		String filmato;
		System.out.println("Operazione " + operation);
		switch (operation) {
		case "del":
			subject = Integer.parseInt(req.getParameter("id"));
			Film film = dbm.getDaoFactory().getFilmDAO().cercaPerId(subject);
			dbm.getDaoFactory().getFilmDAO().delete(film);
			System.out.println("Soggetto da eliminare: " + subject);
			res.setStatus(200);
			break;

		case "edit":
			subject = Integer.parseInt(req.getParameter("id"));
			anno = Integer.parseInt(req.getParameter("anno"));
			durata = Integer.parseInt(req.getParameter("durata"));
			titolo = req.getParameter("titolo");;
			locandina = req.getParameter("locandina");
			genere = req.getParameter("genere");
			filmato = req.getParameter("filmato");
			System.out.println("Soggetto da modificare | anno " + anno + " durata " + durata + " titolo: " + titolo + " locandina " + locandina + " genere " + genere + " link " + filmato);
			Film editedFilm = new Film();
			editedFilm.setId_film(subject);
			editedFilm.setTitolo(titolo);
			editedFilm.setAnno(anno);
			editedFilm.setDurata(durata);
			editedFilm.setGenere(genere);
			editedFilm.setLocandina(locandina);
			editedFilm.setFilmato(filmato);
			System.out.println("LINK " + editedFilm.getFilmato());
			dbm.getDaoFactory().getFilmDAO().update(editedFilm);
			res.setStatus(200);
			break;
			
			
		case "save":
//			Random random = new Random();
//			subject = req.getParameter("id");
//			int randomInteger = random.nextInt(10000000);
			//subject = Integer.parseInt(req.getParameter("id"));
			anno = Integer.parseInt(req.getParameter("anno"));
			durata = Integer.parseInt(req.getParameter("durata"));
			titolo = req.getParameter("titolo");;
			locandina = req.getParameter("locandina");
			genere = req.getParameter("genere");
			filmato = req.getParameter("filmato");

			System.out.println("Soggetto da aggiungere | anno " + anno + " durata " + durata + " titolo: " + titolo + " locandina " + locandina + " genere " + genere + " link " + filmato);
			Film newFilm = new Film();
			newFilm.setId_film(-1);
			newFilm.setTitolo(titolo);
			newFilm.setAnno(anno);
			newFilm.setDurata(durata);
			newFilm.setGenere(genere);
			newFilm.setLocandina(locandina);
			newFilm.setFilmato(filmato);
			System.out.println("LINK " + newFilm.getFilmato());
			dbm.getDaoFactory().getFilmDAO().save(newFilm);
			res.setStatus(200);
			break;

		default:
			res.setStatus(200);
			break;
		}


	}
}
