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
import persistence.dao.SerieTVDao;

public class DammiSerieTV extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		
		SerieTVDao sDao = DatabaseManager.getInstance().getDaoFactory().getSerieTVDAO();
		List<SerieTV> serieTVs = sDao.findAll();
		
		req.setAttribute("serieTVs", serieTVs);
		
		RequestDispatcher rd = req.getRequestDispatcher("serieTV.jsp");
		rd.forward(req, resp);
		
	}
}