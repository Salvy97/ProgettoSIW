package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Episodio;
import model.Stagione;
import persistence.DatabaseManager;

@SuppressWarnings("serial")
public class GestioneEpisodi extends HttpServlet 
{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int idStagione = Integer.parseInt(req.getParameter("id"));
		
		List<Episodio> episodi = DatabaseManager.getInstance().getDaoFactory().getEpisodioDAO().cercaPerIdStagione(idStagione);
		Stagione stagione =  DatabaseManager.getInstance().getDaoFactory().getStagioneDAO().cercaPerId(idStagione);
		req.setAttribute("episodi", episodi);
		req.setAttribute("stagione", stagione);
		req.setAttribute("serieTV", stagione.getSerieTV());
			
		RequestDispatcher rd  = req.getRequestDispatcher("gestioneEpisodi.jsp");
		rd.forward(req, resp);
	}
}