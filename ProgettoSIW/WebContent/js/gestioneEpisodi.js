function aggiornaEpisodio(idEpisodio, titolo, durata, filmato, numeroEpisodio, sinossi)
{
	document.getElementById("idA").value = idEpisodio;
	document.getElementById("titoloA").value = titolo;
	document.getElementById("durataA").value = durata;
	document.getElementById("filmatoA").value = filmato;
	document.getElementById("numeroEpisodioA").value = numeroEpisodio;
	document.getElementById("sinossiA").value = sinossi;
	
	$("#aggiornaEpisodio").modal("show");
}