package api;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import model.Film;
import persistence.DatabaseManager;

@SuppressWarnings("serial")
public final class Contenuti_getOne extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		int id = Integer.parseInt(req.getParameter("id"));
		DatabaseManager dbm = DatabaseManager.getInstance();
		Film film = dbm.getDaoFactory().getFilmDAO().cercaPerId(id);

		String json = new Gson().toJson(film);

		res.setContentType("application/json");
		res.setCharacterEncoding("UTF-8");
		res.getWriter().write(json);
	}
}