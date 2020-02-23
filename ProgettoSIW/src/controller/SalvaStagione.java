package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.SerieTV;
import model.Stagione;
import persistence.DatabaseManager;

public class SalvaStagione extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		int idSerieTV = Integer.parseInt(req.getParameter("idSerieTV"));
		int numeroStagione = Integer.parseInt(req.getParameter("numeroStagione"));
		
		Stagione stagione = new Stagione();
		stagione.setNumero_episodi(0);
		stagione.setStagione(numeroStagione);
		SerieTV serieTV = new SerieTV();
		serieTV.setId_serieTV(idSerieTV);
		stagione.setSerieTV(serieTV);
		
		DatabaseManager.getInstance().getDaoFactory().getStagioneDAO().save(stagione);
		
		res.sendRedirect("gestioneStagioni?id=" + idSerieTV);
	}
}