package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ContenutoPreferito;
import model.SerieTV;
import model.Stagione;
import persistence.DatabaseManager;
import persistence.dao.SerieTVDao;
import persistence.dao.StagioneDao;


public class DammiStagioni extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		
		SerieTVDao sDao = DatabaseManager.getInstance().getDaoFactory().getSerieTVDAO();
		SerieTV serieTV = sDao.cercaPerId(Integer.parseInt(req.getParameter("id_serie")));
		
		StagioneDao stDao = DatabaseManager.getInstance().getDaoFactory().getStagioneDAO();
		List<Stagione> stagioni = stDao.cercaPerIdSerie(Integer.parseInt(req.getParameter("id_serie")));
		
		req.setAttribute("serieTV", serieTV);
		req.setAttribute("stagioni", stagioni);
		
		List<ContenutoPreferito> contenutiPreferiti = DatabaseManager.getInstance().getDaoFactory().getContenutiPreferitiDAO().findSerieTVsByUsername((String) req.getSession().getAttribute("name"));
		boolean alreadyFav = false;
		for (int i = 0; i < contenutiPreferiti.size(); i++)
			if (contenutiPreferiti.get(i).getIdContenuto() == Integer.parseInt(req.getParameter("id_serie")))
				alreadyFav = true;
			
		if (alreadyFav)
			req.getSession().setAttribute("fav", true);
		else
			req.getSession().setAttribute("fav", false);
		
		RequestDispatcher rd = req.getRequestDispatcher("stagioni.jsp");
		rd.forward(req, resp);
	}
}