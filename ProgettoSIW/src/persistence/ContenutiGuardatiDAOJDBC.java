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
	
	public void save(ContenutoGuardato contenutoGuardato) 
	{
		
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

	public void delete(ContenutoGuardato contenutoGuardato) 
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
				
				int idSerieTv = -1;
				String titoloContenuto = null;
				String query2 = "SELECT titolo, serie_tv_id FROM episodio WHERE episodio.id_episodio = ?";
				PreparedStatement statement2 = connection.prepareStatement(query2);
				statement2.setInt(1, idContenuto);
				ResultSet result2 = statement2.executeQuery();
				if (result2.next())
				{
					titoloContenuto = result2.getString(1);
					idSerieTv = result2.getInt(2);
				}
				
				String locandinaContenuto = null;
				String query3 = "SELECT locandina FROM serie_tv WHERE serie_tv.id_serie_tv = ?";
				PreparedStatement statement3 = connection.prepareStatement(query3);
				statement3.setInt(1, idSerieTv);
				ResultSet result3 = statement3.executeQuery();
				if (result3.next())
					locandinaContenuto = result3.getString(1);

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