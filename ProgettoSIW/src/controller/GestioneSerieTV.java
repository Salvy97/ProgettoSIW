package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.SerieTV;
import persistence.DatabaseManager;

@SuppressWarnings("serial")
public class GestioneSerieTV extends HttpServlet 
{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		List<SerieTV> serieTVs = DatabaseManager.getInstance().getDaoFactory().getSerieTVDAO().findAll();
		req.setAttribute("serieTVs", serieTVs);
			
		RequestDispatcher rd  = req.getRequestDispatcher("gestioneSerieTV.jsp");
		rd.forward(req, resp);
	}
}
