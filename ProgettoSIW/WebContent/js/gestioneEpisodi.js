function aggiornaEpisodio(idEpisodio, durata, filmato, numeroEpisodio)
{
	document.getElementById("idA").value = idEpisodio;
	document.getElementById("titoloA").value = document.getElementById("titolo" + idEpisodio).value;
	document.getElementById("durataA").value = durata;
	document.getElementById("filmatoA").value = filmato;
	document.getElementById("numeroEpisodioA").value = numeroEpisodio;
	document.getElementById("sinossiA").value = document.getElementById("sinossi" + idEpisodio).value;
	
	$("#aggiornaEpisodio").modal("show");
}