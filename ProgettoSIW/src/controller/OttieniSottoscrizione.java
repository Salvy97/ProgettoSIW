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
		Utente aassssddsasd = (Utente) session.getAttribute("user");
		System.out.println("[Ottieni Sottoscrizione] Utente in sessione " + aassssddsasd.getUsername());
		
		String operation = req.getParameter("operation");
		if (operation.equals("add")) {
		
			int abbType = Integer.parseInt(req.getParameter("id"));
			Abbonamento asd = DatabaseManager.getInstance().getDaoFactory().getAbbonamentoDAO().findByPrimaryKey(abbType);
			Sottoscrizione sottoscrizioneEsistente = DatabaseManager.getInstance().getDaoFactory().getSottoscrizioneDAO().findByUser(aassssddsasd.getId());
			Sottoscrizione asdddd = new Sottoscrizione();
			asdddd.setAbbonamento(asd);
			asdddd.setUser(aassssddsasd);
			LocalDate lt = LocalDate.now().plusDays(30);
			asdddd.setDueDate(lt.toString());
			
			if (sottoscrizioneEsistente != null) {
				
				if (sottoscrizioneEsistente.getAbbonamento().getId() == asdddd.getAbbonamento().getId()) {
					LocalDate data = LocalDate.parse(sottoscrizioneEsistente.getDueDate()).plusDays(30);
					asdddd.setDueDate(data.toString());
				}
				
				
				DatabaseManager.getInstance().getDaoFactory().getSottoscrizioneDAO().update(asdddd);				
			} else {
				DatabaseManager.getInstance().getDaoFactory().getSottoscrizioneDAO().save(asdddd);
			}
			session.setAttribute("sottoscrizione", asdddd);

		} else if (operation.equals("savepref")) {
			String userPP = req.getParameter("userpp");
			Boolean autoRenewd = Boolean.parseBoolean(req.getParameter("autorenew"));
			System.out.println("Aggiorno le preferenze: " + userPP + " autorinnovo: " + autoRenewd);
			aassssddsasd.setUsernamePP(userPP);
			aassssddsasd.setAutoRenew(autoRenewd);
			
			DatabaseManager.getInstance().getDaoFactory().getUtenteDAO().update(aassssddsasd);
		}
	}
}