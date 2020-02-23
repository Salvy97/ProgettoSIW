// Ajax per genere e anno
function serieTVSearchGenderYear()
{
	// Hide testoCercato
	$("#txtSearched").empty();
	
	var selGender = $("#idGender").val();
	var selYear = $("#idYear").val();
	
	$.getJSON("ottieniSerieTVPerGenereAnno", {gender: selGender, year: selYear}, function(responseJson){
	    
		showResults(responseJson);
		
	});
}


// Ajax per titolo
function serieTVSearchTitle()
{		    	
	var textTitle = capitalizeFirstLetter($('#idTitle').val().toLowerCase());
	
	$.getJSON("ottieniSerieTVPerTitolo", {title: textTitle}, function(responseJson){
		
		showResults(responseJson);
		
		highlightTextSearch($('#idTitle').val());
		
	});
}



function capitalizeFirstLetter(string) {
    return string.charAt(0).toUpperCase() + string.slice(1);
}



// Evento pressione tasto invio
$(document).ready(function() {
    $("#idTitle").keypress(function(e){
        if(e.keyCode == 13)
        {
            $('#btnCercaPerTitolo').click();
        }
    });
    
    
    // Hide pagination
	$("#idPages").hide();
    
    // Rendering dei risultati
    $('#result').css("display", "flex");
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
		html += '<a class="searchTitleHere" href="ottieniStagioni?id_serie='+id+'">'+titolo+'</a>';
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


//Barra e highlight testo ricerca
function highlightTextSearch(text) {
	
	// Barra testo cercato
	$("#txtSearched").empty();
	$("#txtSearched").append("<p>Risultati per \"<span class='highlight'>"+text+"</span>\" :</p>");
	
	// Highlight testo cercato	
	$('.searchTitleHere').each(function(){
		   var search_value = text.toUpperCase();
		   var search_regexp = new RegExp(search_value, "i");
		   $(this).html($(this).html().replace(search_regexp,"<span class='highlight'>"+search_value+"</span>"));
	});
}