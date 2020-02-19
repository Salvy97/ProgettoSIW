package persistence;

import persistence.dao.FilmDao;
import persistence.dao.PostDao;
import persistence.dao.ProfiloDAO;
import persistence.dao.SerieTVDao;
import persistence.dao.SottoscrizioneDAO;
import persistence.dao.StagioneDao;
import persistence.dao.UtenteDAO;
import persistence.dao.AbbonamentoDAO;
import persistence.dao.CommentoDAO;
import persistence.dao.EpisodioDao;

public abstract class DAOFactory {

  // --- List of supported DAO types ---

  /**
   * Numeric constant '1' corresponds to explicit MySQL choice
   */
  public static final int MYSQL = 1;

  /**
   * Numeric constant '2' corresponds to explicit Postgres choice
   */
  public static final int POSTGRESQL = 2;

  // --- Actual factory method ---

  /**
   * Depending on the input parameter
   * this method returns one out of several possible
   * implementations of this factory spec
   */
  public static DAOFactory getDAOFactory(int whichFactory) {
    switch (whichFactory) {

    case MYSQL:
      return null; // new HsqldbDAOFactory();
    case POSTGRESQL:
      return new PostgresDAOFactory();
    default:
      return null;
    }
  }

  // --- Factory specification: concrete factories implementing this spec must
  // provide this methods! ---

  /**
   * Method to obtain a DATA ACCESS OBJECT
   */
  public abstract FilmDao getFilmDAO();
  public abstract SerieTVDao getSerieTVDAO();
  public abstract StagioneDao getStagioneDAO();
  public abstract EpisodioDao getEpisodioDAO();
  public abstract PostDao getPostDAO();
  public abstract CommentoDAO getCommentoDAO();
  public abstract AbbonamentoDAO getAbbonamentoDAO();
  public abstract SottoscrizioneDAO getSottoscrizioneDAO();
  public abstract UtenteDAO getUtenteDAO();
  public abstract ProfiloDAO getProfiloDAO();
}
