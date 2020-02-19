package persistence.dao;

import java.util.List;
import model.Film;

public interface FilmDao {
	
	public void save(Film film);  // Create
	public Film cercaPerId(int id);  // Retrieve
	public void update(Film film); //Update
	public void delete(Film film); //Delete
	public Film findByPrimaryKey(int id_film);
	public List<Film> findByTitle(String title);
	public List<Film> findAll(); 
	public List<Film> findBySearchForm(String genere, int anno);
	public List<Film> cercaPerTitolo(String titolo);
	public List<Film> cercaPerRegista(String regista);
	public List<Film> cercaPerCarattere(String character);
	public List<Film> cercaUltimiInseriti();
	public List<Film> cercaPiuVisti();
	public int getIdFilmFromTitle(String title);
}