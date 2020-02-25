package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Commento;
import persistence.dao.CommentoDAO;

public class CommentoDAOJDBC implements CommentoDAO 
{
	private DataSource dataSource;

	public CommentoDAOJDBC(DataSource dataSource) 
	{
		this.dataSource = dataSource;
	}
	
	@Override
	public void save(Commento commento)
	{
		Connection connection = this.dataSource.getConnection();
		try 
		{
			String insert = "insert into commento(commento, username,"
					+ " post) values (?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setString(1, commento.getCommento());
			statement.setString(2, commento.getUsername());
			statement.setInt(3, commento.getPost());

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
	public Commento findByPrimaryKey(int id) 
	{
		Connection connection = this.dataSource.getConnection();
		Commento commento = null;
		try 
		{
			PreparedStatement statement;
			String query = "select * from commento where id = ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			if (result.next()) 
			{
				commento = new Commento();
				commento.setId(result.getInt("id"));				
				commento.setCommento(result.getString("commento"));
				commento.setUsername(result.getString("username"));
				commento.setPost(result.getInt("post"));
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
		return commento;
	}

	@Override
	public List<Commento> findByContent(int content_id) 
	{
		List<Commento> commenti = new ArrayList<Commento>();
		Connection connection = this.dataSource.getConnection();
		try 
		{
			PreparedStatement statement;
			String query = "select * from commento where post = ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, content_id);
			ResultSet result = statement.executeQuery();
			Commento commento = null;
			while (result.next())
			{
				commento = new Commento();
				commento.setId(result.getInt("id"));				
				commento.setCommento(result.getString("commento"));
				commento.setUsername(result.getString("username"));
				commento.setPost(result.getInt("post"));
				commenti.add(commento);
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
		return commenti;
	}

	@Override
	public void delete(Commento commento) {
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "delete FROM commento WHERE id = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);	
			statement.setInt(1, commento.getId());
			statement.executeUpdate();
			System.out.println("    Elimino Commento " + commento.getId());
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
	public Commento getLastOne() 
	{
		List<Commento> commenti = new ArrayList<Commento>();
		Connection connection = this.dataSource.getConnection();
		try 
		{
			PreparedStatement statement;
			String query = "select * from commento";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			Commento commento = null;
			while (result.next())
			{
				commento = new Commento();
				commento.setId(result.getInt("id"));				
				commento.setCommento(result.getString("commento"));
				commento.setUsername(result.getString("username"));
				commento.setPost(result.getInt("post"));
				commenti.add(commento);
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
		return commenti.get(commenti.size() - 1);
	}
}