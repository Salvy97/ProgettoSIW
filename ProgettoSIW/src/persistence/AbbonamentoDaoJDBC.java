package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import model.Abbonamento;
import model.Utente;
import persistence.dao.AbbonamentoDAO;

public class AbbonamentoDaoJDBC implements AbbonamentoDAO {
  private DataSource dataSource;

  public AbbonamentoDaoJDBC(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  public void save(Abbonamento abbonamento) {
    Connection connection = null;
    try {
      connection = this.dataSource.getConnection();
      String insert =
          "INSERT INTO public.abbonamenti(name, desc, due_date) VALUES (?, ?, ?)";
      PreparedStatement statement = connection.prepareStatement(insert);
      statement.setInt(1, abbonamento.getId());
      statement.setString(2, abbonamento.getName());
      statement.setString(3, abbonamento.getDesc());
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

  public Abbonamento findByPrimaryKey(int id) {
    Connection connection = null;
    Abbonamento abbonamento = null;
    try {
      connection = this.dataSource.getConnection();
      PreparedStatement statement;
      String query =
          "SELECT * FROM public.abbonamenti WHERE public.abbonamenti.id = ?";
      statement = connection.prepareStatement(query);
      statement.setInt(1, id);
      ResultSet result = statement.executeQuery();
      if (result.next()) {
        abbonamento = new Abbonamento();
				abbonamento.setId(result.getInt("id"));
				abbonamento.setName(result.getString("name"));
				abbonamento.setDesc(result.getString("desc"));
        abbonamento.setPrice(result.getDouble("price"));
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
    return abbonamento;
  }

  public List<Abbonamento> findAll() {
    Connection connection = null;
    List<Abbonamento> abbonamenti = new LinkedList<>();
    try {
      connection = this.dataSource.getConnection();
      Abbonamento abbonamento;
      PreparedStatement statement;
      String query = "SELECT * FROM public.abbonamenti";
      statement = connection.prepareStatement(query);
      ResultSet result = statement.executeQuery();
      while (result.next()) {
        abbonamento = new Abbonamento();
		abbonamento.setId(result.getInt("id"));
		abbonamento.setName(result.getString("name"));
		abbonamento.setDesc(result.getString("desc"));
		abbonamento.setPrice(result.getDouble("price"));
        abbonamenti.add(abbonamento);
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
    return abbonamenti;
  }

  public List<Abbonamento> findAllByUser(Utente utente) {
    Connection connection = null;
    List<Abbonamento> abbonamenti = new LinkedList<>();
    try {
      connection = this.dataSource.getConnection();
      Abbonamento abbonamento;
      PreparedStatement statement;
      String query =
          "SELECT * FROM public.abbonamenti WHERE public.abbonamenti.user_id = ?";
      statement = connection.prepareStatement(query);
      statement.setInt(1, utente.getId());
      ResultSet result = statement.executeQuery();
      while (result.next()) {
        abbonamento = new Abbonamento();
				abbonamento.setId(result.getInt("id"));
				abbonamento.setName(result.getString("name"));
				abbonamento.setDesc(result.getString("desc"));
        abbonamento.setPrice(result.getDouble("price"));
        abbonamenti.add(abbonamento);
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
    return abbonamenti;
  }

  public void update(Abbonamento abbonamento) {
    Connection connection = null;
    try {
      connection = this.dataSource.getConnection();
      String update =
          "UPDATE public.abbonamenti SET user_id = ?, abbonamento_id = ?, due_date = ?  WHERE user_id = ? ";
      PreparedStatement statement = connection.prepareStatement(update);
      statement.setInt(1, abbonamento.getId());
      statement.setString(2, abbonamento.getName());
      statement.setString(3, abbonamento.getDesc());
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

  public void delete(Abbonamento abbonamento) {
    Connection connection = null;
    try {
      connection = this.dataSource.getConnection();
      String delete =
          "DELETE FROM public.abbonamenti WHERE public.abbonamenti.user_id = ?";
      PreparedStatement statement = connection.prepareStatement(delete);
      statement.setLong(2, abbonamento.getId());
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
