package model;

public class Episodio {
	private String id_episodio;
	private String titolo;
	private String filmato;
	private int durata;
	private int numeroEpisodio;
	private Stagione stagione;


	public Episodio(){}
	
	public Episodio(String id_episodio, String titolo, int durata, Stagione stagione){
		this.id_episodio = id_episodio;
		this.titolo = titolo;
		this.durata = durata;
		this.stagione = stagione;
	}

	public String getId_episodio() {
		return id_episodio;
	}

	public void setId_episodio(String id_episodio) {
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

	public Stagione getStagione() {
		return stagione;
	}

	public void setStagione(Stagione stagione) {
		this.stagione = stagione;
	}

	public int getNumeroEpisodio() {
		return numeroEpisodio;
	}

	public void setNumeroEpisodio(int numeroEpisodio) {
		this.numeroEpisodio = numeroEpisodio;
	}

	public String getFilmato() {
		return filmato;
	}

	public void setFilmato(String filmato) {
		this.filmato = filmato;
	}
	
	
}