package controller;

import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Utente;
import model.Sottoscrizione;
import model.Abbonamento;
import persistence.DatabaseManager;

@SuppressWarnings("serial")
public final class OttieniSottoscrizione extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		// RequestDispatcher rd = req.getRequestDispatcher("abbonati.jsp");
		// rd.forward(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		HttpSession session = req.getSession(false);
		String username = (String) session.getAttribute("name");
		Utente utente = DatabaseManager.getInstance().getDaoFactory().getUtenteDAO().findByUsername(username);
		System.out.println("[Ottieni Sottoscrizione] Utente in sessione " + utente.getUsername());
		
		String operation = req.getParameter("operation");
		if (operation.equals("add")) {
		
			int abbType = Integer.parseInt(req.getParameter("id"));
			Abbonamento abbonamento = DatabaseManager.getInstance().getDaoFactory().getAbbonamentoDAO().findByPrimaryKey(abbType);
			Sottoscrizione sottoscrizioneEsistente = DatabaseManager.getInstance().getDaoFactory().getSottoscrizioneDAO().findByUser(username);
			Sottoscrizione sottoscrizione = new Sottoscrizione();
			sottoscrizione.setAbbonamento(abbonamento);
			sottoscrizione.setUser(utente);
			LocalDate lt = LocalDate.now().plusDays(30);
			sottoscrizione.setDueDate(lt.toString());
			
			if (sottoscrizioneEsistente != null) {
				
				if (sottoscrizioneEsistente.getAbbonamento().getId() == sottoscrizione.getAbbonamento().getId()) {
					LocalDate data = LocalDate.parse(sottoscrizioneEsistente.getDueDate()).plusDays(30);
					sottoscrizione.setDueDate(data.toString());
				}
				
				
				DatabaseManager.getInstance().getDaoFactory().getSottoscrizioneDAO().update(sottoscrizione);				
			} else {
				DatabaseManager.getInstance().getDaoFactory().getSottoscrizioneDAO().save(sottoscrizione);
			}

		} else if (operation.equals("savepref")) {
			String userPP = req.getParameter("userpp");
			Boolean autoRenewd = Boolean.parseBoolean(req.getParameter("autorenew"));
			System.out.println("Aggiorno le preferenze: " + userPP + " autorinnovo: " + autoRenewd);
			utente.setUsernamePP(userPP);
			utente.setAutoRenew(autoRenewd);

			DatabaseManager.getInstance().getDaoFactory().getUtenteDAO().update(utente);
		}
	}
}