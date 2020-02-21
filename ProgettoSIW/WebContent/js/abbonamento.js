let infoArea = document.querySelector("#infoarea");
let abb;
let loadUserInfo = () => {
  let catalogArea = document.querySelector("#catalog");
  let settings = {
    async: true,
    crossDomain: true,
    url: "api/sottoscrizione/info",
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
      //infoArea.innerHTML += '<span class="info">Piano </span>' + userSub.abb.name+ '<br/><br/>';
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
		window.location.replace("abbonamento");		
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
     url: "sottoscrizione",
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
 	   $(window.location).attr("href", "ottieniIndex");
   });

 };

$(document).ready(() => {
  loadUserInfo();
});