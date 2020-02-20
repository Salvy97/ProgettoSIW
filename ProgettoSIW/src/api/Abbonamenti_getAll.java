package api;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import model.Abbonamento;
import persistence.DatabaseManager;

@SuppressWarnings("serial")
public final class Abbonamenti_getAll extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		DatabaseManager dbm = DatabaseManager.getInstance();
		List<Abbonamento> subTypes = new LinkedList<>();
		subTypes = dbm.getDaoFactory().getAbbonamentoDAO().findAll();
		System.out.println("LUL");
		String json = new Gson().toJson(subTypes);

		res.setContentType("application/json");
		res.setCharacterEncoding("UTF-8");
		res.getWriter().write(json);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
	}
}