package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.SerieTV;
import model.Stagione;
import persistence.dao.StagioneDao;


class StagioneDaoJDBC implements StagioneDao {
	
	private DataSource dataSource;

	public StagioneDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void save(Stagione stagione) {
		Connection connection = this.dataSource.getConnection();
		try {
			String insert = "insert into stagione(id_stagione, numero_stagione, numero_episodi,"
					+ " serie_tv_id) values (?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setString(1, stagione.getId_stagione());
			statement.setInt(2, stagione.getNumero_stagione());
			statement.setInt(3, stagione.getNumero_episodi());
			statement.setString(4, stagione.getSerieTV().getId_serieTV());
			
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
	

	public List<Stagione> findAll() {
		Connection connection = this.dataSource.getConnection();
		List<Stagione> stagioni = new LinkedList<>();
		try {
			Stagione stagione;
			PreparedStatement statement;
			String query = "select * from stagione";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				stagione = new Stagione();
				stagione.setId_stagione(result.getString("id_stagione"));				
				stagione.setStagione(result.getInt("numero_stagione"));
				stagione.setNumero_episodi(result.getInt("numero_episodi"));

				SerieTVDaoJDBC serieTVDao = new SerieTVDaoJDBC(dataSource);
				SerieTV serieTV;
			    serieTV = serieTVDao.findByPrimaryKey(result.getString("serie_tv_id"));
				stagione.setSerieTV(serieTV);
				
				stagioni.add(stagione);
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
		return stagioni;
	}	
	

	public void update(Stagione stagione) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update stagione SET numero_stagione = ?, numero_episodi = ?, serie_tv_id = ? WHERE id_stagione = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setInt(1, stagione.getNumero_stagione());
			statement.setInt(2, stagione.getNumero_episodi());
			statement.setString(3, stagione.getSerieTV().getId_serieTV());
			statement.setString(4, stagione.getId_stagione());
			
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

	public void delete(Stagione stagione) {
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "delete FROM stagione WHERE id_stagione = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setString(1, stagione.getId_stagione());
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
	
	public Stagione cercaPerId(String id) {
		Connection connection = this.dataSource.getConnection();
		Stagione stagione = null;
		try {
			PreparedStatement statement;
			String query = "select * from stagione where id_stagione = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, id);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				stagione = new Stagione();
				stagione.setId_stagione(result.getString("id_stagione"));				
				stagione.setStagione(result.getInt("numero_stagione"));
				stagione.setNumero_episodi(result.getInt("numero_episodi"));

				SerieTVDaoJDBC serieTVDao = new SerieTVDaoJDBC(dataSource);
				SerieTV serieTV;
			    serieTV = serieTVDao.findByPrimaryKey(result.getString("serie_tv_id"));
				stagione.setSerieTV(serieTV);
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
		return stagione;
	}

}