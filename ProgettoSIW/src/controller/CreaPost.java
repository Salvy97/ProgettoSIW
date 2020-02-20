package controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Post;
import persistence.DatabaseManager;
import persistence.dao.FilmDao;
import persistence.dao.PostDao;

public class CreaPost extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		HttpSession session = req.getSession(false);
		
		String titolo = req.getParameter("titolo");
		String descrizione = req.getParameter("descrizione");
		String contenuto = req.getParameter("contenuto");
		
		Date today = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");  
		String data = dateFormat.format(today).substring(0, 10);
		String ora = dateFormat.format(today).substring(11);
		String username = (String) session.getAttribute("name");
		
		Post post = new Post();
		
		post.setTitolo(titolo);
		post.setDescrizione(descrizione);
		post.setData(data);
		post.setOra(ora);
		post.setUsername(username);
		
		FilmDao fDao = DatabaseManager.getInstance().getDaoFactory().getFilmDAO();
		post.setContenuto(fDao.getIdFilmFromTitle(contenuto));

		if (titolo != null)
		{
			PostDao pDao = DatabaseManager.getInstance().getDaoFactory().getPostDAO();
			pDao.save(post);
			DatabaseManager.getInstance().getDaoFactory().getProfiloDAO().aumentaPostsCreati(username);
			resp.sendRedirect("ottieniPost?contenuto=" + contenuto);
		}
	}
}