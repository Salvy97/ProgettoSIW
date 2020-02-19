package model;

import java.sql.Date;

public class Film 
{
	private int id_film;
	private String titolo;
	private int anno;
	private int durata;
	private String genere;
	private String locandina;
	private String regista;
	private String filmato;
	private Date data_inserimento;
	private int visualizzazioni;
	private String immagineForum;

	public Film() {}
	
	public Film(int id_film,String titolo,int anno,int durata,String genere,String locandina, String regista, String filmato, Date data_inserimento, int visualizzazioni, String immagineForum){
		this.id_film = id_film;
		this.titolo = titolo;
		this.anno = anno;
		this.durata = durata;
		this.genere = genere;
		this.locandina = locandina;
		this.regista = regista;
		this.filmato = filmato;
		this.data_inserimento = data_inserimento;
		this.visualizzazioni = visualizzazioni;
		this.immagineForum = immagineForum;
	}
	

	public int getId_film() {
		return id_film;
	}

	public void setId_film(int id_film) {
		this.id_film = id_film;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public int getDurata() {
		return durata;
	}

	public void setDurata(int durata) {
		this.durata = durata;
	}
	
	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}
	
	public String getLocandina() {
		return locandina;
	}

	public void setLocandina(String locandina) {
		this.locandina = locandina;
	}

	public String getRegista() {
		return regista;
	}

	public void setRegista(String regista) {
		this.regista = regista;
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

	public String getImmagineForum() {
		return immagineForum;
	}

	public void setImmagineForum(String immagineForum) {
		this.immagineForum = immagineForum;
	}

}
