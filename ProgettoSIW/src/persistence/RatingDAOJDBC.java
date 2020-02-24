package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Rating;
import persistence.dao.RatingDAO;

public class RatingDAOJDBC implements RatingDAO
{
	private DataSource dataSource;

	public RatingDAOJDBC(DataSource dataSource) 
	{
		this.dataSource = dataSource;
	}
	
	@Override
	public void saveRatingFilm(Rating rating) 
	{
		Connection connection = null;
		try
		{
			connection = this.dataSource.getConnection();
			String insert = "insert into rating_film(username, rating, id_contenuto) values (?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setString(1, rating.getUsername());
			statement.setFloat(2, rating.getRating());
			statement.setInt(3, rating.getIdContenuto());
			statement.executeUpdate();
			
			String query = "UPDATE profilo SET recensioni_effettuate = recensioni_effettuate+1 WHERE username = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, rating.getUsername());
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
	public void saveRatingEpisodio(Rating rating) 
	{
		Connection connection = null;
		try
		{
			connection = this.dataSource.getConnection();
			String insert = "insert into rating_episodio(username, rating, id_contenuto) values (?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setString(1, rating.getUsername());
			statement.setFloat(2, rating.getRating());
			statement.setInt(3, rating.getIdContenuto());
			statement.executeUpdate();
			
			String query = "UPDATE profilo SET recensioni_effettuate = recensioni_effettuate+1 WHERE username = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, rating.getUsername());
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
	public float calculateRatingFilm(int idFilm) 
	{
		float rat = 0;
		Connection connection = null;
		try
		{
			int cont = 0;
			connection = this.dataSource.getConnection();
			String query = "SELECT rating FROM rating_film WHERE rating_film.id_contenuto = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, idFilm);
			ResultSet result = statement.executeQuery();
			while (result.next())
			{
				rat += result.getFloat(1);
				cont++;
			}
			rat /= cont;
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
		return rat;
	}

	@Override
	public float calculateRatingEpisodio(int idEpisodio) 
	{
		float rat = 0;
		Connection connection = null;
		try
		{
			int cont = 0;
			connection = this.dataSource.getConnection();
			String query = "SELECT rating FROM rating_episodio WHERE rating_episodio.id_contenuto = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, idEpisodio);
			ResultSet result = statement.executeQuery();
			while (result.next())
			{
				rat += result.getFloat(1);
				cont++;
			}
			rat /= cont;
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
		return rat;
	}
	
	@Override
	public Rating findRatedFilmByUsername(String username, int idFilm) 
	{
		Connection connection = null;
		Rating rating = null;
		try
		{
			connection = this.dataSource.getConnection();
			String query = "SELECT * FROM rating_film WHERE rating_film.username = ? and rating_film.id_contenuto = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, username);
			statement.setInt(2, idFilm);
			ResultSet result = statement.executeQuery();
			while (result.next())
			{
				rating = new Rating();
				rating.setIdRating(result.getInt("id_rating"));
				rating.setUsername(result.getString("username"));
				rating.setRating(result.getFloat("rating"));
				rating.setIdContenuto(result.getInt("id_contenuto"));
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
		return rating;
	}
	
	@Override
	public Rating findRatedEpisodeByUsername(String username, int idEpisodio) 
	{
		Connection connection = null;
		Rating rating = null;
		try
		{
			connection = this.dataSource.getConnection();
			String query = "SELECT * FROM rating_episodio WHERE rating_episodio.username = ? and rating_episodio.id_contenuto = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, username);
			statement.setInt(2, idEpisodio);
			ResultSet result = statement.executeQuery();
			while (result.next())
			{
				rating = new Rating();
				rating.setIdRating(result.getInt("id_rating"));
				rating.setUsername(result.getString("username"));
				rating.setRating(result.getFloat("rating"));
				rating.setIdContenuto(result.getInt("id_contenuto"));
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
		return rating;
	}
}