package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Stagione;
import persistence.DatabaseManager;

public class AggiornaStagione extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		DatabaseManager dbm = DatabaseManager.getInstance();
		
		int idStagione = Integer.parseInt(req.getParameter("idStagione")); 
		int numeroEpisodi = Integer.parseInt(req.getParameter("numeroEpisodi"));
		int numeroStagione = Integer.parseInt(req.getParameter("numeroStagione"));
		
		Stagione editedStagione = new Stagione();
		editedStagione.setId_stagione(idStagione);
		editedStagione.setNumero_episodi(numeroEpisodi);
		editedStagione.setStagione(numeroStagione);

		dbm.getDaoFactory().getStagioneDAO().update(editedStagione);
		
		res.sendRedirect("gestioneSerieTV");
	}
}