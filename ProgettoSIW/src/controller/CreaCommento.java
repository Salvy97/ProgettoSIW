package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Commento;
import model.Utente;
import persistence.DatabaseManager;
import persistence.dao.CommentoDAO;

public class CreaCommento extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		HttpSession session = req.getSession(false);
		
		String comment = req.getParameter("commento");
		String contenuto = req.getParameter("contenuto");
		int post = Integer.parseInt(req.getParameter("post"));
		
		Commento commento = new Commento();
		commento.setCommento(comment);
		commento.setUsername(((Utente)session.getAttribute("user")).getUsername());
		commento.setPost(post);
		
		if (comment != null)
		{
			CommentoDAO fDao = DatabaseManager.getInstance().getDaoFactory().getCommentoDAO();
			fDao.save(commento);
			resp.sendRedirect("ottieniPost?contenuto=" + contenuto);
		}
	}
}