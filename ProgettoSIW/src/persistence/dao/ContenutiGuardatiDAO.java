package persistence.dao;

import java.util.List;
import model.ContenutoGuardato;

public interface ContenutiGuardatiDAO 
{
	public void saveFilm(ContenutoGuardato contenutoGuardato);  // Create
	public void saveEpisode(ContenutoGuardato contenutoGuardato);  // Create
	public List<ContenutoGuardato> searchFilmsWatchedByUser(String username);  // Retrieve
	public List<ContenutoGuardato> searchEpisodesWatchedByUser(String username);  // Retrieve
	public void deleteFilm(ContenutoGuardato contenutoGuardato); //Delete
	public void deleteEpisode(ContenutoGuardato contenutoGuardato); //Delete
}