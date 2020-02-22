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
import model.Utente;
import persistence.DatabaseManager;
import persistence.dao.UtenteDAO;

public class CercaUtente extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String username = req.getParameter("username");
		
		if (username != null)
		{
			UtenteDAO uDao = DatabaseManager.getInstance().getDaoFactory().getUtenteDAO();
			List<Utente> utenti = uDao.findByUsernameContains(username);
			
			JSONArray jsonAr = new JSONArray();
			
			if (!utenti.isEmpty())
			{
				for (int i = 0; i < utenti.size(); i++)
				{
					JSONObject obj = new JSONObject(utenti.get(i));
					jsonAr.put(obj);
				}
			}
				
			resp.setContentType("application/json");
			PrintWriter out = resp.getWriter();
			out.print(jsonAr);
		}
	}
}