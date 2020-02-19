package model;

public class Utente 
{
	private int id;
	private String username;
	private String role;
	private String hash;
	private Sottoscrizione sottoscrizione;
	private String usernamePP;
	private Boolean autoRenew;
	private String email;
	private String password;
	private String nome;
	private String cognome;
	
	public Boolean getAutoRenew() {
		return autoRenew;
	}

	public void setAutoRenew(Boolean autoRenew) {
		this.autoRenew = autoRenew;
	}

	public Utente() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public Sottoscrizione getSottoscrizione() {
		return sottoscrizione;
	}

	public void setSottoscrizione(Sottoscrizione sottoscrizione) {
		this.sottoscrizione = sottoscrizione;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsernamePP() {
		return usernamePP;
	}

	public void setUsernamePP(String usernamePP) {
		this.usernamePP = usernamePP;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
}