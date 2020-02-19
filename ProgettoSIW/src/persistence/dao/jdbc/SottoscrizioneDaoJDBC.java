package persistence.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import model.Sottoscrizione;
import model.Utente;
import persistence.DatabaseManager;
import persistence.DataSource;
import persistence.dao.SottoscrizioneDAO;

public class SottoscrizioneDaoJDBC implements SottoscrizioneDAO {
  private DataSource dataSource;

  public SottoscrizioneDaoJDBC(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  public void save(Sottoscrizione sottoscrizione) {
    Connection connection = null;
    try {
      connection = this.dataSource.getConnection();
      String insert =
          "INSERT INTO public.sottoscrizioni(user_id, abbonamento_id, due_date) VALUES (?, ?, ?)";
      PreparedStatement statement = connection.prepareStatement(insert);
      System.out.println("Inserisco la sottoscrizione " + sottoscrizione.getUser().getUsername());
      statement.setInt(1, sottoscrizione.getUser().getId());
      statement.setInt(2, sottoscrizione.getAbbonamento().getId());
      statement.setString(3, sottoscrizione.getDueDate());
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
  public Sottoscrizione findByUser(int user_id) {
	    Connection connection = null;
	    Sottoscrizione sottoscrizione = null;
	    try {
	      connection = this.dataSource.getConnection();
	      PreparedStatement statement;
	      String query =
	          "SELECT * FROM public.sottoscrizioni WHERE public.sottoscrizioni.user_id = ?";
	      statement = connection.prepareStatement(query);
	      statement.setInt(1, user_id);
	      ResultSet result = statement.executeQuery();
	      if (result.next()) {
	        sottoscrizione = new Sottoscrizione();
	        sottoscrizione.setDueDate(result.getString("due_date"));
	        sottoscrizione.setId(result.getInt("id"));
	        sottoscrizione.setUser(
	            DatabaseManager.getInstance().getDaoFactory().getUtenteDAO().findByPrimaryKey(
	                result.getInt("user_id")));
	        sottoscrizione.setAbbonamento(
	            DatabaseManager.getInstance().getDaoFactory().getAbbonamentoDAO().findByPrimaryKey(
	                result.getInt("abbonamento_id")));
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
	    return sottoscrizione;
	  }
  public Sottoscrizione findByPrimaryKey(int id) {
    Connection connection = null;
    Sottoscrizione sottoscrizione = null;
    try {
      connection = this.dataSource.getConnection();
      PreparedStatement statement;
      String query =
          "SELECT * FROM public.sottoscrizioni WHERE public.sottoscrizioni.id = ?";
      statement = connection.prepareStatement(query);
      statement.setInt(1, id);
      ResultSet result = statement.executeQuery();
      if (result.next()) {
        sottoscrizione = new Sottoscrizione();
sottoscrizione.setId(result.getInt("id"));
sottoscrizione.setDueDate(result.getString("due_date"));
        sottoscrizione.setUser(
            DatabaseManager.getInstance().getDaoFactory().getUtenteDAO().findByPrimaryKey(
                result.getInt("user_id")));
        sottoscrizione.setAbbonamento(
            DatabaseManager.getInstance().getDaoFactory().getAbbonamentoDAO().findByPrimaryKey(
                result.getInt("abbonamento_id")));
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
    return sottoscrizione;
  }

  public List<Sottoscrizione> findAll() {
    Connection connection = null;
    List<Sottoscrizione> sottoscrizioni = new LinkedList<>();
    try {
      connection = this.dataSource.getConnection();
      Sottoscrizione sottoscrizione;
      PreparedStatement statement;
      String query = "SELECT * FROM public.sottoscrizioni";
      statement = connection.prepareStatement(query);
      ResultSet result = statement.executeQuery();
      while (result.next()) {
        sottoscrizione = new Sottoscrizione();
        sottoscrizione.setId(result.getInt("id"));
        sottoscrizione.setDueDate(result.getString("due_date"));
        sottoscrizione.setUser(
            DatabaseManager.getInstance().getDaoFactory().getUtenteDAO().findByPrimaryKey(
                result.getInt("user_id")));
        sottoscrizione.setAbbonamento(
            DatabaseManager.getInstance().getDaoFactory().getAbbonamentoDAO().findByPrimaryKey(
                result.getInt("abbonamento_id")));
        sottoscrizioni.add(sottoscrizione);
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
    return sottoscrizioni;
  }

  public List<Sottoscrizione> findAllByUser(Utente utente) {
    Connection connection = null;
    List<Sottoscrizione> sottoscrizioni = new LinkedList<>();
    try {
      connection = this.dataSource.getConnection();
      Sottoscrizione sottoscrizione;
      PreparedStatement statement;
      String query =
          "SELECT * FROM public.sottoscrizioni WHERE public.sottoscrizioni.user_id = ?";
      statement = connection.prepareStatement(query);
      statement.setInt(1, utente.getId());
      ResultSet result = statement.executeQuery();
      while (result.next()) {
        sottoscrizione = new Sottoscrizione();
sottoscrizione.setId(result.getInt("id"));
sottoscrizione.setDueDate(result.getString("due_date"));
        sottoscrizione.setUser(
            DatabaseManager.getInstance().getDaoFactory().getUtenteDAO().findByPrimaryKey(
                result.getInt("user_id")));
        sottoscrizione.setAbbonamento(
            DatabaseManager.getInstance().getDaoFactory().getAbbonamentoDAO().findByPrimaryKey(
                result.getInt("abbonamento_id")));
        sottoscrizioni.add(sottoscrizione);
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
    return sottoscrizioni;
  }

  public void update(Sottoscrizione sottoscrizione) {
    Connection connection = null;
    try {
      connection = this.dataSource.getConnection();
      String update =
          "UPDATE public.sottoscrizioni SET user_id = ?, abbonamento_id = ?, due_date = ?  WHERE user_id = ? ";
      PreparedStatement statement = connection.prepareStatement(update);
      statement.setInt(1, sottoscrizione.getUser().getId());
      statement.setInt(2, sottoscrizione.getAbbonamento().getId());
      statement.setString(3, sottoscrizione.getDueDate());
      statement.setInt(4, sottoscrizione.getUser().getId());
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

  public void delete(Sottoscrizione sottoscrizione) {
    Connection connection = null;
    try {
      connection = this.dataSource.getConnection();
      String delete =
          "DELETE FROM public.sottoscrizioni WHERE public.sottoscrizioni.user_id = ?";
      PreparedStatement statement = connection.prepareStatement(delete);
      statement.setLong(2, sottoscrizione.getUser().getId());
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
}
