package persistence.dao;

import java.util.List;
import model.Stagione;

public interface StagioneDao {
	
	public void save(Stagione stagione);  // Create
	public Stagione cercaPerId(String id);  // Retrieve
	public void update(Stagione stagione); //Update
	public void delete(Stagione stagione); //Delete
	
	public List<Stagione> findAll();
}