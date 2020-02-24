package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Episodio;
import model.SerieTV;
import model.Stagione;
import persistence.DatabaseManager;
import persistence.dao.EpisodioDao;
import persistence.dao.SerieTVDao;
import persistence.dao.StagioneDao;


public class DammiEpisodio extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		Boolean abbonamento = (Boolean) session.getAttribute("abbonamento");
		
		if(session.getAttribute("name") != null)
        {
			if (abbonamento == true)
			{
				SerieTVDao sDao = DatabaseManager.getInstance().getDaoFactory().getSerieTVDAO();
				SerieTV serieTV = sDao.cercaPerId(Integer.parseInt(req.getParameter("id_serie")));
				
				StagioneDao stDao = DatabaseManager.getInstance().getDaoFactory().getStagioneDAO();
				Stagione stagione = stDao.cercaPerId(Integer.parseInt(req.getParameter("id_stg")));
		
				EpisodioDao eDao = DatabaseManager.getInstance().getDaoFactory().getEpisodioDAO();
				Episodio episodio = eDao.cercaPerId(Integer.parseInt(req.getParameter("id_ep")));
				
				req.setAttribute("serieTV", serieTV);
				req.setAttribute("stagione", stagione);
				req.setAttribute("episodio", episodio);
				
				RequestDispatcher rd = req.getRequestDispatcher("episodio.jsp");
				rd.forward(req, resp);
			}
			else
			{
				RequestDispatcher rd = req.getRequestDispatcher("ottieniIndex");
				rd.forward(req, resp);
			}
        }
		else
		{
			RequestDispatcher rd = req.getRequestDispatcher("ottieniIndex");
			rd.forward(req, resp);
		}
	}
}