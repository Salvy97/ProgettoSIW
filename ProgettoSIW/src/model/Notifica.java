package model;

public class Notifica 
{
	private int idNotifica;
	private Post post;
	private String username;
	private Commento commento;
	
	public int getIdNotifica() {
		return idNotifica;
	}
	
	public void setIdNotifica(int idNotifica) {
		this.idNotifica = idNotifica;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Commento getCommento() {
		return commento;
	}

	public void setCommento(Commento commento) {
		this.commento = commento;
	}
}