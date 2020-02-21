package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import model.Film;
import model.SerieTV;
import persistence.DatabaseManager;
import persistence.dao.FilmDao;
import persistence.dao.SerieTVDao;

public class CercaContenuto extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String titolo = req.getParameter("titolo");
		
		if (titolo != null)
		{
			FilmDao fDao = DatabaseManager.getInstance().getDaoFactory().getFilmDAO();
			List<Film> films = fDao.findByTitle(titolo);
			
			SerieTVDao stDao = DatabaseManager.getInstance().getDaoFactory().getSerieTVDAO();
			List<SerieTV> serieTvs = stDao.cercaPerTitolo(titolo);
			
			JSONArray jsonAr = new JSONArray();
			
			if (!films.isEmpty())
			{
				for (int i = 0; i < films.size(); i++)
				{
					JSONObject obj = new JSONObject(films.get(i));
					jsonAr.put(obj);
				}
			}
			if (!serieTvs.isEmpty())
			{
				for (int i = 0; i < serieTvs.size(); i++)
				{
					JSONObject obj = new JSONObject(serieTvs.get(i));
					jsonAr.put(obj);
				}
			}
				
			resp.setContentType("application/json");
			PrintWriter out = resp.getWriter();
			out.print(jsonAr);
		}
	}
}