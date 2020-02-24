package model;

public class Rating 
{
	private int idRating;
	private String username;
	private float rating;
	private int idContenuto;
	
	public int getIdRating() {
		return idRating;
	}
	
	public void setIdRating(int idRating) {
		this.idRating = idRating;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	
	public int getIdContenuto() {
		return idContenuto;
	}
	
	public void setIdContenuto(int idContenuto) {
		this.idContenuto = idContenuto;
	}
}