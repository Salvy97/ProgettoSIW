package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Profilo;
import persistence.dao.ProfiloDAO;

public class ProfiloDAOJDBC implements ProfiloDAO 
{
	private DataSource dataSource;

	public ProfiloDAOJDBC(DataSource dataSource) 
	{
		this.dataSource = dataSource;
	}
	
	@Override
	public void save(Profilo profilo) 
	{
		Connection connection = this.dataSource.getConnection();
		try 
		{
			String insert = "insert into profilo(username, contenuti_guardati,"
					+ " posts_creati, recensioni_effettuate, immagine_di_profilo) values (?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setString(1, profilo.getUsername());
			statement.setInt(2, 0);
			statement.setInt(3, 0);
			statement.setInt(4, 0);
			statement.setString(5, "images/noProfilePicture.png");
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
	public Profilo findByUsername(String username) 
	{
		Connection connection = this.dataSource.getConnection();
		Profilo profilo = null;
		try 
		{
			PreparedStatement statement;
			String query = "select * from profilo where username = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, username);
			ResultSet result = statement.executeQuery();
			if (result.next()) 
			{
				profilo = new Profilo();
				profilo.setIdProfilo(result.getInt("id_profilo"));	
				profilo.setUsername(result.getString("username"));
				profilo.setContenutiGuardati(result.getInt("contenuti_guardati"));
				profilo.setPostsCreati(result.getInt("posts_creati"));
				profilo.setRecensioniEffettuate(result.getInt("recensioni_effettuate"));
				profilo.setImmagineDiProfilo(result.getString("immagine_di_profilo"));
			}
			PreparedStatement statement2 = connection.prepareStatement("select * from utente where username = ?");
			statement2.setString(1, username);
			ResultSet emailUtenteResult = statement2.executeQuery();
			if (emailUtenteResult.next())
			{
				profilo.setEmail(emailUtenteResult.getString("email"));
				profilo.setNome(emailUtenteResult.getString("nome"));
				profilo.setCognome(emailUtenteResult.getString("cognome"));
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
		return profilo;
	}

	@Override
	public void update(Profilo profilo) 
	{
		Connection connection = this.dataSource.getConnection();
		try 
		{
			String update = "update profilo SET username = ?, contenuti_guardati = ?, posts_creati = ?, recensioni_effettuate = ?, immagine_di_profilo = ? WHERE id_profilo = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, profilo.getUsername());
			statement.setInt(2, profilo.getContenutiGuardati());
			statement.setInt(3, profilo.getPostsCreati());
			statement.setInt(4, profilo.getRecensioniEffettuate());
			statement.setString(5, profilo.getImmagineDiProfilo());
			statement.setInt(6, profilo.getIdProfilo());
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
	public void delete(Profilo profilo) {}

	public void aumentaContenutiGuardati(String username) 
	{
		Connection connection = this.dataSource.getConnection();
		int contenutiGuardati = -1;
		try 
		{
			PreparedStatement statement;
			String query = "select contenuti_guardati from profilo where username = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, username);
			ResultSet result = statement.executeQuery();
			if (result.next())
			{
				contenutiGuardati = result.getInt(1);
			}
			contenutiGuardati++;
			query = "UPDATE public.profilo SET contenuti_guardati = ? WHERE username = ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, contenutiGuardati);
			statement.setString(2, username);
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

	public void aumentaPostsCreati(String username) 
	{
		Connection connection = this.dataSource.getConnection();
		int postsCreati = -1;
		try 
		{
			PreparedStatement statement;
			String query = "select posts_creati from profilo where username = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, username);
			ResultSet result = statement.executeQuery();
			if (result.next())
			{
				postsCreati = result.getInt(1);
			}
			postsCreati++;
			query = "UPDATE public.profilo SET posts_creati = ? WHERE username = ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, postsCreati);
			statement.setString(2, username);
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

	public void aumentaRecensioniEffettuate(String username) 
	{
		Connection connection = this.dataSource.getConnection();
		int recensioniEffettuate = -1;
		try 
		{
			PreparedStatement statement;
			String query = "select recensioni_effettuate from profilo where username = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, username);
			ResultSet result = statement.executeQuery();
			if (result.next())
			{
				recensioniEffettuate = result.getInt(1);
			}
			recensioniEffettuate++;
			query = "UPDATE public.profilo SET recensioni_effettuate = ? WHERE username = ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, recensioniEffettuate);
			statement.setString(2, username);
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