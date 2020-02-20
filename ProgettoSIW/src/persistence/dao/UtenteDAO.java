package persistence.dao;

import java.util.List;

import model.Utente;

public interface UtenteDAO 
{
	public void save(Utente utente); // Create
	public Utente findByPrimaryKey(int subject); // Retrieve
	public Utente findByUsername(String username); // Retrieve
	public Utente findByEmail(String email); // Retrieve
	public List<Utente> findAll();
	public boolean isAbbonato(String username);
	public void update(Utente utente); // Update
	public void delete(Utente utente); // Delete
}