package persistence.dao;

import java.util.List;
import model.ContenutoGuardato;

public interface ContenutiGuardatiDAO 
{
	public void save(ContenutoGuardato contenutoGuardato);  // Create
	public List<ContenutoGuardato> searchFilmsWatchedByUser(String username);  // Retrieve
	public List<ContenutoGuardato> searchEpisodesWatchedByUser(String username);  // Retrieve
	public void delete(ContenutoGuardato contenutoGuardato); //Delete
}