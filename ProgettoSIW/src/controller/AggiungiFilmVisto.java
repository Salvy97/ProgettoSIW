package controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ContenutoGuardato;
import persistence.DatabaseManager;

public class AggiungiFilmVisto extends HttpServlet
{
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		ContenutoGuardato contenutoGuardato = new ContenutoGuardato();
		
		contenutoGuardato.setUsername((String)req.getSession().getAttribute("name"));
		contenutoGuardato.setIdContenuto(Integer.parseInt(req.getParameter("contenuto")));
		
		Date today = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");  
		String data = dateFormat.format(today).substring(0, 10);
		contenutoGuardato.setDataVisualizzazione(data);
		
		List<ContenutoGuardato> contenutiGuardatiDaUtente = DatabaseManager.getInstance().getDaoFactory().getContenutiGuardatiDAO().searchFilmsWatchedByUser(contenutoGuardato.getUsername());
		boolean alreadyWatched = false;
		for (int i = 0; i < contenutiGuardatiDaUtente.size(); i++)
			if (contenutiGuardatiDaUtente.get(i).getIdContenuto() == contenutoGuardato.getIdContenuto())
				alreadyWatched = true;
		
		if (!alreadyWatched)
		{
			DatabaseManager.getInstance().getDaoFactory().getContenutiGuardatiDAO().saveFilm(contenutoGuardato);
			DatabaseManager.getInstance().getDaoFactory().getProfiloDAO().aumentaContenutiGuardati((String)req.getSession().getAttribute("name"));
			DatabaseManager.getInstance().getDaoFactory().getFilmDAO().incrementaVisualizzazioni(Integer.parseInt(req.getParameter("contenuto")));
		}
	}
}
