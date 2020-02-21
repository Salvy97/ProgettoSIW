package model;

public class ContenutoGuardato 
{
	private int idContenutoGuardato;
	private String username;
	private int idContenuto;
	private String dataVisualizzazione;
	private String titoloContenuto;
	private String locandinaContenuto;
	
	public int getIdContenutoGuardato() {
		return idContenutoGuardato;
	}
	
	public void setIdContenutoGuardato(int idContenutoGuardato) {
		this.idContenutoGuardato = idContenutoGuardato;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public int getIdContenuto() {
		return idContenuto;
	}
	
	public void setIdContenuto(int idContenuto) {
		this.idContenuto = idContenuto;
	}
	
	public String getDataVisualizzazione() {
		return dataVisualizzazione;
	}

	public void setDataVisualizzazione(String dataVisualizzazione) {
		this.dataVisualizzazione = dataVisualizzazione;
	}

	public String getTitoloContenuto() {
		return titoloContenuto;
	}

	public void setTitoloContenuto(String titoloContenuto) {
		this.titoloContenuto = titoloContenuto;
	}

	public String getLocandinaContenuto() {
		return locandinaContenuto;
	}

	public void setLocandinaContenuto(String locandinaContenuto) {
		this.locandinaContenuto = locandinaContenuto;
	}
}