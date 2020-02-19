package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Episodio;
import persistence.DatabaseManager;
import persistence.dao.EpisodioDao;


public class DammiEpisodi extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		
		EpisodioDao eDao = DatabaseManager.getInstance().getDaoFactory().getEpisodioDAO();
		List<Episodio> episodi = eDao.findAll();
		
		req.setAttribute("episodi", episodi);
		
		RequestDispatcher rd = req.getRequestDispatcher("serieTV.jsp");
		rd.forward(req, resp);
		
	}
}