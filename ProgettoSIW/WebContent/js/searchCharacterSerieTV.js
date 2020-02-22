// Ajax per carattere
$("#idItem li").on("click", function(){
	var selCharacter = $(this).text();
		
	$.getJSON("ottieniSerieTVPerCarattere", {character: selCharacter},function(responseJson){
		
		showResults(responseJson);
		
	});
});


// Mostra i risultati paginati
function showResults(responseJson)
{	
	$("#result").empty();
	
	var contElement = 0;
	
	$.each(responseJson, function(i, element){
		var locandina = element.locandina;
		var titolo = element.titolo;
		var durata = element.durata;
		var anno = element.anno;
		var genere = element.genere;
		var id = element.id_serieTV;
		
		
		var html = '<div class="content col-lg-4 col-md-6 mb-4">';
		html += '<div class="card h-100">';
		html += '<a href="ottieniStagioni?id_serie='+id+'" class="imageContent">';
		html += '<img id="imgCardSerieTV" class="card-img-top" src="images/'+locandina+'" alt="">';
		html += '</a>';
		html += '<div class="card-body">';
		html += '<h4 id="cardTitleSerieTV" class="card-title jumbotron">';
		html += '<a href="ottieniStagioni?id_serie='+id+'">'+titolo+'</a>';
		html += '</h4>';
		html += '</div>';
		html += '<div class="card-footer">';
		html += '<div class="row">';
		html += '<div id="yearSerieTV" class="col-sm-6">'+anno+'</div>';
		html += '<div id="genderSerieTV" class="col-sm-6">'+genere+'</div>';		
		html += '</div>';
		html += '</div>';
		html += '</div>';
		html += '</div>';
		
		$("#result").append(html);
		
		contElement++;
		
	});
	
	if(contElement==0)
	{
		$("#result").append('<h1 id="risultatoRicercaText">Nessun risultato trovato!</h1>');
		$("#idPages").hide();
	}
	else
	{
		// Distruggo vecchia pagination
		$("#idPages").empty();
		$("#idPages").append('<ul id="ul" class="pagination">');
		
		// Nuova pagination
		showPages();
		$("#idPages").show();
	}
}


// Carattere selezionato
$(document).ready(function(){
	$(".list-group-item").click(function() {
	  $(".list-group-item").removeClass("active");
	  $(this).addClass("active");
	});
	
	// pagination di tutti
	showPages();
    // Rendering dei risultati
    $('#result').css("display", "flex");
});