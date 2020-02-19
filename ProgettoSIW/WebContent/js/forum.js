var post = null;

function showPost(id, username, data, ora, titolo, descrizione, profilePicture, commenti)
{	
	document.getElementById("username").innerHTML = username;
	document.getElementById("data").innerHTML = data;
	document.getElementById("ora").innerHTML = ora;
	document.getElementById("titolo").innerHTML = titolo;
	document.getElementById("descrizione").innerHTML = descrizione;
	document.getElementById("profilePicture").src = profilePicture;
	
	const nodo = document.getElementById("commenti");
	while (nodo.firstChild)
		nodo.removeChild(nodo.firstChild);
	
	var allComments = getComments(commenti);
	for (var i = 0; i < allComments.length; i++)
	{
		var profilePic = document.createElement("img");
		profilePic.setAttribute("class", "commentProfilePicture");
		profilePic.setAttribute("width", "50");
		profilePic.setAttribute("height", "50");
		var commento = document.createElement("span");
		commento.setAttribute("class", "commentDescription");
		var username = document.createElement("div");
		if (i == allComments.length - 1)
			username.setAttribute("class", "lastCommentUsername");
		else
			username.setAttribute("class", "commentUsername");
		document.getElementById("commenti").appendChild(profilePic);
		document.getElementById("commenti").appendChild(commento);
		document.getElementById("commenti").appendChild(username);
		username.innerHTML = allComments[i][0];
		profilePic.src = allComments[i][1];
		commento.innerHTML = allComments[i][2];
	}
	
	document.getElementById("numeroCommenti").innerHTML = allComments.length;
	
	post = id;
}

function getComments(commenti)
{
	var commentiSplitted = [];
	commenti = commenti.substring(1, commenti.length - 1);
	var prevI = 0;
	for (var i = 0; i < commenti.length; i++)
	{
		if (commenti[i][0] === '|')
		{
			commentiSplitted.push(commenti.substring(prevI, i));
			i++;
			prevI = i;
		}
	}
	for (var i = 0; i < commentiSplitted.length; i++)
		if (commentiSplitted[i][0] === ',')
			commentiSplitted[i] = commentiSplitted[i].substring(2, commentiSplitted[i].length);
	var allComments = [];
	var comment = [];
	for (var i = 0; i < commentiSplitted.length; i++)
	{
		comment.push(commentiSplitted[i]);
		if ((i + 1) % 3 === 0)
		{
			allComments.push(comment);
			comment = [];
		}
	}
	return allComments;
}

function commenta()
{
	var commento = document.getElementById("commento").value;
	if (document.getElementById("commento").value == "")
	{
		alert("Inserisci un commento.");
	}
	else if (commento.length > 128)
	{
		alert("Il commento è troppo lungo.");
	}
	else
	{
		alert("Commento inserito con successo!");
		document.getElementById("postCommento").value = post;
		document.getElementById("commenta").submit();
	}
}

function scriviPost()
{
	var urlParams = new URLSearchParams(window.location.search);
	location.href = "creaPost.jsp?titolo=" + urlParams.get("contenuto");
}

$(document).ready(function()
{
	var urlParams = new URLSearchParams(window.location.search);
	$("#titoloContenuto").append(urlParams.get("contenuto"));
	document.getElementById("contenutoCommento").value = urlParams.get("contenuto");
	$.getJSON("cercaContenuto?titolo=" + urlParams.get("contenuto"), function(data)
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
	var commento = document.getElementById("commento").value;
	document.getElementById("currentCharNumber").innerHTML = commento.length;
	if (descrizione.length > 128)
		document.getElementById("currentCharNumber").style.color = "red";
	else
		document.getElementById("currentCharNumber").style.color = "green";
}