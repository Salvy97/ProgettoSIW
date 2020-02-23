function aggiornaSerieTV(idSerieTV, titolo, anno, genere, locandina, immagineForum)
{
	document.getElementById("idA").value = idSerieTV;
	document.getElementById("titoloA").value = titolo;
	document.getElementById("annoA").value = anno;
	document.getElementById("genereA").value = genere;
	document.getElementById("locandinaA").value = locandina;
	document.getElementById("immagineForumA").value = immagineForum;
	
	$("#aggiornaSerieTV").modal("show");
}