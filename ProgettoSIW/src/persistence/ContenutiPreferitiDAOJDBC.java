package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ContenutoPreferito;
import persistence.dao.ContenutiPreferitiDAO;

public class ContenutiPreferitiDAOJDBC implements ContenutiPreferitiDAO
{
	private DataSource dataSource;

	public ContenutiPreferitiDAOJDBC(DataSource dataSource) 
	{
		this.dataSource = dataSource;
	}
	
	@Override
	public void saveFilm(ContenutoPreferito contenutoPreferito) 
	{
		Connection connection = null;
		try
		{
			 connection = this.dataSource.getConnection();
			 String insert = "insert into film_preferiti(username, id_contenuto) values(?,?)";
			 PreparedStatement statement = connection.prepareStatement(insert);
			 statement.setString(1, contenutoPreferito.getUsername());
			 statement.setInt(2, contenutoPreferito.getIdContenuto());
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
	
	@Override
	public void saveSerieTV(ContenutoPreferito contenutoPreferito) 
	{
		Connection connection = null;
		try
		{
			 connection = this.dataSource.getConnection();
			 String insert = "insert into serie_tv_preferite(username, id_contenuto) values(?,?)";
			 PreparedStatement statement = connection.prepareStatement(insert);
			 statement.setString(1, contenutoPreferito.getUsername());
			 statement.setInt(2, contenutoPreferito.getIdContenuto());
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

	@Override
	public List<ContenutoPreferito> findFilmsByUsername(String username) 
	{
		Connection connection = this.dataSource.getConnection();
		List<ContenutoPreferito> contenutiPreferiti = new ArrayList<>();
		try
		{
			String query = "SELECT * FROM film_preferiti WHERE film_preferiti.username = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, username);
			ResultSet result = statement.executeQuery();
			while (result.next())
			{
				ContenutoPreferito contenutoPreferito = new ContenutoPreferito();
				int idContenutoPreferito = result.getInt(1);
				String usernameContenutoPreferito = result.getString(2);
				int idContenuto = result.getInt(3);
				contenutoPreferito.setIdPreferito(idContenutoPreferito);
				contenutoPreferito.setUsername(usernameContenutoPreferito);
				contenutoPreferito.setIdContenuto(idContenuto);
				
				contenutiPreferiti.add(contenutoPreferito);
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
		return contenutiPreferiti;
	}
	
	@Override
	public List<ContenutoPreferito> findSerieTVsByUsername(String username) 
	{
		Connection connection = this.dataSource.getConnection();
		List<ContenutoPreferito> contenutiPreferiti = new ArrayList<>();
		try
		{
			String query = "SELECT * FROM serie_tv_preferite WHERE serie_tv_preferite.username = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, username);
			ResultSet result = statement.executeQuery();
			while (result.next())
			{
				ContenutoPreferito contenutoPreferito = new ContenutoPreferito();
				int idContenutoPreferito = result.getInt(1);
				String usernameContenutoPreferito = result.getString(2);
				int idContenuto = result.getInt(3);
				contenutoPreferito.setIdPreferito(idContenutoPreferito);
				contenutoPreferito.setUsername(usernameContenutoPreferito);
				contenutoPreferito.setIdContenuto(idContenuto);
				
				contenutiPreferiti.add(contenutoPreferito);
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
		return contenutiPreferiti;
	}
	
	@Override
	public void deleteFilm(ContenutoPreferito contenutoPreferito)
	{
		Connection connection = this.dataSource.getConnection();
		try 
		{
			String delete = "DELETE FROM film_preferiti WHERE username = ? and id_contenuto = ?";			
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setString(1, contenutoPreferito.getUsername());
			statement.setInt(2, contenutoPreferito.getIdContenuto());
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

	@Override
	public void deleteSerieTV(ContenutoPreferito contenutoPreferito)
	{
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "DELETE FROM serie_tv_preferite WHERE username = ? and id_contenuto = ?";			
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setString(1, contenutoPreferito.getUsername());
			statement.setInt(2, contenutoPreferito.getIdContenuto());
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
}
