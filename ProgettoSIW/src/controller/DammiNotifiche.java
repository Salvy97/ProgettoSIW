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
import model.Notifica;
import persistence.DatabaseManager;

public class DammiNotifiche extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		List<Notifica> notifiche = DatabaseManager.getInstance().getDaoFactory().getNotificaDAO().findNotificheByUsername((String) req.getSession().getAttribute("name"));
		
		JSONArray jsonAr = new JSONArray();
		
		if (!notifiche.isEmpty())
		{
			for (int i = 0; i < notifiche.size(); i++)
			{
				JSONObject obj = new JSONObject(notifiche.get(i));
				jsonAr.put(obj);
			}
		}
		
		resp.setContentType("application/json");
		PrintWriter out = resp.getWriter();
		out.print(jsonAr);
	}
}
