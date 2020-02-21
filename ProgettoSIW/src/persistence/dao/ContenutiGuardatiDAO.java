package persistence.dao;

import java.util.List;
import model.ContenutoGuardato;

public interface ContenutiGuardatiDAO 
{
	public void save(ContenutoGuardato contenutoGuardato);  // Create
	public List<ContenutoGuardato> searchContentsWatchedByUser(String username);  // Retrieve
	public void delete(ContenutoGuardato contenutoGuardato); //Delete
}