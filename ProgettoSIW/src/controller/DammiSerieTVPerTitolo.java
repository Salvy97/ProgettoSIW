package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.SerieTV;
import persistence.DatabaseManager;
import persistence.dao.SerieTVDao;

public class DammiSerieTVPerTitolo extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		SerieTVDao sDao = DatabaseManager.getInstance().getDaoFactory().getSerieTVDAO();
		
		System.out.println(req.getParameter("title"));
		
		
		if(req.getParameter("title")!=null && !req.getParameter("title").equals(""))
		{
			List<SerieTV> serieTVs = sDao.cercaPerTitolo(req.getParameter("title"));
			
			String json = new Gson().toJson(serieTVs);
			
			PrintWriter out = resp.getWriter();
	        resp.setContentType("application/json");
	        resp.setCharacterEncoding("UTF-8");
	        out.print(json);
	        out.flush();
		}
	}
}