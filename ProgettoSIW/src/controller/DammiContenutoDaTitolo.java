package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Film;
import model.SerieTV;
import persistence.DatabaseManager;
import persistence.dao.FilmDao;
import persistence.dao.SerieTVDao;


public class DammiContenutoDaTitolo extends HttpServlet{
	
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
				Film film = fDao.cercaPerId(fDao.getIdFilmFromTitle(req.getParameter("contenuto")));
				
				if (film == null)
				{
					SerieTVDao sDao = DatabaseManager.getInstance().getDaoFactory().getSerieTVDAO();
					SerieTV serieTV = sDao.cercaPerId(sDao.getIdSerieTVFromTitle(req.getParameter("contenuto")));
				
					RequestDispatcher rd = req.getRequestDispatcher("ottieniStagioni?id_serie=" + serieTV.getId_serieTV());
					rd.forward(req, resp);
				}
				else
				{
					req.setAttribute("film", film);
					
					RequestDispatcher rd = req.getRequestDispatcher("ottieniContenuto?id=" + film.getId_film());
					rd.forward(req, resp);
				}
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