package persistence.dao;

import java.util.List;

import model.Episodio;

public interface EpisodioDao {
	
	public void save(Episodio stagione);  // Create
	public Episodio cercaPerId(int id);  // Retrieve
	public void update(Episodio stagione); //Update
	public void delete(Episodio stagione); //Delete
	
	public List<Episodio> findAll();
	public List<Episodio> cercaPerIdStagione(int id);
	
	public List<Episodio> cercaUltimiInseriti();
	public List<Episodio> cercaPiuVisti();
	public int getIdStagioneFromIdEpisodio(int id);
	public int getIdSerieTVFromIdStagione(int id);
}