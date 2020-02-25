package persistence;

import persistence.dao.AbbonamentoDAO;
import persistence.dao.*;

class PostgresDAOFactory extends DAOFactory {

	// Paola
	//	private final static String url = "jdbc:postgresql://localhost/golden";
	//	private final static String user = "golden";
	//	private final static String password = "golden";
	
	// Salvatore
//		private final static String url = "jdbc:postgresql://localhost/golden_streaming";
//		private final static String user = "postgres";
//		private final static String password = "postgres";
	
	// Online
	private final static String url = "jdbc:postgresql://goldenstreaming.postgres.database.azure.com/golden";
	private final static String user = "golden@goldenstreaming";
	private final static String password = "ProgettoIngSw.2020";

	private static  DataSource dataSource;
	

	// --------------------------------------------

	static {
		try {
			Class.forName("org.postgresql.Driver").newInstance();
			//questi vanno messi in file di configurazione!!!	
//			dataSource=new DataSource("jdbc:postgresql://52.39.164.176:5432/xx","xx","p@xx");
			dataSource=new DataSource(url,user,password);
		} 
		catch (Exception e) {
			System.err.println("PostgresDAOFactory.class: failed to load MySQL JDBC driver\n"+e);
			e.printStackTrace();
		}
	}

	
	// --------------------------------------------
	
	@Override
	public FilmDao getFilmDAO() {
		return new FilmDaoJDBC(dataSource);
	}
	
	@Override
	public SerieTVDao getSerieTVDAO() {
		return new SerieTVDaoJDBC(dataSource);
	}
	
	@Override
	public StagioneDao getStagioneDAO() {
		return new StagioneDaoJDBC(dataSource);
	}
	
	@Override
	public EpisodioDao getEpisodioDAO() {
		return new EpisodioDaoJDBC(dataSource);
	}
	
	@Override
	public PostDao getPostDAO() {
		return new PostDaoJDBC(dataSource);
	}
	
	@Override
	public CommentoDAO getCommentoDAO() {
		return new CommentoDAOJDBC(dataSource);
	}
	
	@Override
	public AbbonamentoDAO getAbbonamentoDAO() {
		return new AbbonamentoDaoJDBC(dataSource);
	}
	
	@Override
	public SottoscrizioneDAO getSottoscrizioneDAO() {
		return new SottoscrizioneDaoJDBC(dataSource);
	}
	
	@Override
	public UtenteDAO getUtenteDAO() {
		return new UtenteDaoJDBC(dataSource);
	}
	
	@Override
	public ProfiloDAO getProfiloDAO() {
		return new ProfiloDAOJDBC(dataSource);
	}
	
	@Override
	public ContenutiGuardatiDAO getContenutiGuardatiDAO() {
		return new ContenutiGuardatiDAOJDBC(dataSource);
	}
	
	@Override
	public ContenutiPreferitiDAO getContenutiPreferitiDAO() {
		return new ContenutiPreferitiDAOJDBC(dataSource);
	}
	
	@Override
	public RatingDAO getRatingDAO() {
		return new RatingDAOJDBC(dataSource);
	}
	
	@Override
	public NotificaDAO getNotificaDAO() {
		return new NotificaDAOJDBC(dataSource);
	}
}