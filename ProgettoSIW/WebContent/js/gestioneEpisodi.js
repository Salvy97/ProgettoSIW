function aggiornaEpisodio(idEpisodio, titolo, durata, filmato, numeroEpisodio, numeroStagione)
{
	document.getElementById("idA").value = idEpisodio;
	document.getElementById("titoloA").value = titolo;
	document.getElementById("durataA").value = durata;
	document.getElementById("filmatoA").value = filmato;
	document.getElementById("numeroEpisodioA").value = numeroEpisodio;
	document.getElementById("numeroStagioneA").value = numeroStagione;
	
	$("#aggiornaEpisodio").modal("show");
}