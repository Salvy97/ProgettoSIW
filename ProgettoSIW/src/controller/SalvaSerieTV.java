package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.SerieTV;
import persistence.DatabaseManager;

public class SalvaSerieTV extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		String titolo = req.getParameter("titolo");
		int anno = Integer.parseInt(req.getParameter("anno"));
		String genere = req.getParameter("genere");
		String locandina = req.getParameter("locandina");
		String immagineForum = req.getParameter("immagineForum");
		
		SerieTV serieTV = new SerieTV();
		serieTV.setTitolo(titolo);
		serieTV.setAnno(anno);
		serieTV.setGenere(genere);
		serieTV.setLocandina(locandina);
		serieTV.setImmagineForum(immagineForum);
		
		DatabaseManager.getInstance().getDaoFactory().getSerieTVDAO().save(serieTV);
		
		res.sendRedirect("gestioneSerieTV");
	}
}