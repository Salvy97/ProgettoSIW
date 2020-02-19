package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.Film;
import persistence.DatabaseManager;
import persistence.dao.FilmDao;

public class DammiFilmPerCarattere extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println(req.getParameter("character"));
		
		FilmDao fDao = DatabaseManager.getInstance().getDaoFactory().getFilmDAO();
		List<Film> films = fDao.cercaPerCarattere(req.getParameter("character"));
		
		String json = new Gson().toJson(films);
		
		PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        out.print(json);
        out.flush();
		
	}
}