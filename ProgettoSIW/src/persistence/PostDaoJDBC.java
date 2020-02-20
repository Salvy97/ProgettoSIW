package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import model.Commento;
import model.Post;
import persistence.dao.PostDao;

public class PostDaoJDBC implements PostDao {
	
	private DataSource dataSource;

	public PostDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void save(Post post) {
		Connection connection = this.dataSource.getConnection();
		try {
			String insert = "insert into post(data, ora,"
					+ " titolo_post, descrizione, username, contenuto) values (?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setString(1, post.getData());
			statement.setString(2, post.getOra());
			statement.setString(3, post.getTitolo());
			statement.setString(4, post.getDescrizione());
			statement.setString(5, post.getUsername());
			statement.setInt(6, post.getContenuto());

			statement.executeUpdate();
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

	public Post findByPrimaryKey(String id) {
		Connection connection = this.dataSource.getConnection();
		Post post = null;
		try {
			PreparedStatement statement;
			String query = "select * from post where id = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, id);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				post = new Post();
				post.setId(result.getInt("id"));				
				post.setData(result.getString("data"));
				post.setOra(result.getString("ora"));
				post.setTitolo(result.getString("titolo_post"));
				post.setDescrizione(result.getString("descrizione"));
				post.setUsername(result.getString("username"));
				post.setContenuto(result.getInt("contenuto"));
				
				PreparedStatement getProfilePic = connection.prepareStatement("select immagine_di_profilo from profilo inner join post on profilo.username = " + "'" + post.getUsername() + "'");
				ResultSet picResult = getProfilePic.executeQuery();
				while (picResult.next())
					post.setProfileImage(picResult.getString(1));
				
				PreparedStatement getComments = connection.prepareStatement("select * from commento inner join post on commento.post = " + "'" + post.getId() + "'" + "and post.id = " + "'" + post.getId() + "'");
				ResultSet commentsResult = getComments.executeQuery();
				List<Commento> commenti = new ArrayList<Commento>();
				while (commentsResult.next())
				{
					Commento commento = new Commento();
					commento.setId(commentsResult.getInt("id"));
					commento.setCommento(commentsResult.getString("commento"));
					commento.setUsername(commentsResult.getString("username"));
					commento.setPost(commentsResult.getInt("post"));
					commenti.add(commento);
					PreparedStatement getProfilePicture = connection.prepareStatement("select immagine_di_profilo from profilo inner join commento on profilo.username = " + "'" + commento.getUsername() + "'");
					ResultSet profilePictureResults = getProfilePicture.executeQuery();
					while (profilePictureResults.next())
						commento.setProfilePicture(profilePictureResults.getString(1));
				}
				post.setCommenti(commenti);
			}
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}	
		return post;
	}

	public List<Post> findAll() {
		Connection connection = this.dataSource.getConnection();
		List<Post> posts = new LinkedList<>();
		try {
			Post post;
			PreparedStatement statement;
			String query = "select * from post order by data desc";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				post = new Post();
				post.setId(result.getInt("id"));				
				post.setData(result.getString("data"));
				post.setOra(result.getString("ora"));
				post.setTitolo(result.getString("titolo_post"));
				post.setDescrizione(result.getString("descrizione"));
				post.setUsername(result.getString("username"));
				post.setContenuto(result.getInt("contenuto"));
				
				PreparedStatement getProfilePic = connection.prepareStatement("select immagine_di_profilo from profilo inner join post on profilo.username = " + "'" + post.getUsername() + "'");
				ResultSet picResult = getProfilePic.executeQuery();
				while (picResult.next())
					post.setProfileImage(picResult.getString(1));
				
				PreparedStatement getComments = connection.prepareStatement("select * from commento inner join post on commento.post = " + "'" + post.getId() + "'" + "and post.id = " + "'" + post.getId() + "'");
				ResultSet commentsResult = getComments.executeQuery();
				List<Commento> commenti = new ArrayList<Commento>();
				while (commentsResult.next())
				{
					Commento commento = new Commento();
					commento.setId(commentsResult.getInt("id"));
					commento.setCommento(commentsResult.getString("commento"));
					commento.setUsername(commentsResult.getString("username"));
					commento.setPost(commentsResult.getInt("post"));
					commenti.add(commento);
					PreparedStatement getProfilePicture = connection.prepareStatement("select immagine_di_profilo from profilo inner join commento on profilo.username = " + "'" + commento.getUsername() + "'");
					ResultSet profilePictureResults = getProfilePicture.executeQuery();
					while (profilePictureResults.next())
						commento.setProfilePicture(profilePictureResults.getString(1));
				}
				post.setCommenti(commenti);
				
				posts.add(post);
			}
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		}	 finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
		return posts;
	}
		public List<Post> findAllByContentDeep0(String contenuto) {
		Connection connection = this.dataSource.getConnection();
		List<Post> posts = new LinkedList<>();
		try {
			Post post;
			PreparedStatement statement;
			String query = "select * from public.post WHERE contenuto = ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, Integer.parseInt(contenuto));
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				post = new Post();
				post.setId(result.getInt("id"));				
				post.setData(result.getString("data"));
				post.setOra(result.getString("ora"));
				post.setTitolo(result.getString("titolo_post"));
				post.setDescrizione(result.getString("descrizione"));
				post.setUsername(result.getString("username"));
				post.setContenuto(result.getInt("contenuto"));
				posts.add(post);
			}
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		}	 finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
		return posts;
	}
		
	public List<Post> findPostsOfThatContent(String contenuto) 
	{
		Connection connection = this.dataSource.getConnection();
		List<Post> posts = new LinkedList<>();
		try {
			Post post;
			PreparedStatement statement;
			String query = "select * from post order by data desc";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				post = new Post();
				post.setId(result.getInt("id"));				
				post.setData(result.getString("data"));
				post.setOra(result.getString("ora"));
				post.setTitolo(result.getString("titolo_post"));
				post.setDescrizione(result.getString("descrizione"));
				post.setUsername(result.getString("username"));
				post.setContenuto(result.getInt("contenuto"));
				
				PreparedStatement getProfilePic = connection.prepareStatement("select immagine_di_profilo from profilo inner join post on profilo.username = " + "'" + post.getUsername() + "'");
				ResultSet picResult = getProfilePic.executeQuery();
				while (picResult.next())
					post.setProfileImage(picResult.getString(1));
				
				PreparedStatement getComments = connection.prepareStatement("select * from commento inner join post on commento.post = " + "'" + post.getId() + "'" + "and post.id = " + "'" + post.getId() + "'");
				ResultSet commentsResult = getComments.executeQuery();
				List<Commento> commenti = new ArrayList<Commento>();
				while (commentsResult.next())
				{
					Commento commento = new Commento();
					commento.setId(commentsResult.getInt("id"));
					commento.setCommento(commentsResult.getString("commento"));
					commento.setUsername(commentsResult.getString("username"));
					commento.setPost(commentsResult.getInt("post"));
					commenti.add(commento);
					PreparedStatement getProfilePicture = connection.prepareStatement("select immagine_di_profilo from profilo inner join commento on profilo.username = " + "'" + commento.getUsername() + "'");
					ResultSet profilePictureResults = getProfilePicture.executeQuery();
					while (profilePictureResults.next())
						commento.setProfilePicture(profilePictureResults.getString(1));
				}
				post.setCommenti(commenti);
				
				PreparedStatement getTitoloContenuto = connection.prepareStatement("select titolo from film inner join post on film.id_film = " + "'" + post.getContenuto() + "'");
				ResultSet titoloResult = getTitoloContenuto.executeQuery();
				String titoloContenuto = "";
				while (titoloResult.next())
					titoloContenuto = titoloResult.getString(1);
				
				if (titoloContenuto.equals(contenuto))
					posts.add(post);
			}
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		}	 finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
		return posts;
	}
	
	public List<Post> findPostsOfThatUser(String username) 
	{
		Connection connection = this.dataSource.getConnection();
		List<Post> posts = new LinkedList<>();
		try 
		{
			Post post;
			PreparedStatement statement;
			String query = "select * from post where post.username = ? order by data desc";
			statement = connection.prepareStatement(query);
			statement.setString(1, username);
			ResultSet result = statement.executeQuery();
			while (result.next()) 
			{
				post = new Post();
				post.setId(result.getInt("id"));				
				post.setData(result.getString("data"));
				post.setOra(result.getString("ora"));
				post.setTitolo(result.getString("titolo_post"));
				post.setDescrizione(result.getString("descrizione"));
				post.setUsername(result.getString("username"));
				post.setContenuto(result.getInt("contenuto"));
				
				PreparedStatement getProfilePic = connection.prepareStatement("select immagine_di_profilo from profilo inner join post on profilo.username = " + "'" + post.getUsername() + "'");
				ResultSet picResult = getProfilePic.executeQuery();
				while (picResult.next())
					post.setProfileImage(picResult.getString(1));
				
				PreparedStatement getComments = connection.prepareStatement("select * from commento inner join post on commento.post = " + "'" + post.getId() + "'" + "and post.id = " + "'" + post.getId() + "'");
				ResultSet commentsResult = getComments.executeQuery();
				List<Commento> commenti = new ArrayList<Commento>();
				while (commentsResult.next())
				{
					Commento commento = new Commento();
					commento.setId(commentsResult.getInt("id"));
					commento.setCommento(commentsResult.getString("commento"));
					commento.setUsername(commentsResult.getString("username"));
					commento.setPost(commentsResult.getInt("post"));
					commenti.add(commento);
					PreparedStatement getProfilePicture = connection.prepareStatement("select immagine_di_profilo from profilo inner join commento on profilo.username = " + "'" + commento.getUsername() + "'");
					ResultSet profilePictureResults = getProfilePicture.executeQuery();
					while (profilePictureResults.next())
						commento.setProfilePicture(profilePictureResults.getString(1));
				}
				post.setCommenti(commenti);
				posts.add(post);
			}
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		}	 finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
		return posts;
	}

	public void update(Post post) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update post SET data = ?, ora = ?, titolo_post = ?, descrizione = ?, username = ? WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, post.getData());
			statement.setString(2, post.getOra());
			statement.setString(3, post.getTitolo());
			statement.setString(4, post.getDescrizione());
			statement.setString(5, post.getUsername());
			statement.setInt(6, post.getId());
			statement.executeUpdate();
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

	public void delete(Post post) {
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "delete FROM public.post WHERE id = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			
			List<Commento> commenti = DatabaseManager.getInstance().getDaoFactory().getCommentoDAO().findByContent(post.getId());
			System.out.println("Lista dei commenti ottenuta");
			
			if (commenti != null) {
				System.out.println("  Commenti presenti " + commenti.size());
				for(Commento c : commenti) {
					if (c != null)DatabaseManager.getInstance().getDaoFactory().getCommentoDAO().delete(c);
				}
				System.out.println("Commenti eliminati");
			}
			
			System.out.println("    Elimino Post " + post.getId());
			statement.setInt(1, post.getId());
			statement.executeUpdate();
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
}