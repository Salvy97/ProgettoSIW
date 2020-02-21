
package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Sottoscrizione;
import model.Utente;
import persistence.DatabaseManager;

@SuppressWarnings("serial")
public final class FintoLogin extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		HttpSession session = req.getSession(true);
		
		Utente user = DatabaseManager.getInstance().getDaoFactory().getUtenteDAO().findByPrimaryKey(2);
		Sottoscrizione sottoscrizione = DatabaseManager.getInstance().getDaoFactory().getSottoscrizioneDAO().findByUser(user.getUsername());
		System.out.println("[Finto login] utente in sessione " + user.getUsername() + " id " + user.getId());
		
		session.setAttribute("user", user);
		session.setAttribute("username", user.getUsername());
		session.setAttribute("sottoscrizione", sottoscrizione);
		
		if (sottoscrizione != null) session.setAttribute("sottoscrizione-duedate", sottoscrizione.getDueDate());
		session.setAttribute("role", user.getRole());
		if (user.getUsernamePP() != null) {
			session.setAttribute("pp", "present");			
		} else {
			session.setAttribute("pp", "not-present");
		}

		req.setAttribute("user", user);
		RequestDispatcher rd = req.getRequestDispatcher("ok.jsp");
		rd.forward(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
	}
}