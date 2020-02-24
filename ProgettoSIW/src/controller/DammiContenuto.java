package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.ContenutoPreferito;
import model.Film;
import persistence.DatabaseManager;
import persistence.dao.FilmDao;


public class DammiContenuto extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		HttpSession session = req.getSession();
		Boolean abbonamento = (Boolean) session.getAttribute("abbonamento");
		
		if(session.getAttribute("name") != null)
        {
			if (abbonamento == true)
			{
				FilmDao fDao = DatabaseManager.getInstance().getDaoFactory().getFilmDAO();
				Film film = fDao.cercaPerId(Integer.parseInt(req.getParameter("id")));
				
				List<ContenutoPreferito> contenutiPreferiti = DatabaseManager.getInstance().getDaoFactory().getContenutiPreferitiDAO().findFilmsByUsername((String) session.getAttribute("name"));
				boolean alreadyFav = false;
				for (int i = 0; i < contenutiPreferiti.size(); i++)
					if (contenutiPreferiti.get(i).getIdContenuto() == Integer.parseInt(req.getParameter("id")))
						alreadyFav = true;
					
				if (alreadyFav)
					session.setAttribute("fav", true);
				else
					session.setAttribute("fav", false);
				
				req.setAttribute("film", film);
							
				RequestDispatcher rd = req.getRequestDispatcher("contenuto.jsp");
				rd.forward(req, resp);
			}
			else
			{
				RequestDispatcher rd = req.getRequestDispatcher("ottieniIndex");
				rd.forward(req, resp);
			}
        }
		else
		{
			RequestDispatcher rd = req.getRequestDispatcher("ottieniIndex");
			rd.forward(req, resp);
		}
	}
}