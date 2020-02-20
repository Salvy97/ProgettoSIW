let infoArea = document.querySelector("#infoarea");
let abb;
let loadUserInfo = () => {
  let catalogArea = document.querySelector("#catalog");
  let settings = {
    async: true,
    crossDomain: true,
    url: "http://localhost:8080/Progetto/api/sottoscrizione/info",
    method: "GET",
    headers: {
      "Content-Type": "application/json",
      Accept: "*/*"
    },
    data: {}
  };

  $.ajax(settings).done(result => {
    let userSub = JSON.parse(JSON.stringify(result));

    console.log(userSub)

    if (userSub === null ) {
    	infoArea.innerHTML += '  <button type="button" class="btn btn-success" id="abb">Abbonati</button>'
    } else {

      let dateNow = new moment();
      let dateDue = new moment(userSub.dueDate);
      let giorniRimasti = Math.floor(moment.duration(dateDue.diff(dateNow)).asDays());
      abb = userSub;
      if (giorniRimasti < 7) {
        infoArea.innerHTML = 'Abbonamento in scadenza! <br/><br/>' 
      }
    	
      infoArea.innerHTML += '<span class="info">Scadenza abbonamento </span>' + userSub.dueDate + '<br/>';
      infoArea.innerHTML += '<span class="info">Giorni rimasti </span>' + giorniRimasti+ '<br/>'
      infoArea.innerHTML += '<span class="info">Piano </span>' + userSub.abb.name+ '<br/><br/>';
      if (userSub.abb !== null){
        infoArea.innerHTML += ' <button type="button" class="btn btn-success" id="cambio">Cambia piano</button> '
      }
      
      infoArea.innerHTML += '  <button type="button" class="btn btn-success" id="rinnovo">Rinnova</button>'
      infoArea.innerHTML  += '<div id="paypal-button"></div>'
      
      
      let cambioBtn = document.querySelector("#cambio");
      cambioBtn.addEventListener('click', handleCambio);
      
      let rinnovaBtn = document.querySelector("#rinnovo");
      rinnovaBtn.addEventListener('click', handleRinnova);
    }
      
    
  });
};

let handleCambio = () => {
	if(confirm("ATTENZIONE! Se cambi tipologia di abbonamento prederai i giorni residui! Vuoi continuare? ")){
		window.location.replace("http://localhost:8080/Progetto/abbonamento");		
	}
};

let handleRinnova = () => {
	
	handleClick();
	
};

 let handleClick = () => {
	 console.log(abb)
   let abbId = abb.id;
   let totale = abb.abb.price;
   console.log(totale)
   let settingPaypal = {
     // Configure environment
     env: "sandbox",
     client: {
       sandbox: "demo_sandbox_client_id",
       production: "demo_production_client_id"
     },
     // Customize button (optional)
     locale: "it_IT",
     style: {
       layout: "vertical",
       color: "gold",
       shape: "rect",
       label: "paypal"
     },
     payment: function(data, actions) {
       return actions.payment.create({
         transactions: [
           {
             amount: {
               total: "" + totale,
               currency: "EUR"
             }
           }
         ]
       });
     },
     // Enable Pay Now checkout flow (optional)
     commit: true,
     // Execute the payment
     onAuthorize: function(data, actions) {
       return actions.payment.execute().then(function() {
         postTransactionHandler(abbId)
       });
     }
   };
   document.querySelector("#paypal-button").innerHTML = "";
   paypal.Button.render(settingPaypal, "#paypal-button");
 };

 let postTransactionHandler = () => {
   let id = abb.abb.id
 	console.log("okok", id);
   let settings = {
     async: true,
     crossDomain: true,
     url: "http://localhost:8080/Progetto/sottoscrizione",
     method: "POST",
     headers: {
       "Content-Type": "application/x-www-form-urlencoded",
       Accept: "*/*"
     },
     data: {}
   };

   settings.data = {
     id: id,
     operation: 'add'
   }
   console.log(settings.data)
   $.ajax(settings).done(result => {
 	   $(window.location).attr("href", "http://localhost:8080/Progetto/ok");
   });

 };

$(document).ready(() => {
  loadUserInfo();
});

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