package persistence.dao;

import java.util.List;

import model.Stagione;

public interface StagioneDao {
	
	public void save(Stagione stagione);  // Create
	public Stagione cercaPerId(int id);  // Retrieve
	public void update(Stagione stagione); //Update
	public void delete(Stagione stagione); //Delete
	
	public List<Stagione> findAll();
	public List<Stagione> cercaPerIdSerie(int id);
	public List<Stagione> cercaUltimiInseriti();
	public List<Stagione> cercaPiuVisti();
}