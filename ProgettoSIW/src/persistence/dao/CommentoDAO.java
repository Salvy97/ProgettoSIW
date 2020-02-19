package persistence.dao;

import java.util.List;
import model.Commento;

public interface CommentoDAO 
{
	public void save(Commento commento);  // Create
	public Commento findByPrimaryKey(int id);  // Retrieve
	public List<Commento> findAll(); 
	public void update(Commento commento); //Update
	public void delete(Commento commento); //Delete

//	Commento findByContent(String content_id);
	List<Commento> findByContent(int content_id);
}