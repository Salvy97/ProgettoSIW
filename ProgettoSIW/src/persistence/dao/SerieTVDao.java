package persistence.dao;

import java.util.List;
import model.SerieTV;

public interface SerieTVDao {

	public void save(SerieTV serieTV);  // Create
	public SerieTV findByPrimaryKey(String id_serieTV);  // Retrieve
	public List<SerieTV> findAll(); 
	public void update(SerieTV serieTV); //Update
	public void delete(SerieTV serieTV); //Delete
	
	public List<SerieTV> cercaPerCarattere(String carattere);
	public List<SerieTV> cercaPerTitolo(String titolo);
	public List<SerieTV> findBySearchForm(String genere, int anno);
}