package persistence.dao;

import model.Profilo;

public interface ProfiloDAO 
{
	public void save(Profilo profilo);  // Create
	public Profilo findByUsername(String username);  // Retrieve
	public void update(Profilo profilo); //Update
	public void delete(Profilo profilo); //Delete
}