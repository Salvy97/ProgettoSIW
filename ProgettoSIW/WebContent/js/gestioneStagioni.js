function aggiornaStagione(idStagione, numeroStagione, numeroEpisodi)
{
	document.getElementById("idA").value = idStagione;
	document.getElementById("numeroStagioneA").value = numeroStagione;
	document.getElementById("numeroEpisodiA").value = numeroEpisodi;
	
	$("#aggiornaStagione").modal("show");
}