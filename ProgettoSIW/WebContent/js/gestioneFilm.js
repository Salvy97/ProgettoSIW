//let loadContentList = () => {
//  let tableContent = document.querySelector("#table-content");
//  let settings = {
//    async: true,
//    crossDomain: true,
//    url: "api/contenuti",
//    method: "GET",
//    headers: {
//      "Content-Type": "application/json",
//      Accept: "*/*"
//    },
//    data: {}
//  };
//
//  $.ajax(settings).done(result => {
//    let contenuti = JSON.parse(JSON.stringify(result));
//    console.log(contenuti);
//
//    let html = "";
//
//    for (let c in contenuti) {
//      let singleElement = `<tr class="userRow">
//	    	  					<th scope="row">${c}</th>
//	    	  					<td>${contenuti[c].id_film}</td>
//	    	  					<td>${contenuti[c].titolo}</td>
//	    	  					<td>${contenuti[c].anno}</td>
//	    	  					<td>${contenuti[c].durata}</td>
//			                    <td>${contenuti[c].genere}</td>
//                          <td>${contenuti[c].locandina}</td>
//                          <td>${contenuti[c].linkYT}</td>
//			                    <td>
//    	  							<div class="">
//			                    		<i class="fas fa-edit editContentBtn actionBtn" data-id="${contenuti[c].id_film}"></i>
//			                    	</div>
//			                    </td>
//			                    			                    <td class="">
//    	  							<div>
//			                    		<i class="far fa-trash-alt deleteContentBtn actionBtn" data-id="${contenuti[c].id_film}"></i>
//			                    	</div>
//			                    </td>
//			                 </tr>`;
//      html += singleElement;
//    }
//    tableContent.innerHTML = html;
//
//    let editContentBtn = document.querySelectorAll(".editContentBtn");
//
//    editContentBtn.forEach(el => {
//      el.addEventListener("click", handleEditContentBtn);
//    });
//
//    let deleteContentBtn = document.querySelectorAll(".deleteContentBtn");
//    deleteContentBtn.forEach(el => {
//      el.addEventListener("click", handleDeleteButtonBtn);
//    });
//  });
//};
//let onEdit = -1;
//let handleEditContentBtn = e => {
//  let contentID = e.toElement.dataset.id;
//  onEdit = contentID;
//  console.log("Edit ", contentID);
//
//  let settings = {
//    async: true,
//    crossDomain: true,
//    url: "api/info",
//    method: "POST",
//    headers: {
//      "Content-Type": "application/x-www-form-urlencoded",
//      Accept: "*/*"
//    },
//    data: {}
//  };
//
//  settings.data = {
//    id: contentID
//  };
//
//  $.ajax(settings).done(data => {
//    console.log(data);
//    let res = JSON.parse(JSON.stringify(data));
//    document.querySelector("#titolo_e").value = res.titolo;
//    document.querySelector("#durata_e").value = res.durata;
//    document.querySelector("#anno_e").value = res.anno;
//    document.querySelector("#genere_e").value = res.genere;
//    document.querySelector("#locandina_e").value = res.locandina;
//    document.querySelector("#linkyt_e").value = res.linkYT;
//    $("#editModal").modal("show");
//    document
//      .querySelector(".editContenuto")
//      .addEventListener("click", saveEditedContent);
//  });
//};
//
//let handleDeleteButtonBtn = e => {
//  let contentID = e.toElement.dataset.id;
//  let domanda = confirm(
//    "Confermi l'eliminazione del contenuto con ID " + contentID + "?"
//  );
//  if (domanda === true) {
//    deleteContent(contentID);
//  } else {
//    alert("Operazione annullata");
//  }
//};
//
//let saveEditedContent = id => {
//  let settings = {
//    async: true,
//    crossDomain: true,
//    url: "gestionecontenuti",
//    method: "POST",
//    headers: {
//      "Content-Type": "application/x-www-form-urlencoded",
//      Accept: "*/*"
//    },
//    data: {}
//  };
//
//  settings.data = {
//    operation: "edit",
//    id: onEdit,
//    titolo: document.querySelector("#titolo_e").value,
//    durata: document.querySelector("#durata_e").value,
//    anno: document.querySelector("#anno_e").value,
//    genere: document.querySelector("#genere_e").value,
//    locandina: document.querySelector("#locandina_e").value,
//    linkyt: document.querySelector("#linkyt_e").value
//  };
//  console.log(settings.data);
//  $("#editModal").modal("hide");
//  document.querySelector("#titolo").value = "";
//  document.querySelector("#durata").value = "";
//  document.querySelector("#anno").value = "";
//  document.querySelector("#genere").value = "";
//  document.querySelector("#linkyt").value = "";
//  document.querySelector("#locandina").value = "";
//  onEdit = null;
//
//  $.ajax(settings).done(() => {
//    alert("Modifiche salvate!");
//    loadContentList();
//  });
//};
//
//let saveNewContent = id => {
//  let settings = {
//    async: true,
//    crossDomain: true,
//    url: "gestionecontenuti",
//    method: "POST",
//    headers: {
//      "Content-Type": "application/x-www-form-urlencoded",
//      Accept: "*/*"
//    },
//    data: {}
//  };
//
//  settings.data = {
//    operation: "save",
//    titolo: document.querySelector("#titolo").value,
//    durata: document.querySelector("#durata").value,
//    anno: document.querySelector("#anno").value,
//    genere: document.querySelector("#genere").value,
//    linkyt: document.querySelector("#linkyt").value,
//    locandina: document.querySelector("#locandina").value
//  };
//
//  document.querySelector("#titolo").value = "";
//  document.querySelector("#durata").value = "";
//  document.querySelector("#anno").value = "";
//  document.querySelector("#linkyt").value = "";
//  document.querySelector("#genere").value = "";
//  document.querySelector("#locandina").value = "";
//
//  $("#exampleModalCenter").modal("hide");
//  $.ajax(settings).done(() => {
//    alert("Contenuto inserito!");
//    loadContentList();
//  });
//};
//
//let deleteContent = id => {
//  let settings = {
//    async: true,
//    crossDomain: true,
//    url: "gestionecontenuti",
//    method: "POST",
//    headers: {
//      "Content-Type": "application/x-www-form-urlencoded",
//      Accept: "*/*"
//    },
//    data: {}
//  };
//
//  settings.data = {
//    operation: "del",
//    id: id
//  };
//  console.log(settings);
//  $.ajax(settings).done(() => {
//    alert("Contenuto eliminato!");
//    loadContentList();
//  });
//};
//
//let saveNewContentBtn = document.querySelector(".salvaContenuto");
//saveNewContentBtn.addEventListener("click", saveNewContent);
//
//$(document).ready(() => {
//  loadContentList();
//});

function aggiornaFilm(idFilm, titolo, anno, durata, genere, regista, locandina, filmato, immagineForum)
{
	document.getElementById("idA").value = idFilm;
	document.getElementById("titoloA").value = titolo;
	document.getElementById("annoA").value = anno;
	document.getElementById("durataA").value = durata;
	document.getElementById("genereA").value = genere;
	document.getElementById("registaA").value = regista;
	document.getElementById("locandinaA").value = locandina;
	document.getElementById("filmatoA").value = filmato;
	document.getElementById("immagineForumA").value = immagineForum;
	
	$("#aggiornaFilm").modal("show");
}