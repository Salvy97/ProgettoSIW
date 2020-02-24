package persistence.dao;

import model.Rating;

public interface RatingDAO
{
	public void saveRatingFilm(Rating rating);
	public void saveRatingEpisodio(Rating rating);
	public float calculateRatingFilm(int idFilm);
	public float calculateRatingEpisodio(int idEpisodio);
	public Rating findRatedFilmByUsername(String username, int idFilm);
	public Rating findRatedEpisodeByUsername(String username, int idEpisodio);
}