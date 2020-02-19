$(document).ready(function()
{
	$("#ricerca").unbind();
	$("#ricerca").keyup(function()
	{
		$("#result").empty();
		$("result").html("");
		var searchField = $("#ricerca").val();
		$.getJSON("cercaContenuto?titolo=" + searchField, function(data)
		{
			$.each(data, function(key, value)
			{
				$("#result").append('<option value="'+ value.titolo + '"></option>');
			})
		})
	});
});

function scegliContenuto()
{
	var searchField = $("#ricerca").val();
	if (searchField == "")
		alert("Inserisci un titolo.");
	else
	{
		$.getJSON("cercaContenuto?titolo=" + searchField, function(data)
		{
			document.getElementById("contenutoScelto").value = searchField;
			document.getElementById("ricercaContenuto").submit();
		})
	}
}