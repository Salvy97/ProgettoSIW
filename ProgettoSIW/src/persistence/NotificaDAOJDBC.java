package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Commento;
import model.Notifica;
import model.Post;
import persistence.dao.NotificaDAO;

public class NotificaDAOJDBC implements NotificaDAO
{
	private DataSource dataSource;

	public NotificaDAOJDBC(DataSource dataSource) 
	{
		this.dataSource = dataSource;
	}
	
	@Override
	public void save(Notifica notifica) 
	{
		Connection connection = this.dataSource.getConnection();
		try 
		{
			String insert = "insert into notifica(id_post, username, id_commento) values (?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setInt(1, notifica.getPost().getId());
			statement.setString(2, notifica.getUsername());
			statement.setInt(3, notifica.getCommento().getId());
			
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
	public void delete(Notifica notifica) 
	{
		Connection connection = this.dataSource.getConnection();
		try 
		{
			String delete = "delete from notifica where notifica.id_notifica = ?";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setInt(1, notifica.getIdNotifica());
			
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

	public List<Notifica> findNotificheByUsername(String username) 
	{
		Connection connection = this.dataSource.getConnection();
		List<Notifica> notifiche = new LinkedList<>();
		try 
		{
			String query = "SELECT * FROM notifica WHERE notifica.username = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, username);
			ResultSet result = statement.executeQuery();
			while (result.next())
			{
				Notifica notifica = new Notifica();
				notifica.setIdNotifica(result.getInt("id_notifica"));
				notifica.setUsername(result.getString("username"));
				Post post = DatabaseManager.getInstance().getDaoFactory().getPostDAO().findByPrimaryKey(result.getInt("id_post"));
				notifica.setPost(post);
				Commento commento = DatabaseManager.getInstance().getDaoFactory().getCommentoDAO().findByPrimaryKey(result.getInt("id_commento"));
				notifica.setCommento(commento);			
				
				notifiche.add(notifica);
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
		return notifiche;
	}
}
