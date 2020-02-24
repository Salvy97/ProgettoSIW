package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Rating;
import persistence.DatabaseManager;

public class ValutaEpisodio extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		float ratingValue = Float.parseFloat(req.getParameter("rating"));
		String username = (String) req.getSession().getAttribute("name");
		int idEpisodio = Integer.parseInt(req.getParameter("contenuto"));
		
		Rating rating = new Rating();
		rating.setUsername(username);
		rating.setRating(ratingValue);
		rating.setIdContenuto(idEpisodio);
		
		DatabaseManager.getInstance().getDaoFactory().getRatingDAO().saveRatingEpisodio(rating);
	}
}