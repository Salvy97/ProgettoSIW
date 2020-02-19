package model;

public class Stagione {
	private String id_stagione;
	private int numero_stagione;
	private int numero_episodi;
	private SerieTV serieTV;


	public Stagione(){}
	
	public Stagione(String id_stagione, int numero_stagione, int numero_episodi, SerieTV serieTV){
		this.id_stagione = id_stagione;
		this.numero_stagione = numero_stagione;
		this.numero_episodi = numero_episodi;
		this.serieTV = serieTV;
	}

	public String getId_stagione() {
		return id_stagione;
	}

	public void setId_stagione(String id_stagione) {
		this.id_stagione = id_stagione;
	}

	public int getNumero_stagione() {
		return numero_stagione;
	}

	public void setStagione(int numero_stagione) {
		this.numero_stagione = numero_stagione;
	}

	public int getNumero_episodi() {
		return numero_episodi;
	}

	public void setNumero_episodi(int numero_episodi) {
		this.numero_episodi = numero_episodi;
	}

	public SerieTV getSerieTV() {
		return serieTV;
	}

	public void setSerieTV(SerieTV serieTV) {
		this.serieTV = serieTV;
	}
	
}