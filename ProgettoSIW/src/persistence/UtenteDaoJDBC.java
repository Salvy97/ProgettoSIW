package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.Utente;
import persistence.dao.UtenteDAO;

public class UtenteDaoJDBC implements UtenteDAO {
	private DataSource dataSource;

	public UtenteDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void save(Utente utente) 
	{
		Connection connection = null;
		try 
		{
			connection = this.dataSource.getConnection();
			PreparedStatement statement;
			String query = "insert into utente(username, email, password, nome, cognome) values (?,?,?,?,?)";
			statement = connection.prepareStatement(query);
			statement.setString(1, utente.getUsername());
			statement.setString(2, utente.getEmail());
			statement.setString(3, utente.getPassword());
			statement.setString(4, utente.getNome());
			statement.setString(5, utente.getCognome());
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

	public Utente findByPrimaryKey(int id) {
		Connection connection = null;
		Utente utente = null;
		try {
			connection = this.dataSource.getConnection();
			PreparedStatement statement;
			String query = "SELECT * FROM public.utente WHERE public.utente.id = ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				utente = new Utente();
				utente.setId(result.getInt("id"));
				utente.setUsername(result.getString("username"));
				utente.setRole(result.getString("ruolo"));
				utente.setUsernamePP(result.getString("username_pp"));
				utente.setAutoRenew(result.getBoolean("autorenew"));
				utente.setEmail(result.getString("email"));
				utente.setPassword(result.getString("password"));
				utente.setPassword(result.getString("nome"));
				utente.setPassword(result.getString("cognome"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return utente;
	}

	public List<Utente> findAll() {
		// ...
		return null;
	}

	public void update(Utente utente) {
		Connection connection = null;
	    try {
	      connection = this.dataSource.getConnection();
	      String update = "UPDATE public.utente SET username = ?, ruolo = ?, autorenew = ?, username_pp = ?, email = ?, password = ?, nome = ?, cognome = ? WHERE id = ? ";
	      PreparedStatement statement = connection.prepareStatement(update);
	      statement.setString(1, utente.getUsername());
	      statement.setString(3, utente.getRole());
	      statement.setBoolean(4, utente.getAutoRenew());
	      statement.setString(5, utente.getUsernamePP());
	      statement.setInt(6, utente.getId());
	      statement.setString(7, utente.getEmail());
	      statement.setString(8, utente.getPassword());
	      statement.setString(9, utente.getNome());
	      statement.setString(10, utente.getCognome());
	      statement.executeUpdate();
	    } catch (SQLException e) {
	      throw new RuntimeException(e.getMessage());
	    } finally {
	      try {
	        connection.close();
	      } catch (SQLException e) {
	        throw new RuntimeException(e.getMessage());
	      }
	    }
	}

	public void delete(Utente utente) {
		// ...
	}

	public Utente findByEmail(String email) {
		Connection connection = null;
		Utente utente = null;
		try {
			connection = this.dataSource.getConnection();
			PreparedStatement statement;
			String query = "SELECT * FROM public.utente WHERE public.utente.email = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, email);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				utente = new Utente();
				utente.setId(result.getInt("id"));
				utente.setUsername(result.getString("username"));
				utente.setRole(result.getString("ruolo"));
				utente.setUsernamePP(result.getString("username_pp"));
				utente.setAutoRenew(result.getBoolean("autorenew"));
				utente.setEmail(result.getString("email"));
				utente.setPassword(result.getString("password"));
				utente.setNome(result.getString("nome"));
				utente.setCognome(result.getString("cognome"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return utente;
	}
}
