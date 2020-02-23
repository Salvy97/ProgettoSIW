package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Profilo;
import model.Utente;
import persistence.DatabaseManager;
import persistence.dao.ProfiloDAO;
import persistence.dao.UtenteDAO;

public class SignUp extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String username = req.getParameter("username");
		String nome = req.getParameter("nome");
		String cognome = req.getParameter("cognome");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		Utente utente = new Utente();
		Profilo profilo = new Profilo();
		
		utente.setRole("user");
		
		utente.setUsername(username);
		utente.setNome(nome);
		utente.setCognome(cognome);
		utente.setEmail(email);
		utente.setPassword(password);
		
		profilo.setUsername(username);
		
		UtenteDAO uDao = DatabaseManager.getInstance().getDaoFactory().getUtenteDAO();
		uDao.save(utente);
		ProfiloDAO pDao = DatabaseManager.getInstance().getDaoFactory().getProfiloDAO();
		pDao.save(profilo);
		
		req.getSession().setAttribute("message", "Registrato con successo!");
    	resp.sendRedirect("ottieniLogin");	
	}
}