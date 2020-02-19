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
import persistence.dao.StagioneDao;


public class DammiStagioni extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		
		StagioneDao sDao = DatabaseManager.getInstance().getDaoFactory().getStagioneDAO();
		List<Stagione> stagioni = sDao.findAll();
		
		req.setAttribute("stagioni", stagioni);
		
		RequestDispatcher rd = req.getRequestDispatcher("serieTV.jsp");
		rd.forward(req, resp);
		
	}
}