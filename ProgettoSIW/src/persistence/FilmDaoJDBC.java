package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import model.ContenutoPreferito;
import model.Film;
import model.Post;
import persistence.dao.FilmDao;

class FilmDaoJDBC implements FilmDao {
	
	private DataSource dataSource;

	public FilmDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void save(Film film) {
		Connection connection = this.dataSource.getConnection();
		try {
			String insert = "insert into film(titolo, anno,"
					+ " durata, genere, locandina, regista, filmato, data_inserimento, visualizzazioni, immagine_forum, sinossi) values (?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);

			statement.setString(1, film.getTitolo());
			statement.setInt(2, film.getAnno());
			statement.setInt(3, film.getDurata());
			statement.setString(4, film.getGenere());
			statement.setString(5, film.getLocandina());
			statement.setString(6, film.getRegista());
			statement.setString(7, film.getFilmato());
			Timestamp timestamp = new Timestamp(new Date().getTime());
			statement.setTimestamp(8, timestamp);
			statement.setInt(9, film.getVisualizzazioni());
			statement.setString(10, film.getImmagineForum());
			statement.setString(11, film.getSinossi());

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
	
	
	public List<Film> findByTitle(String title) 
	{
		Connection connection = this.dataSource.getConnection();
		List<Film> films = new LinkedList<>();
		try
		{
			Film film;
			PreparedStatement statement;
			String query = "select * from film";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) 
			{
				film = new Film();
				film.setId_film(result.getInt("id_film"));				
				film.setTitolo(result.getString("titolo"));
				film.setAnno(result.getInt("anno"));
				film.setDurata(result.getInt("durata"));
				film.setGenere(result.getString("genere"));
				film.setLocandina(result.getString("locandina"));
				film.setImmagineForum(result.getString("immagine_forum"));
				film.setSinossi(result.getString("sinossi"));
				
				if (film.getTitolo().toUpperCase().contains(title.toUpperCase()))
					films.add(film);
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
			} catch (SQLException e) 
			{
				throw new PersistenceException(e.getMessage());
			}
		}
		return films;
	}

	public List<Film> cercaPerTitolo(String titolo) {
		Connection connection = this.dataSource.getConnection();
		List<Film> films = new LinkedList<>();
		try {
			Film film;
			PreparedStatement statement;
			String query = "select * from film where titolo ilike ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, "%"+titolo+"%");
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				film = new Film();
				film.setId_film(result.getInt("id_film"));				
				film.setTitolo(result.getString("titolo"));
				film.setAnno(result.getInt("anno"));
				film.setDurata(result.getInt("durata"));
				film.setGenere(result.getString("genere"));
				film.setLocandina(result.getString("locandina"));
				film.setRegista(result.getString("regista"));
				film.setImmagineForum(result.getString("immagine_forum"));
				film.setSinossi(result.getString("sinossi"));
				
				films.add(film);
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
		return films;
	}
	
	public List<Film> cercaPerRegista(String regista) {
		Connection connection = this.dataSource.getConnection();
		List<Film> films = new LinkedList<>();
		try {
			Film film;
			PreparedStatement statement;
			String query = "select * from film where regista ilike ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, "%"+regista+"%");
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				film = new Film();
				film.setId_film(result.getInt("id_film"));				
				film.setTitolo(result.getString("titolo"));
				film.setAnno(result.getInt("anno"));
				film.setDurata(result.getInt("durata"));
				film.setGenere(result.getString("genere"));
				film.setLocandina(result.getString("locandina"));
				film.setRegista(result.getString("regista"));
				film.setImmagineForum(result.getString("immagine_forum"));
				film.setSinossi(result.getString("sinossi"));
				
				films.add(film);
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
		return films;
	}
	
	
	public List<Film> cercaPerCarattere(String carattere) {
		Connection connection = this.dataSource.getConnection();
		List<Film> films = new LinkedList<>();
		try {
			Film film;
			PreparedStatement statement;
			String query = "select * from film where titolo like ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, carattere+"%");
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				film = new Film();
				film.setId_film(result.getInt("id_film"));				
				film.setTitolo(result.getString("titolo"));
				film.setAnno(result.getInt("anno"));
				film.setDurata(result.getInt("durata"));
				film.setGenere(result.getString("genere"));
				film.setLocandina(result.getString("locandina"));
				film.setRegista(result.getString("regista"));
				film.setImmagineForum(result.getString("immagine_forum"));
				film.setSinossi(result.getString("sinossi"));
				
				films.add(film);
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
		return films;
	}
	

	public List<Film> findAll() {
		Connection connection = this.dataSource.getConnection();
		List<Film> films = new LinkedList<>();
		try {
			Film film;
			PreparedStatement statement;
			String query = "select * from film ORDER BY titolo ASC";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				film = new Film();
				film.setId_film(result.getInt("id_film"));				
				film.setTitolo(result.getString("titolo"));
				film.setAnno(result.getInt("anno"));
				film.setDurata(result.getInt("durata"));
				film.setGenere(result.getString("genere"));
				film.setLocandina(result.getString("locandina"));
				film.setRegista(result.getString("regista"));
				film.setFilmato(result.getString("filmato"));
				film.setImmagineForum(result.getString("immagine_forum"));
				film.setSinossi(result.getString("sinossi"));
				
				films.add(film);
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
		return films;
	}
	
	public List<Film> cercaUltimiInseriti() {
		Connection connection = this.dataSource.getConnection();
		List<Film> films = new LinkedList<>();
		try {
			Film film;
			PreparedStatement statement;
			String query = "select * from film ORDER BY data_inserimento DESC LIMIT 3";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				film = new Film();
				film.setId_film(result.getInt("id_film"));				
				film.setTitolo(result.getString("titolo"));
				film.setAnno(result.getInt("anno"));
				film.setDurata(result.getInt("durata"));
				film.setGenere(result.getString("genere"));
				film.setLocandina(result.getString("locandina"));
				film.setRegista(result.getString("regista"));
				film.setData_inserimento(result.getDate("data_inserimento"));
				film.setImmagineForum(result.getString("immagine_forum"));
				film.setSinossi(result.getString("sinossi"));
				
				films.add(film);
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
		return films;
	}
	
	public List<Film> cercaPiuVisti() {
		Connection connection = this.dataSource.getConnection();
		List<Film> films = new LinkedList<>();
		try {
			Film film;
			PreparedStatement statement;
			String query = "select * from film order by visualizzazioni DESC LIMIT 3";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				film = new Film();
				film.setId_film(result.getInt("id_film"));				
				film.setTitolo(result.getString("titolo"));
				film.setAnno(result.getInt("anno"));
				film.setDurata(result.getInt("durata"));
				film.setGenere(result.getString("genere"));
				film.setLocandina(result.getString("locandina"));
				film.setRegista(result.getString("regista"));
				film.setData_inserimento(result.getDate("data_inserimento"));
				film.setVisualizzazioni(result.getInt("visualizzazioni"));
				film.setImmagineForum(result.getString("immagine_forum"));
				film.setSinossi(result.getString("sinossi"));
				
				films.add(film);
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
		return films;
	}
	

	public void update(Film film) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "UPDATE film SET titolo = ?, anno = ?, durata = ?, genere = ?, locandina = ?, regista = ?, filmato = ?, visualizzazioni = ?, immagine_forum = ?, sinossi = ? WHERE id_film = ?";

			System.out.println("Update " + film.getId_film());
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, film.getTitolo());
			statement.setInt(2, film.getAnno());
			statement.setInt(3, film.getDurata());
			statement.setString(4, film.getGenere());
			statement.setString(5, film.getLocandina());
			statement.setString(6, film.getRegista());
			statement.setString(7, film.getFilmato());
			statement.setInt(8, film.getVisualizzazioni());
			statement.setString(9, film.getImmagineForum());
			statement.setString(10, film.getSinossi());
			statement.setInt(11, film.getId_film());

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

	
	
	public Film cercaPerId(int id) {
		Connection connection = this.dataSource.getConnection();
		Film film = null;
		try {
			PreparedStatement statement;
			String query = "select * from film where id_film = ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				film = new Film();
				film.setId_film(result.getInt("id_film"));				
				film.setTitolo(result.getString("titolo"));
				film.setAnno(result.getInt("anno"));
				film.setDurata(result.getInt("durata"));
				film.setGenere(result.getString("genere"));
				film.setLocandina(result.getString("locandina"));
				film.setRegista(result.getString("regista"));
				film.setFilmato(result.getString("filmato"));
				film.setVisualizzazioni(result.getInt("visualizzazioni"));
				film.setImmagineForum(result.getString("immagine_forum"));
				film.setSinossi(result.getString("sinossi"));
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
		return film;
	}

	
	
	@Override
	public List<Film> findBySearchForm(String genere, int anno) {
		Connection connection = this.dataSource.getConnection();
		List<Film> films = new LinkedList<>();
		try {
			Film film;
			PreparedStatement statement = null;
			String query1 = "select * from film where genere = ?";
			String query2 = "select * from film where anno = ?";
			String query3 = "select * from film where genere = ? and anno = ?";
			
						
			if(!genere.equals("---")) {
				statement = connection.prepareStatement(query1);
				statement.setString(1, genere);				
			}
			
			if(anno!=0) {
				statement = connection.prepareStatement(query2);
				statement.setInt(1, anno);
			}
			
			if(!genere.equals("---") && anno!=0) {
				statement = connection.prepareStatement(query3);
				statement.setString(1, genere);
				statement.setInt(2, anno);
			}
			
			if(!genere.equals("---") || anno!=0) {
				ResultSet result = statement.executeQuery();
				
				while (result.next()) {
					film = new Film();
					film.setId_film(result.getInt("id_film"));				
					film.setTitolo(result.getString("titolo"));
					film.setAnno(result.getInt("anno"));
					film.setDurata(result.getInt("durata"));
					film.setGenere(result.getString("genere"));
					film.setLocandina(result.getString("locandina"));
					film.setRegista(result.getString("regista"));
					
					films.add(film);
				}
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
		return films;
	}

	
	/*public void delete(Film film) {
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "delete FROM film WHERE id_film = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setInt(1, film.getId_film());
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
	}*/
	

	public void delete(Film film) {
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "delete FROM film WHERE id_film = ? ";

			List<Post> postCorrelatiAlFilm = DatabaseManager.getInstance().getDaoFactory().getPostDAO().findAllByContentDeep0(film.getTitolo());
			
			if (postCorrelatiAlFilm != null) {
				System.out.println("Lista dei post ottenuta " + postCorrelatiAlFilm.size());
				for (Post p : postCorrelatiAlFilm) {
					System.out.println(p.getId());
					DatabaseManager.getInstance().getDaoFactory().getPostDAO().delete(p);
				}
				System.out.println("Post eliminati");
			}
			
			System.out.println("    Elimino Film " + film.getId_film());			
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setInt(1, film.getId_film());
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

	public int getIdFilmFromTitle(String title) 
	{
		Connection connection = this.dataSource.getConnection();
		int idFilm = 0;
		try
		{
			PreparedStatement statement;
			String query = "select id_film from film where film.titolo = '" + title + "'";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) 
				idFilm = result.getInt(1);
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
			} catch (SQLException e) 
			{
				throw new PersistenceException(e.getMessage());
			}
		}
		return idFilm;
	}

	
	public void incrementaVisualizzazioni(int id)
	{
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "UPDATE film SET visualizzazioni = visualizzazioni+1 WHERE id_film = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setInt(1, id);
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

	@Override
	public List<Film> findFavouriteFilms(List<ContenutoPreferito> contenutiPreferiti) 
	{
		List<Film> films = new LinkedList<>();
		Connection connection = this.dataSource.getConnection();
		try 
		{
			for (int i = 0; i < contenutiPreferiti.size(); i++)
			{
				PreparedStatement statement;
				String query = "select * from film where id_film = ?";
				statement = connection.prepareStatement(query);
				statement.setInt(1, contenutiPreferiti.get(i).getIdContenuto());
				ResultSet result = statement.executeQuery();
				
				if (result.next())
				{
					Film film = new Film();
					
					film.setId_film(result.getInt("id_film"));
					film.setTitolo(result.getString("titolo"));
					film.setAnno(result.getInt("anno"));
					film.setData_inserimento(result.getDate("data_inserimento"));
					film.setDurata(result.getInt("durata"));
					film.setGenere(result.getString("genere"));
					film.setFilmato(result.getString("filmato"));
					film.setImmagineForum(result.getString("immagine_forum"));
					film.setLocandina(result.getString("locandina"));
					film.setVisualizzazioni(result.getInt("visualizzazioni"));
					film.setSinossi(result.getString("sinossi"));
					
					films.add(film);
				}
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
		return films;
	}
}