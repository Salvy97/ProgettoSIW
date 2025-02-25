package persistence.dao;

import java.util.List;

import model.ContenutoPreferito;
import model.Film;

public interface FilmDao {
	
	public void save(Film film);  // Create
	public Film cercaPerId(int id);  // Retrieve
	public void update(Film film); //Update
	public void delete(Film film); //Delete

	public List<Film> findByTitle(String title);
	public List<Film> findAll(); 
	public List<Film> findBySearchForm(String genere, int anno);
	public List<Film> cercaPerTitolo(String titolo);
	public List<Film> cercaPerRegista(String regista);
	public List<Film> cercaPerCarattere(String character);
	public List<Film> cercaUltimiInseriti();
	public List<Film> cercaPiuVisti();
	public int getIdFilmFromTitle(String title);
	public void incrementaVisualizzazioni(int id);
	
	public List<Film> findFavouriteFilms(List<ContenutoPreferito> contenutiPreferiti);
}