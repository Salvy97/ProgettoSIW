package persistence.dao;

import java.util.List;
import model.ContenutoPreferito;

public interface ContenutiPreferitiDAO 
{
	public void saveFilm(ContenutoPreferito contenutoPreferito);
	public void saveSerieTV(ContenutoPreferito contenutoPreferito);
	public List<ContenutoPreferito> findFilmsByUsername(String username);
	public List<ContenutoPreferito> findSerieTVsByUsername(String username);
	public void deleteFilm(ContenutoPreferito contenutoPreferito);
	public void deleteSerieTV(ContenutoPreferito contenutoPreferito);
}