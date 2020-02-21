package persistence.dao;

import java.util.List;

import model.Sottoscrizione;

public interface SottoscrizioneDAO {
	public void save(Sottoscrizione abb); // Create
	public Sottoscrizione findByPrimaryKey(int id); // Retrieve
	public List<Sottoscrizione> findAll();
	public void update(Sottoscrizione abb); // Update
	public void delete(Sottoscrizione abb); // Delete
	public Sottoscrizione findByUser(String username);
}