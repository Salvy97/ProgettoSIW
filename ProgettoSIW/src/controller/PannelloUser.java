package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Profilo;
import persistence.DatabaseManager;
import persistence.dao.ProfiloDAO;

@SuppressWarnings("serial")
public class PannelloUser extends HttpServlet 
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		RequestDispatcher rd = req.getRequestDispatcher("ottieniIndex");
		String username = req.getParameter("username");
		if (username != null) 
		{
			ProfiloDAO pDao = DatabaseManager.getInstance().getDaoFactory().getProfiloDAO();
			Profilo profilo = pDao.findByUsername(username);
			req.setAttribute("profilo", profilo);
			rd = req.getRequestDispatcher("profilo.jsp");
		}
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		doGet(req, resp);
	}
}