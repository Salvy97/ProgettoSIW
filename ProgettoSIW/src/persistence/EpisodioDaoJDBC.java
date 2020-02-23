package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Episodio;
import model.Stagione;
import persistence.dao.EpisodioDao;


class EpisodioDaoJDBC implements EpisodioDao {
	
	private DataSource dataSource;

	public EpisodioDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void save(Episodio episodio) {
		Connection connection = this.dataSource.getConnection();
		try {
			String insert = "insert into episodio(id_episodio, titolo, durata,"
					+ " stagione_id) values (?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setString(1, episodio.getId_episodio());
			statement.setString(2, episodio.getTitolo());
			statement.setInt(3, episodio.getDurata());
			statement.setString(4, episodio.getStagione().getId_stagione());
			
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
	}
	

	public List<Episodio> findAll() {
		Connection connection = this.dataSource.getConnection();
		List<Episodio> episodi = new LinkedList<>();
		try {
			Episodio episodio;
			PreparedStatement statement;
			String query = "select * from episodio";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				episodio = new Episodio();
				episodio.setId_episodio(result.getString("id_episodio"));				
				episodio.setTitolo(result.getString("titolo"));
				episodio.setDurata(result.getInt("durata"));

				StagioneDaoJDBC stagioneDao = new StagioneDaoJDBC(dataSource);
				Stagione stagione;
			    stagione = stagioneDao.cercaPerId(result.getInt("stagione_id"));
				episodio.setStagione(stagione);
				
				episodi.add(episodio);
			}
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		}	 finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
		return episodi;
	}	
	

	public void update(Episodio episodio) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update episodio SET titolo = ?, durata = ?, stagione_id = ? WHERE id_episodio = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, episodio.getTitolo());
			statement.setInt(2, episodio.getDurata());
			statement.setString(3, episodio.getStagione().getId_stagione());
			statement.setString(4, episodio.getId_episodio());
			
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
	}

	public void delete(Episodio episodio) {
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "delete FROM episodio WHERE id_episodio = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setString(1, episodio.getId_episodio());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
	}
	
	public Episodio cercaPerId(int id) {
		Connection connection = this.dataSource.getConnection();
		Episodio episodio = null;
		try {
			PreparedStatement statement;
			String query = "select * from episodio where id_episodio = ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				episodio = new Episodio();
				episodio.setId_episodio(result.getString("id_episodio"));				
				episodio.setTitolo(result.getString("titolo"));
				episodio.setDurata(result.getInt("durata"));

				StagioneDaoJDBC stagioneDao = new StagioneDaoJDBC(dataSource);
				Stagione stagione;
			    stagione = stagioneDao.cercaPerId(result.getInt("stagione_id"));
				episodio.setStagione(stagione);
			}
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}	
		return episodio;
	}

	public List<Episodio> findBySerieTv(int idSerieTV) 
	{
		Connection connection = this.dataSource.getConnection();
		List<Episodio> episodi = new LinkedList<>();
		try {
			Episodio episodio;
			PreparedStatement statement;
			String query = "select * from episodio where episodio.serie_tv_id = ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, idSerieTV);
			ResultSet result = statement.executeQuery();
			while (result.next())
			{
				episodio = new Episodio();
				episodio.setId_episodio(result.getString("id_episodio"));				
				episodio.setTitolo(result.getString("titolo"));
				episodio.setDurata(result.getInt("durata"));
				episodio.setFilmato(result.getString("filmato"));
				episodio.setNumeroEpisodio(result.getInt("numero_episodio"));

				StagioneDaoJDBC stagioneDao = new StagioneDaoJDBC(dataSource);
				Stagione stagione;
			    stagione = stagioneDao.cercaPerId(result.getInt("stagione_id"));
				episodio.setStagione(stagione);
				
				episodi.add(episodio);
			}
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		}	 finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
		return episodi;
	}
}