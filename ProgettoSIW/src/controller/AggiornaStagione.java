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
		
		Stagione editedStagione = new Stagione();
		editedStagione.setId_stagione(idStagione);
		editedStagione.setNumero_episodi(numeroEpisodi);

		dbm.getDaoFactory().getStagioneDAO().update(editedStagione);
		
		res.sendRedirect("gestioneStagioni?id=" + Integer.parseInt(req.getParameter("idSerieTV")));
	}
}