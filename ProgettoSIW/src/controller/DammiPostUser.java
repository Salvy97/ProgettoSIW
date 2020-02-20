package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Post;
import persistence.DatabaseManager;
import persistence.dao.PostDao;

public class DammiPostUser extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String username = req.getParameter("username");

		PostDao fDao = DatabaseManager.getInstance().getDaoFactory().getPostDAO();
		List<Post> posts = fDao.findPostsOfThatUser(username);
		
		req.setAttribute("posts", posts);
		
		RequestDispatcher rd = req.getRequestDispatcher("userPosts.jsp");
		rd.forward(req, resp);
	}
}