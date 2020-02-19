package persistence.dao;

import java.util.List;

import model.Abbonamento;

public interface AbbonamentoDAO {
	public void save(Abbonamento abb); // Create
	public Abbonamento findByPrimaryKey(int id); // Retrieve
	public List<Abbonamento> findAll();
	public void update(Abbonamento abb); // Update
	public void delete(Abbonamento abb); // Delete
}