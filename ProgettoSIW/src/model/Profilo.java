package model;

public class Profilo 
{
	private int idProfilo;
	private String username;
	private int contenutiGuardati;
	private int postsCreati;
	private int recensioniEffettuate;
	private String immagineDiProfilo;
	private String email;
	private String nome;
	private String cognome;
	
	public Profilo() {}

	public int getIdProfilo() {
		return idProfilo;
	}

	public void setIdProfilo(int idProfilo) {
		this.idProfilo = idProfilo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getContenutiGuardati() {
		return contenutiGuardati;
	}

	public void setContenutiGuardati(int contenutiGuardati) {
		this.contenutiGuardati = contenutiGuardati;
	}

	public int getPostsCreati() {
		return postsCreati;
	}

	public void setPostsCreati(int postsCreati) {
		this.postsCreati = postsCreati;
	}

	public int getRecensioniEffettuate() {
		return recensioniEffettuate;
	}

	public void setRecensioniEffettuate(int recensioniEffettuate) {
		this.recensioniEffettuate = recensioniEffettuate;
	}

	public String getImmagineDiProfilo() {
		return immagineDiProfilo;
	}

	public void setImmagineDiProfilo(String immagineDiProfilo) {
		this.immagineDiProfilo = immagineDiProfilo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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