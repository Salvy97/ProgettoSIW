package model;

public class SerieTV {
	private String id_serieTV;
	private String titolo;
	private int anno;
	private String genere;
	private String locandina;


	public SerieTV(){}
	
	public SerieTV(String id_serieTV, String titolo, int anno, String genere, String locandina){
		this.id_serieTV = id_serieTV;
		this.titolo = titolo;
		this.anno = anno;
		this.genere = genere;
		this.locandina = locandina;
	}

	public String getId_serieTV() {
		return id_serieTV;
	}

	public void setId_serieTV(String id_serieTV) {
		this.id_serieTV = id_serieTV;
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
	
}