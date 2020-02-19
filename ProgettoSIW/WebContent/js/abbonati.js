let abb = [];
let loadCatalog = () => {
  let catalogArea = document.querySelector("#catalog");
  let settings = {
    async: true,
    crossDomain: true,
    url: "http://localhost:8080/Progetto/api/abbonamenti",
    method: "GET",
    headers: {
      "Content-Type": "application/json",
      Accept: "*/*"
    },
    data: {}
  };

  $.ajax(settings).done(result => {
    let abbonamenti = JSON.parse(JSON.stringify(result));
    abb = abbonamenti;
    let html = "";

    for (let a in abbonamenti) {
      let singleElement = `<div class="card mb-4 box-shadow">
                              <div class="card-header">
                                <h4 class="my-0 font-weight-normal">${abbonamenti[a].name}</h4>
                              </div>
                              <div class="card-body">
                                <h1 class="card-title pricing-card-title">&euro; ${abbonamenti[a].price}<small class="text-muted">/ mo</small></h1>
                                <p>${abbonamenti[a].desc}</p>
                              </div>
                              <div class="card-footer">
                                <button type="button" class="btn btn-lg btn-block btn-outline-primary abbonati" data-id=${abbonamenti[a].id}>Abbonati</button>
                              </div>
                            </div>
                            `;
      html += singleElement;
    }
    catalogArea.innerHTML = html;

    let abbonatiBtn = document.querySelectorAll(".abbonati");
    abbonatiBtn.forEach(el => {
      el.addEventListener("click", handleClick);
    });
  });
};


let saveUserInformation = () => {
  let userPP = document.querySelector("#usernamepp");
  let autoRenew = document.querySelector("#autorenew");
  let savePrefBtn = document.querySelector("#savePrefBtn");
  userPP.addEventListener("change", function() {
    savePrefBtn.innerHTML = "Salva le preferenze";
  })

  autoRenew.addEventListener("change", function() {
    savePrefBtn.innerHTML = "Salva le preferenze";
  })
  console.log("SAVE ", userPP.value, autoRenew.checked)

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
	operation: 'savepref',
	userpp: userPP.value,
	autorenew: autorenew.checked
  }
  
  console.log(settings);
  
  $.ajax(settings).done(result => {
	  
	  savePrefBtn.innerHTML = "OK!"
 });
  
};

let handleClick = e => {
  $('#ppCollapse').collapse('toggle')
  let abbId = e.toElement.dataset.id;
  let totale = abb[abbId-1].price;
  let purchaseInfoArea = document.querySelector("#purchaseInfo");

  let savePrefBtn = document.querySelector("#savePrefBtn");
  savePrefBtn.addEventListener('click', saveUserInformation);

  purchaseInfoArea.innerHTML = "<h3>Abbonamento scelto: " + abb[abbId-1].name + "</h3>"
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

let postTransactionHandler = (id) => {
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
  loadCatalog();

});



// document.querySelector("#paypal-button").innerHTML = "";
// paypal.Button.render(settingPaypal, "#paypal-button");
