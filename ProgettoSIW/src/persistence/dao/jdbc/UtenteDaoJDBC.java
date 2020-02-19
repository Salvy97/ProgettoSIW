package persistence.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.Utente;
import persistence.DataSource;
import persistence.dao.UtenteDAO;

public class UtenteDaoJDBC implements UtenteDAO {
	private DataSource dataSource;

	public UtenteDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void save(Utente utente) {
		// to be...
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
				utente.setHash(result.getString("hash"));
				utente.setRole(result.getString("ruolo"));
				utente.setUsernamePP(result.getString("username_pp"));
				utente.setAutoRenew(result.getBoolean("autorenew"));
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
	      String update = "UPDATE public.utente SET username = ?, hash = ?, ruolo = ?, autorenew = ?, username_pp = ?  WHERE id = ? ";
	      PreparedStatement statement = connection.prepareStatement(update);
	      statement.setString(1, utente.getUsername());
	      statement.setString(2, utente.getHash());
	      statement.setString(3, utente.getRole());
	      statement.setBoolean(4, utente.getAutoRenew());
	      statement.setString(5, utente.getUsernamePP());
	      statement.setInt(6, utente.getId());
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

	public Utente findByCredentials(String email, String password) {
		// ...
		return null;
	}
}
