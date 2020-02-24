package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ContenutoPreferito;
import persistence.DatabaseManager;

public class GestisciFilmPreferito extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		ContenutoPreferito contenutoPreferito = new ContenutoPreferito();
		
		contenutoPreferito.setUsername((String)req.getSession().getAttribute("name"));
		contenutoPreferito.setIdContenuto(Integer.parseInt(req.getParameter("contenuto")));
		
		List<ContenutoPreferito> contenutiPreferiti = DatabaseManager.getInstance().getDaoFactory().getContenutiPreferitiDAO().findFilmsByUsername(contenutoPreferito.getUsername());
		boolean alreadyFav = false;
		for (int i = 0; i < contenutiPreferiti.size(); i++)
			if (contenutiPreferiti.get(i).getIdContenuto() == contenutoPreferito.getIdContenuto())
				alreadyFav = true;
		
		if (!alreadyFav)
			DatabaseManager.getInstance().getDaoFactory().getContenutiPreferitiDAO().saveFilm(contenutoPreferito);
		else
			DatabaseManager.getInstance().getDaoFactory().getContenutiPreferitiDAO().deleteFilm(contenutoPreferito);
		resp.sendRedirect("ottieniContenuto?id=" + Integer.parseInt(req.getParameter("contenuto")));
	}
}