$(document).ready(function()
{
	$("#ricercaContenuto").unbind();
	$("#ricercaContenuto").keyup(function()
	{
		$("#resultContenuti").empty();
		$("resultContenuti").html("");
		var searchFieldContenuto = $("#ricercaContenuto").val();
		$.getJSON("cercaContenuto?titolo=" + searchFieldContenuto, function(data)
		{
			$.each(data, function(key, value)
			{
				$("#resultContenuti").append('<option value="'+ value.titolo + '"></option>');
			})
		})
	});
});

function scegliContenuto()
{
	var searchFieldContenuto = $("#ricercaContenuto").val();
	if (searchFieldContenuto == "")
		alert("Inserisci un titolo.");
	else
	{
		$.getJSON("cercaContenuto?titolo=" + searchFieldContenuto, function(data)
		{
			document.getElementById("contenutoScelto").value = searchFieldContenuto;
			document.getElementById("ricercaContenutiForm").submit();
		})
	}
}

$(document).ready(function()
{
	$("#ricercaUtente").unbind();
	$("#ricercaUtente").keyup(function()
	{
		$("#resultUtenti").empty();
		$("resultUtenti").html("");
		var searchFieldUtente = $("#ricercaUtente").val();
		$.getJSON("cercaUtente?username=" + searchFieldUtente, function(data)
		{
			$.each(data, function(key, value)
			{
				$("#resultUtenti").append('<option value="'+ value.username + '"></option>');
			})
		})
	});
});

function scegliUtente()
{
	var searchFieldUtente = $("#ricercaUtente").val();
	if (searchFieldUtente == "")
		alert("Inserisci un username.");
	else
	{
		$.getJSON("cercaUtente?username=" + searchFieldUtente, function(data)
		{
			document.getElementById("utenteScelto").value = searchFieldUtente;
			document.getElementById("ricercaUtentiForm").submit();
		})
	}
}