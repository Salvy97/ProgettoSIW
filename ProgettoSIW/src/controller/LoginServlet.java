package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Utente;
import persistence.DatabaseManager;
import persistence.dao.UtenteDAO;

@WebServlet(value = "/LoginServlet")
public class LoginServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		       
		HttpSession session = req.getSession();
		
        String email = req.getParameter("email");  
        String password = req.getParameter("password");  
        
        UtenteDAO uDao = DatabaseManager.getInstance().getDaoFactory().getUtenteDAO();
        Utente utente = uDao.findByEmail(email);
        if (utente == null)
        {  
        	session.setAttribute("error", "email");
        	resp.sendRedirect("ottieniLogin");	
        }
        else
        {
	        if (password.equals(utente.getPassword()))
	        {   
		        session.setAttribute("name", utente.getUsername());
		        session.setAttribute("error", "none");
		        session.setAttribute("role", utente.getRole());
		        resp.sendRedirect("ottieniIndex");
	        }
	        else
	        {
	        	session.setAttribute("error", "password");
	        	resp.sendRedirect("ottieniLogin");
	        }
        }
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {}
}