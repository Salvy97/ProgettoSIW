function creaPost()
{
	var descrizione = document.getElementById("descrizione").value;
	if (document.getElementById("titolo").value == "")
	{
		alert("Il titolo non deve essere vuoto. Inserisci un titolo.");
	}
	else if (descrizione.length > 256)
	{
		alert("La descrizione supera il limite massimo consentito di caratteri.");
	}
	else
	{
		alert("Post creato con successo!");
		document.getElementById("posta").submit();
	}
}

$(document).ready(function()
{
	var urlParams = new URLSearchParams(window.location.search);
	document.getElementById("contenuto").value = urlParams.get("titolo");
	$.getJSON("cercaContenuto?titolo=" + urlParams.get("titolo"), function(data)
	{
		$.each(data, function(key, value)
		{
			$("body").css('background-image', 'url("' + value.immagineForum +'")');
			$("#locandinaContenuto").append('<img src="'+ value.immagineForum + '" width="100%"/>');
		})
	})
});

function updateCharNumber()
{
	var descrizione = document.getElementById("descrizione").value;
	document.getElementById("currentCharNumber").innerHTML = descrizione.length;
	if (descrizione.length > 256)
		document.getElementById("currentCharNumber").style.color = "red";
	else
		document.getElementById("currentCharNumber").style.color = "green";
}