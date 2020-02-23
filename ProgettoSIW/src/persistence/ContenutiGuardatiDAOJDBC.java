package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ContenutoGuardato;
import persistence.dao.ContenutiGuardatiDAO;

public class ContenutiGuardatiDAOJDBC implements ContenutiGuardatiDAO
{
	private DataSource dataSource;

	public ContenutiGuardatiDAOJDBC(DataSource dataSource) 
	{
		this.dataSource = dataSource;
	}
	
	public void saveFilm(ContenutoGuardato contenutoGuardato) 
	{
		Connection connection = null;
		try
		{
			 connection = this.dataSource.getConnection();
			 String insert = "insert into film_guardati(username, id_contenuto, data_visualizzazione) values(?,?,?)";
			 PreparedStatement statement = connection.prepareStatement(insert);
			 statement.setString(1, contenutoGuardato.getUsername());
			 statement.setInt(2, contenutoGuardato.getIdContenuto());
			 statement.setString(3, contenutoGuardato.getDataVisualizzazione());
			 statement.executeUpdate();
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
	}
	
	public void saveEpisode(ContenutoGuardato contenutoGuardato) 
	{
		Connection connection = null;
		try
		{
			 connection = this.dataSource.getConnection();
			 String insert = "insert into episodi_guardati(username, id_contenuto, data_visualizzazione) values(?,?,?)";
			 PreparedStatement statement = connection.prepareStatement(insert);
			 statement.setString(1, contenutoGuardato.getUsername());
			 statement.setInt(2, contenutoGuardato.getIdContenuto());
			 statement.setString(3, contenutoGuardato.getDataVisualizzazione());
			 statement.executeUpdate();
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
	}

	public List<ContenutoGuardato> searchFilmsWatchedByUser(String username) 
	{
		Connection connection = this.dataSource.getConnection();
		List<ContenutoGuardato> contenutiGuardati = new ArrayList<>();
		try
		{
			String query = "SELECT * FROM film_guardati WHERE film_guardati.username = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, username);
			ResultSet result = statement.executeQuery();
			while (result.next())
			{
				ContenutoGuardato contenutoGuardato = new ContenutoGuardato();
				int idContenutoGuardato = result.getInt(1);
				String usernameContenutoGuardato = result.getString(2);
				int idContenuto = result.getInt(3);
				String dataVisualizzazione = result.getString(4);
				contenutoGuardato.setIdContenutoGuardato(idContenutoGuardato);
				contenutoGuardato.setUsername(usernameContenutoGuardato);
				contenutoGuardato.setIdContenuto(idContenuto);
				contenutoGuardato.setDataVisualizzazione(dataVisualizzazione);
				
				String titoloContenuto = null;
				String locandinaContenuto = null;
				String query2 = "SELECT titolo, locandina FROM film WHERE film.id_film = ?";
				PreparedStatement statement2 = connection.prepareStatement(query2);
				statement2.setInt(1, idContenuto);
				ResultSet result2 = statement2.executeQuery();
				if (result2.next())
				{
					titoloContenuto = result2.getString(1);
					locandinaContenuto = result2.getString(2);
				}
				contenutoGuardato.setTitoloContenuto(titoloContenuto);
				contenutoGuardato.setLocandinaContenuto(locandinaContenuto);
				
				contenutiGuardati.add(contenutoGuardato);
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
		return contenutiGuardati;
	}

	public void deleteFilm(ContenutoGuardato contenutoGuardato) 
	{
		
	}
	
	public void deleteEpisode(ContenutoGuardato contenutoGuardato) 
	{
		
	}
	
	public List<ContenutoGuardato> searchEpisodesWatchedByUser(String username) 
	{
		Connection connection = this.dataSource.getConnection();
		List<ContenutoGuardato> contenutiGuardati = new ArrayList<>();
		try
		{
			String query = "SELECT * FROM episodi_guardati WHERE episodi_guardati.username = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, username);
			ResultSet result = statement.executeQuery();
			while (result.next())
			{
				ContenutoGuardato contenutoGuardato = new ContenutoGuardato();
				int idContenutoGuardato = result.getInt(1);
				String usernameContenutoGuardato = result.getString(2);
				int idContenuto = result.getInt(3);
				String dataVisualizzazione = result.getString(4);
				contenutoGuardato.setIdContenutoGuardato(idContenutoGuardato);
				contenutoGuardato.setUsername(usernameContenutoGuardato);
				contenutoGuardato.setIdContenuto(idContenuto);
				contenutoGuardato.setDataVisualizzazione(dataVisualizzazione);
				
				int numEpisodio = -1;
				int idStagione = -1;
				String titoloContenuto = null;
				String query2 = "SELECT titolo, numero_episodio, stagione_id FROM episodio WHERE episodio.id_episodio = ?";
				PreparedStatement statement2 = connection.prepareStatement(query2);
				statement2.setInt(1, idContenuto);
				ResultSet result2 = statement2.executeQuery();
				if (result2.next())
				{
					titoloContenuto = result2.getString(1);
					numEpisodio = result2.getInt(2);
					idStagione = result2.getInt(3);
				}
				contenutoGuardato.setEpisodio(numEpisodio);
				
				int numeroStagione = -1;
				int idSerieTV = -1;
				query2 = "SELECT numero_stagione, serie_tv_id FROM stagione WHERE stagione.id_stagione = ?";
				statement2 = connection.prepareStatement(query2);
				statement2.setInt(1, idStagione);
				result2 = statement2.executeQuery();
				if (result2.next())
				{
					numeroStagione = result2.getInt(1);
					idSerieTV = result2.getInt(2);
				}
				contenutoGuardato.setStagione(numeroStagione);
				
				String titoloSerieTV = null;
				String locandinaContenuto = null;
				String query3 = "SELECT titolo, locandina FROM serie_tv WHERE serie_tv.id_serie_tv = ?";
				PreparedStatement statement3 = connection.prepareStatement(query3);
				statement3.setInt(1, idSerieTV);
				ResultSet result3 = statement3.executeQuery();
				if (result3.next())
				{
					titoloSerieTV = result3.getString(1);
					locandinaContenuto = result3.getString(2);
				}
				contenutoGuardato.setTitoloSerieTV(titoloSerieTV);

				contenutoGuardato.setTitoloContenuto(titoloContenuto);
				contenutoGuardato.setLocandinaContenuto(locandinaContenuto);
				
				contenutiGuardati.add(contenutoGuardato);
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
		return contenutiGuardati;
	}
}