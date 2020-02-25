package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Notifica;
import persistence.DatabaseManager;

public class EliminaNotifica extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int idNotifica = Integer.parseInt(req.getParameter("idNotifica"));
		
		Notifica notifica = new Notifica();
		notifica.setIdNotifica(idNotifica);
		DatabaseManager.getInstance().getDaoFactory().getNotificaDAO().delete(notifica);
	}
}