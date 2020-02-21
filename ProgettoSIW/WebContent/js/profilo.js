var frasi = 
[
	"Novellino alle prime armi",
	"Stimatore con esperienza",
	"Intenditore esperto",
	"Maestro indiscusso"
]

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