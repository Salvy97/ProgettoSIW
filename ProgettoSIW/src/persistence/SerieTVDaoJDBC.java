package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import model.ContenutoPreferito;
import model.SerieTV;
import persistence.dao.SerieTVDao;

public class SerieTVDaoJDBC implements SerieTVDao{

	private DataSource dataSource;

	public SerieTVDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public void save(SerieTV serieTV) {
		Connection connection = this.dataSource.getConnection();
		try {
			String insert = "insert into serie_tv(id_serie_tv, titolo, anno,"
					+ " genere, locandina, immagine_forum) values (?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setInt(1, serieTV.getId_serieTV());
			statement.setString(2, serieTV.getTitolo());
			statement.setInt(3, serieTV.getAnno());
			statement.setString(4, serieTV.getGenere());
			statement.setString(5, serieTV.getLocandina());
			statement.setString(6, serieTV.getImmagineForum());
			
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

	public SerieTV cercaPerId(int id_serieTV) 
	{
		Connection connection = this.dataSource.getConnection();
		SerieTV serieTV = null;
		try {
			PreparedStatement statement;
			String query = "select * from serie_tv where id_serie_tv = ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, id_serieTV);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				serieTV = new SerieTV();
				serieTV.setId_serieTV(result.getInt("id_serie_tv"));				
				serieTV.setTitolo(result.getString("titolo"));
				serieTV.setAnno(result.getInt("anno"));
				serieTV.setGenere(result.getString("genere"));
				serieTV.setLocandina(result.getString("locandina"));
				serieTV.setImmagineForum(result.getString("immagine_forum"));
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
		return serieTV;
	}
	
	
	public List<SerieTV> cercaPerCarattere(String carattere) {
		Connection connection = this.dataSource.getConnection();
		List<SerieTV> serieTVs = new LinkedList<>();
		try {
			SerieTV serieTV;
			PreparedStatement statement;
			String query = "select * from serie_tv where titolo like ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, carattere+"%");
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				serieTV = new SerieTV();
				serieTV.setId_serieTV(result.getInt("id_serie_tv"));				
				serieTV.setTitolo(result.getString("titolo"));
				serieTV.setAnno(result.getInt("anno"));
				serieTV.setGenere(result.getString("genere"));
				serieTV.setLocandina(result.getString("locandina"));
				serieTV.setImmagineForum(result.getString("immagine_forum"));
				
				serieTVs.add(serieTV);
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
		return serieTVs;
	}
	
	
	public List<SerieTV> cercaPerTitolo(String titolo) {
		Connection connection = this.dataSource.getConnection();
		List<SerieTV> serieTVs = new LinkedList<>();
		try {
			SerieTV serieTV;
			PreparedStatement statement;
			String query = "select * from serie_tv where titolo ilike ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, "%"+titolo+"%");
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				serieTV = new SerieTV();
				serieTV.setId_serieTV(result.getInt("id_serie_tv"));				
				serieTV.setTitolo(result.getString("titolo"));
				serieTV.setAnno(result.getInt("anno"));
				serieTV.setGenere(result.getString("genere"));
				serieTV.setLocandina(result.getString("locandina"));
				serieTV.setImmagineForum(result.getString("immagine_forum"));
				
				serieTVs.add(serieTV);
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
		return serieTVs;
	}
	

	@Override
	public List<SerieTV> findAll() {
		Connection connection = this.dataSource.getConnection();
		List<SerieTV> serieTVs = new LinkedList<>();
		try {
			SerieTV serieTV;
			PreparedStatement statement;
			String query = "select * from serie_tv";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				serieTV = new SerieTV();
				serieTV.setId_serieTV(result.getInt("id_serie_tv"));				
				serieTV.setTitolo(result.getString("titolo"));
				serieTV.setAnno(result.getInt("anno"));
				serieTV.setGenere(result.getString("genere"));
				serieTV.setLocandina(result.getString("locandina"));
				serieTV.setImmagineForum(result.getString("immagine_forum"));
				
				serieTVs.add(serieTV);
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
		return serieTVs;
	}

	@Override
	public void update(SerieTV serieTV) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update serie_tv SET titolo = ?, anno = ?, genere = ?, locandina = ?, immagine_forum = ? WHERE id_serie_tv = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, serieTV.getTitolo());
			statement.setInt(2, serieTV.getAnno());
			statement.setString(3, serieTV.getGenere());
			statement.setString(4, serieTV.getLocandina());
			statement.setString(5, serieTV.getImmagineForum());
			statement.setInt(6, serieTV.getId_serieTV());

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

	@Override
	public void delete(SerieTV serieTV) {
		Connection connection = this.dataSource.getConnection();
		try {
			String deleteStagioni = "delete FROM stagione WHERE serie_tv_id = ? ";
			PreparedStatement statement = connection.prepareStatement(deleteStagioni);
			statement.setInt(1, serieTV.getId_serieTV());
			statement.executeUpdate();
			
			String deleteSerieTV = "delete FROM serie_tv WHERE id_serie_tv = ? ";
			statement = connection.prepareStatement(deleteSerieTV);
			statement.setInt(1, serieTV.getId_serieTV());
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
	
	
	@Override
	public List<SerieTV> findBySearchForm(String genere, int anno) {
		Connection connection = this.dataSource.getConnection();
		List<SerieTV> serieTVs = new LinkedList<>();
		try {
			SerieTV serieTV;
			PreparedStatement statement = null;
			String query1 = "select * from serie_tv where genere = ?";
			String query2 = "select * from serie_tv where anno = ?";
			String query3 = "select * from serie_tv where genere = ? and anno = ?";
			
						
			if(!genere.equals("---")) {
				statement = connection.prepareStatement(query1);
				statement.setString(1, genere);				
			}
			
			if(anno!=0) {
				statement = connection.prepareStatement(query2);
				statement.setInt(1, anno);
			}
			
			if(!genere.equals("---") && anno!=0) {
				statement = connection.prepareStatement(query3);
				statement.setString(1, genere);
				statement.setInt(2, anno);
			}
			
			if(!genere.equals("---") || anno!=0) {
				ResultSet result = statement.executeQuery();
				
				while (result.next()) {
					serieTV = new SerieTV();
					serieTV.setId_serieTV(result.getInt("id_serie_tv"));				
					serieTV.setTitolo(result.getString("titolo"));
					serieTV.setAnno(result.getInt("anno"));
					serieTV.setGenere(result.getString("genere"));
					serieTV.setLocandina(result.getString("locandina"));
					serieTV.setImmagineForum(result.getString("immagine_forum"));
					
					serieTVs.add(serieTV);
				}
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
		return serieTVs;
	}

	
	public List<SerieTV> cercaUltimiInseriti() {
		Connection connection = this.dataSource.getConnection();
		List<SerieTV> serieTVs = new LinkedList<>();
		try {
			SerieTV serieTV;
			PreparedStatement statement;
			String query = "SELECT *\r\n" + 
					"FROM serie_tv AS s\r\n" + 
					"INNER JOIN stagione ON stagione.serie_tv_id = s.id_serie_tv\r\n" + 
					"INNER JOIN episodio ON episodio.stagione_id = stagione.id_stagione\r\n" + 
					"ORDER BY episodio.data_inserimento DESC LIMIT 3";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				serieTV = new SerieTV();
				serieTV.setId_serieTV(result.getInt("id_serie_tv"));				
				serieTV.setTitolo(result.getString("titolo"));
				serieTV.setAnno(result.getInt("anno"));
				serieTV.setGenere(result.getString("genere"));
				serieTV.setLocandina(result.getString("locandina"));
				serieTV.setImmagineForum(result.getString("immagine_forum"));
				
				serieTVs.add(serieTV);
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
		return serieTVs;
	}
	
	public List<SerieTV> cercaPiuVisti() {
		Connection connection = this.dataSource.getConnection();
		List<SerieTV> serieTVs = new LinkedList<>();
		try {
			SerieTV serieTV;
			PreparedStatement statement;
			String query = "SELECT *\r\n" + 
					"FROM serie_tv AS s\r\n" + 
					"INNER JOIN stagione ON stagione.serie_tv_id = s.id_serie_tv\r\n" + 
					"INNER JOIN episodio ON episodio.stagione_id = stagione.id_stagione\r\n" + 
					"ORDER BY episodio.visualizzazioni DESC LIMIT 3";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				serieTV = new SerieTV();
				serieTV.setId_serieTV(result.getInt("id_serie_tv"));				
				serieTV.setTitolo(result.getString("titolo"));
				serieTV.setAnno(result.getInt("anno"));
				serieTV.setGenere(result.getString("genere"));
				serieTV.setLocandina(result.getString("locandina"));
				serieTV.setImmagineForum(result.getString("immagine_forum"));
				
				serieTVs.add(serieTV);
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
		return serieTVs;
	}

	@Override
	public List<SerieTV> findFavouriteSerieTVs(List<ContenutoPreferito> contenutiPreferiti) 
	{
		List<SerieTV> serieTVs = new LinkedList<>();
		Connection connection = this.dataSource.getConnection();
		try 
		{
			for (int i = 0; i < contenutiPreferiti.size(); i++)
			{
				PreparedStatement statement;
				String query = "select * from serie_tv where id_serie_tv = ?";
				statement = connection.prepareStatement(query);
				statement.setInt(1, contenutiPreferiti.get(i).getIdContenuto());
				ResultSet result = statement.executeQuery();
				
				if (result.next())
				{
					SerieTV serieTV = new SerieTV();
					
					serieTV.setId_serieTV(result.getInt("id_serie_tv"));
					serieTV.setTitolo(result.getString("titolo"));
					serieTV.setAnno(result.getInt("anno"));
					serieTV.setGenere(result.getString("genere"));
					serieTV.setImmagineForum(result.getString("immagine_forum"));
					serieTV.setLocandina(result.getString("locandina"));
					
					serieTVs.add(serieTV);
				}
			}
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
			} 
			catch (SQLException e) 
			{
				throw new PersistenceException(e.getMessage());
			}
		}
		return serieTVs;
	}

	@Override
	public int getIdSerieTVFromTitle(String title) 
	{
		Connection connection = this.dataSource.getConnection();
		int idSerieTV = 0;
		try
		{
			PreparedStatement statement;
			String query = "select id_serie_tv from serie_tv where serie_tv.titolo = '" + title + "'";
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

}