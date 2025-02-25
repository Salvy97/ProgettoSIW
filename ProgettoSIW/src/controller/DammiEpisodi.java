package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Episodio;
import model.SerieTV;
import model.Stagione;
import persistence.DatabaseManager;
import persistence.dao.EpisodioDao;
import persistence.dao.SerieTVDao;
import persistence.dao.StagioneDao;


public class DammiEpisodi extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		
		SerieTVDao sDao = DatabaseManager.getInstance().getDaoFactory().getSerieTVDAO();
		SerieTV serieTV = sDao.cercaPerId(Integer.parseInt(req.getParameter("id_serie")));
		
		StagioneDao stDao = DatabaseManager.getInstance().getDaoFactory().getStagioneDAO();
		Stagione stagione = stDao.cercaPerId(Integer.parseInt(req.getParameter("id_stg")));
		
		EpisodioDao eDao = DatabaseManager.getInstance().getDaoFactory().getEpisodioDAO();
		List<Episodio> episodi = eDao.cercaPerIdStagione(Integer.parseInt(req.getParameter("id_stg")));
		
		req.setAttribute("serieTV", serieTV);
		req.setAttribute("stagione", stagione);
		req.setAttribute("episodi", episodi);
		
		RequestDispatcher rd = req.getRequestDispatcher("episodi.jsp");
		rd.forward(req, resp);
		
	}
}