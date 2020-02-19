package model;

public class Sottoscrizione {
	private int id;
	private Utente user;
	private Abbonamento abb;
	private String dueDate;
	
	public Sottoscrizione() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Abbonamento getAbbonamento() {
		return abb;
	}
	public void setAbbonamento(Abbonamento abb) {
		this.abb = abb;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String datadioggi) {
		this.dueDate = datadioggi;
	}

	public Utente getUser() {
		return user;
	}

	public void setUser(Utente user) {
		this.user = user;
	}

}
