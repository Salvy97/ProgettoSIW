package persistence;

import model.Episodio;
import model.SerieTV;
import model.Stagione;
import persistence.dao.EpisodioDao;

public class TestConnectionDB {
	
	public static void main(String args[]) {
		
//		UtilDao util = factory.getUtilDAO();
//		util.dropDatabase();	
//		util.createDatabase();
		
		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
		EpisodioDao episodioDao = factory.getEpisodioDAO();
		//StagioneDao stagioneDao = factory.getStagioneDAO();
		//SerieTVDao serieTVDao = factory.getSerieTVDAO();
		
		//Film film1 = new Film("FLM03","Fast and Furious", 2006, 85);
		//filmDao.save(film1);
		
		SerieTV serieTV = new SerieTV("SRTV02", "La casa di carta", 2005, "azione", "");
		//serieTVDao.save(serieTV);
		
		Stagione stagione1 = new Stagione("STG03", 1, 7, serieTV);
		//stagioneDao.save(stagione1);
		
		Episodio episodio1 = new Episodio("EPSD04", "Titolo1", 49, stagione1);
		episodioDao.delete(episodio1);
		
		System.out.println("Elenco episodi: ");
		for(Episodio e : episodioDao.findAll()) {
			System.out.println(e.getId_episodio()+" "+e.getTitolo()+" "+e.getDurata()+" "+e.getStagione().getId_stagione());		}

	}
}