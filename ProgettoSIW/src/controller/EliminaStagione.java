package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Stagione;
import persistence.DatabaseManager;

public class EliminaStagione extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		int idStagione = Integer.parseInt(req.getParameter("id"));
		
		Stagione stagione = new Stagione();
		stagione.setId_stagione(idStagione);
		
		DatabaseManager.getInstance().getDaoFactory().getStagioneDAO().delete(stagione);
		
		res.sendRedirect("gestioneSerieTV");
	}
}