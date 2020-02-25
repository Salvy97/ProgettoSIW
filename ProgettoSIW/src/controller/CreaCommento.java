package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Commento;
import model.Notifica;
import model.Post;
import persistence.DatabaseManager;
import persistence.dao.CommentoDAO;

public class CreaCommento extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		HttpSession session = req.getSession(false);
		
		String username = (String) session.getAttribute("name");
		String comment = req.getParameter("commento");
		String contenuto = req.getParameter("contenuto");
		int idPost = Integer.parseInt(req.getParameter("post"));
		
		Commento commento = new Commento();
		commento.setCommento(comment);
		commento.setUsername(username);
		commento.setPost(idPost);
		
		if (comment != null)
		{
			CommentoDAO fDao = DatabaseManager.getInstance().getDaoFactory().getCommentoDAO();
			fDao.save(commento);
			
			Notifica notifica = new Notifica();
			Post post = DatabaseManager.getInstance().getDaoFactory().getPostDAO().findByPrimaryKey(idPost);
			notifica.setPost(post);
			notifica.setUsername(post.getUsername());
			notifica.setCommento(commento);
			DatabaseManager.getInstance().getDaoFactory().getNotificaDAO().save(notifica);
			
			resp.sendRedirect("ottieniPost?contenuto=" + contenuto);
		}
	}
}