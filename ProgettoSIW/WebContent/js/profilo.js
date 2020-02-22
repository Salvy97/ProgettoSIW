var frasi = 
[
	"Novellino alle prime armi",
	"Stimatore con esperienza",
	"Intenditore esperto",
	"Maestro indiscusso"
]

var showing = false;

function calculateRating(contenutiGuardati, postsCreati, recensioniEffettuate)
{
	var rating = 1;
	
	if (contenutiGuardati > 10 && contenutiGuardati < 25)
	{
		rating += 2
	}
	else if (contenutiGuardati >= 25 && contenutiGuardati < 50)
	{
		rating += 4
	}
	else if (contenutiGuardati >= 50)
	{
		rating += 6
	}
	
	if (postsCreati > 5 && postsCreati < 15)
	{
		rating += 2
	}
	else if (postsCreati >= 15 && postsCreati < 25)
	{
		rating += 4
	}
	else if (postsCreati >= 25)
	{
		rating += 6
	}
	
	if (recensioniEffettuate > 15 && recensioniEffettuate < 30)
	{
		rating += 2
	}
	else if (recensioniEffettuate >= 30 && recensioniEffettuate < 45)
	{
		rating += 4
	}
	else if (recensioniEffettuate >= 45)
	{
		rating += 6
	}
	
	if (rating > 10)
		rating = 10;
	
	if (rating < 3)
		document.getElementById("fraseInfo").innerHTML = frasi[0];
	else if (rating >= 3 && rating < 6)
		document.getElementById("fraseInfo").innerHTML = frasi[1];
	else if (rating >= 6 && rating < 9)
		document.getElementById("fraseInfo").innerHTML = frasi[2];
	else
		document.getElementById("fraseInfo").innerHTML = frasi[3];
	
	document.getElementById("rating").innerHTML = rating + "/10";
}

function showCambiaImmagineForm()
{
	if (!showing)
	{
		var mainDiv = document.createElement("div");
		mainDiv.setAttribute("class", "row");
		document.getElementById("mainDivProfile").appendChild(mainDiv);
		
		var form = document.createElement("form");
		form.setAttribute("id", "cambiaImmagineForm");
		form.setAttribute("action", "cambiaImmagine");
		form.setAttribute("class", "col-lg-6");
		form.setAttribute("method", "POST");
		mainDiv.appendChild(form);
		
		var input = document.createElement("input");
		input.setAttribute("type", "text");
		input.setAttribute("placeholder", "Inserisci URL dell'immagine qui");
		input.setAttribute("name", "url");
		form.appendChild(input);
		
		var separatorDiv = document.createElement("div");
		separatorDiv.setAttribute("class", "col-lg-3");
		mainDiv.appendChild(separatorDiv);
		
		var button = document.createElement("button");
		button.setAttribute("id", "buttonImage");
		button.setAttribute("class", "btn btn-warning col-lg-3");
		button.setAttribute("onclick", "document.getElementById('cambiaImmagineForm').submit();");
		button.innerHTML = "Scegli";
		mainDiv.appendChild(button);
		
		showing = true;
	}
	else
	{
		const nodo = document.getElementById("mainDivProfile");
		while (nodo.firstChild)
			nodo.removeChild(nodo.firstChild);
		showing = false;
	}
}