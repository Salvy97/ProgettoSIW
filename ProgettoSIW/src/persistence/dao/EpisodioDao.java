package persistence.dao;

import java.util.List;

import model.Episodio;

public interface EpisodioDao {
	
	public void save(Episodio stagione);  // Create
	public Episodio cercaPerId(String id);  // Retrieve
	public void update(Episodio stagione); //Update
	public void delete(Episodio stagione); //Delete
	
	public List<Episodio> findAll();
}