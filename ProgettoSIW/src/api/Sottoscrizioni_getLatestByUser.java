package api;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import model.Sottoscrizione;
import persistence.DatabaseManager;

@SuppressWarnings("serial")
public final class Sottoscrizioni_getLatestByUser extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		if (req.getSession(false).getAttribute("name") != null) {
			String username = (String) req.getSession(false).getAttribute("name");
			DatabaseManager dbm = persistence.DatabaseManager.getInstance();
			Sottoscrizione sottoscrizione = dbm.getDaoFactory().getSottoscrizioneDAO().findByUser(username);
			
			String json = new Gson().toJson(sottoscrizione);
			
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
			res.getWriter().write(json);
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
	}
}