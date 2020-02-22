package model;

import java.util.Date;

public class Episodio {
	private int id_episodio;
	private String titolo;
	private int durata;
	private String filmato;
	private Date data_inserimento;
	private int visualizzazioni;
	private int numero_episodio;
	private String sinossi;
	private Stagione stagione;


	public Episodio(){}
	
	public Episodio(int id_episodio, String titolo, int durata, String filmato, Date data_inserimento, int visualizzazioni, int numero_episodio, String sinossi, Stagione stagione){
		this.id_episodio = id_episodio;
		this.titolo = titolo;
		this.durata = durata;
		this.filmato = filmato;
		this.data_inserimento = data_inserimento;
		this.visualizzazioni = visualizzazioni;
		this.numero_episodio = numero_episodio;
		this.sinossi = sinossi;
		this.stagione = stagione;
	}


	public int getId_episodio() {
		return id_episodio;
	}

	public void setId_episodio(int id_episodio) {
		this.id_episodio = id_episodio;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public int getDurata() {
		return durata;
	}

	public void setDurata(int durata) {
		this.durata = durata;
	}
	
	public String getFilmato() {
		return filmato;
	}

	public void setFilmato(String filmato) {
		this.filmato = filmato;
	}

	public Date getData_inserimento() {
		return data_inserimento;
	}

	public void setData_inserimento(Date data_inserimento) {
		this.data_inserimento = data_inserimento;
	}

	public int getVisualizzazioni() {
		return visualizzazioni;
	}

	public void setVisualizzazioni(int visualizzazioni) {
		this.visualizzazioni = visualizzazioni;
	}
	
	public int getNumero_episodio() {
		return numero_episodio;
	}

	public void setNumero_episodio(int numero_episodio) {
		this.numero_episodio = numero_episodio;
	}
	
	public String getSinossi() {
		return sinossi;
	}

	public void setSinossi(String sinossi) {
		this.sinossi = sinossi;
	}
	
	public Stagione getStagione() {
		return stagione;
	}

	public void setStagione(Stagione stagione) {
		this.stagione = stagione;
	}
	
}