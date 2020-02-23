package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Stagione;
import persistence.DatabaseManager;

@SuppressWarnings("serial")
public class GestioneStagioni extends HttpServlet 
{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int idSerieTV = Integer.parseInt(req.getParameter("id"));
		
		List<Stagione> stagioni = DatabaseManager.getInstance().getDaoFactory().getStagioneDAO().cercaPerIdSerie(idSerieTV);
		req.setAttribute("stagioni", stagioni);
			
		RequestDispatcher rd  = req.getRequestDispatcher("gestioneStagioni.jsp");
		rd.forward(req, resp);
	}
}
