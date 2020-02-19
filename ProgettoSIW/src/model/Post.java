package model;

import java.util.ArrayList;
import java.util.List;

public class Post 
{
	private int id;
	private String data;
	private String ora;
	private String titolo;
	private String descrizione;
	private String username;
	private int contenuto;
	private String profileImage;
	private List<Commento> commenti;
	
	public Post() { setCommenti(new ArrayList<Commento>()); }

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getOra() {
		return ora;
	}
	public void setOra(String ora) {
		this.ora = ora;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getContenuto() {
		return contenuto;
	}
	public void setContenuto(int contenuto) {
		this.contenuto = contenuto;
	}
	public String getProfileImage() {
		return profileImage;
	}
	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}
	public List<Commento> getCommenti() {
		return commenti;
	}
	public void setCommenti(List<Commento> commenti) {
		this.commenti = commenti;
	}
}