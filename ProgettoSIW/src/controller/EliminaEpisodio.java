package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Episodio;
import persistence.DatabaseManager;

public class EliminaEpisodio extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException 
	{
		int idEpisodio = Integer.parseInt(req.getParameter("id"));
		
		Episodio episodio = new Episodio();
		episodio.setId_episodio(idEpisodio);
		
		DatabaseManager.getInstance().getDaoFactory().getEpisodioDAO().delete(episodio);
		
		res.sendRedirect("gestioneSerieTV");
	}
}