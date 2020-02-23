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
			String insert = "insert into episodio(titolo, durata,"
					+ " filmato, visualizzazioni, numero_episodio, sinossi, stagione_id) values (?,?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setString(1, episodio.getTitolo());
			statement.setInt(2, episodio.getDurata());
			statement.setString(3, episodio.getFilmato());
			statement.setInt(4, 0);
			statement.setInt(5, episodio.getNumero_episodio());
			statement.setString(6, episodio.getSinossi());
			statement.setInt(7, episodio.getStagione().getId_stagione());
			
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
				episodio.setId_episodio(result.getInt("id_episodio"));				
				episodio.setTitolo(result.getString("titolo"));
				episodio.setDurata(result.getInt("durata"));
				episodio.setFilmato(result.getString("filmato"));
				episodio.setVisualizzazioni(result.getInt("visualizzazioni"));
				episodio.setNumero_episodio(result.getInt("numero_episodio"));
				episodio.setSinossi(result.getString("sinossi"));
				
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
			String update = "update episodio SET titolo = ?, durata = ?, filmato = ?, visualizzazioni = ?, numero_episodio = ?, stagione_id = ? WHERE id_episodio = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, episodio.getTitolo());
			statement.setInt(2, episodio.getDurata());
			statement.setString(3, episodio.getFilmato());
			statement.setInt(4, episodio.getVisualizzazioni());
			statement.setInt(5, episodio.getNumero_episodio());
			statement.setString(7, episodio.getSinossi());
			statement.setInt(6, episodio.getStagione().getId_stagione());
			statement.setInt(7, episodio.getId_episodio());
			
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
			statement.setInt(1, episodio.getId_episodio());
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
				episodio.setId_episodio(result.getInt("id_episodio"));				
				episodio.setTitolo(result.getString("titolo"));
				episodio.setDurata(result.getInt("durata"));
				episodio.setFilmato(result.getString("filmato"));
				episodio.setVisualizzazioni(result.getInt("visualizzazioni"));
				episodio.setNumero_episodio(result.getInt("numero_episodio"));
				episodio.setSinossi(result.getString("sinossi"));
				
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
	
	public List<Episodio> cercaPerIdStagione(int id) {
		Connection connection = this.dataSource.getConnection();
		List<Episodio> episodi = new LinkedList<>();
		try {
			Episodio episodio;
			PreparedStatement statement;
			String query = "select * from episodio where stagione_id = ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				episodio = new Episodio();
				episodio.setId_episodio(result.getInt("id_episodio"));				
				episodio.setTitolo(result.getString("titolo"));
				episodio.setDurata(result.getInt("durata"));
				episodio.setFilmato(result.getString("filmato"));
				episodio.setVisualizzazioni(result.getInt("visualizzazioni"));
				episodio.setNumero_episodio(result.getInt("numero_episodio"));
				episodio.setSinossi(result.getString("sinossi"));
				
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
	
	public List<Episodio> cercaUltimiInseriti() {
		Connection connection = this.dataSource.getConnection();
		List<Episodio> episodi = new LinkedList<>();
		try {
			Episodio episodio;
			PreparedStatement statement;
			String query = "select * from episodio ORDER BY data_inserimento DESC LIMIT 3";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				episodio = new Episodio();
				episodio.setId_episodio(result.getInt("id_episodio"));				
				episodio.setTitolo(result.getString("titolo"));
				episodio.setDurata(result.getInt("durata"));
				episodio.setFilmato(result.getString("filmato"));
				episodio.setVisualizzazioni(result.getInt("visualizzazioni"));
				episodio.setNumero_episodio(result.getInt("numero_episodio"));
				episodio.setSinossi(result.getString("sinossi"));
				
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
	
	public List<Episodio> cercaPiuVisti() {
		Connection connection = this.dataSource.getConnection();
		List<Episodio> episodi = new LinkedList<>();
		try {
			Episodio episodio;
			PreparedStatement statement;
			String query = "select * from episodio order by visualizzazioni DESC LIMIT 3";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				episodio = new Episodio();
				episodio.setId_episodio(result.getInt("id_episodio"));				
				episodio.setTitolo(result.getString("titolo"));
				episodio.setDurata(result.getInt("durata"));
				episodio.setFilmato(result.getString("filmato"));
				episodio.setVisualizzazioni(result.getInt("visualizzazioni"));
				episodio.setNumero_episodio(result.getInt("numero_episodio"));
				episodio.setSinossi(result.getString("sinossi"));
				
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
	
	public int getIdStagioneFromIdEpisodio(int id) 
	{
		Connection connection = this.dataSource.getConnection();
		int idStagione = 0;
		try
		{
			PreparedStatement statement;
			String query = "select id_stagione from stagione as s inner join episodio ON s.id_stagione = episodio.stagione_id where id_episodio ='" + id + "'";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) 
				idStagione = result.getInt(1);
		} 
		catch (SQLException e) 
		{
			throw new PersistenceException(e.getMessage());
		} 
		finally
		{
			try 
			{
				connection.close();
			} catch (SQLException e) 
			{
				throw new PersistenceException(e.getMessage());
			}
		}
		return idStagione;
	}
	
	public int getIdSerieTVFromIdStagione(int id)
	{
		Connection connection = this.dataSource.getConnection();
		int idSerieTV = 0;
		try
		{
			PreparedStatement statement;
			String query = "select id_serie_tv from serie_tv as s inner join stagione ON s.id_serie_tv = stagione.serie_tv_id where id_stagione ='" + id + "'";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) 
				idSerieTV = result.getInt(1);
		} 
		catch (SQLException e) 
		{
			throw new PersistenceException(e.getMessage());
		} 
		finally
		{
			try 
			{
				connection.close();
			} catch (SQLException e) 
			{
				throw new PersistenceException(e.getMessage());
			}
		}
		return idSerieTV;
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
				episodio.setId_episodio(result.getInt("id_episodio"));				
				episodio.setTitolo(result.getString("titolo"));
				episodio.setDurata(result.getInt("durata"));
				episodio.setFilmato(result.getString("filmato"));
				episodio.setNumero_episodio(result.getInt("numero_episodio"));

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

	@Override
	public List<Episodio> cercaPerIdSerieTV(int id) 
	{
		Connection connection = this.dataSource.getConnection();
		List<Episodio> episodi = new LinkedList<>();
		try {
			Episodio episodio;
			PreparedStatement statement;
			String query = "select * from episodio";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) 
			{
				episodio = new Episodio();
				episodio.setId_episodio(result.getInt("id_episodio"));				
				episodio.setTitolo(result.getString("titolo"));
				episodio.setDurata(result.getInt("durata"));
				episodio.setFilmato(result.getString("filmato"));
				episodio.setVisualizzazioni(result.getInt("visualizzazioni"));
				episodio.setNumero_episodio(result.getInt("numero_episodio"));
				episodio.setSinossi(result.getString("sinossi"));
				
				StagioneDaoJDBC stagioneDao = new StagioneDaoJDBC(dataSource);
				Stagione stagione;
			    stagione = stagioneDao.cercaPerId(result.getInt("stagione_id"));
				episodio.setStagione(stagione);
				
				if (stagione.getSerieTV().getId_serieTV() == id)
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