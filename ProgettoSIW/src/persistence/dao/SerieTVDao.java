package persistence.dao;

import java.util.List;
import model.ContenutoPreferito;
import model.SerieTV;

public interface SerieTVDao {

	public void save(SerieTV serieTV);  // Create
	public SerieTV cercaPerId(int id_serieTV);  // Retrieve
	public List<SerieTV> findAll(); 
	public void update(SerieTV serieTV); //Update
	public void delete(SerieTV serieTV); //Delete
	
	public List<SerieTV> cercaPerCarattere(String carattere);
	public List<SerieTV> cercaPerTitolo(String titolo);
	public List<SerieTV> findBySearchForm(String genere, int anno);
	public List<SerieTV> cercaUltimiInseriti();
	public List<SerieTV> cercaPiuVisti();
	
	public List<SerieTV> findFavouriteSerieTVs(List<ContenutoPreferito> contenutiPreferiti);
}