// Ajax per genere e anno
function filmSearchGenderYear()
{    
	var selGender = $("#idGender").val();
	var selYear = $("#idYear").val();
	
	$.getJSON("ottieniFilmPerGenereAnno", {gender: selGender, year: selYear}, function(responseJson){
	    
		showResults(responseJson);
		
	});
}


// Ajax per titolo
function filmSearchTitle()
{		    	
	var textTitle = capitalizeFirstLetter($('#idTitle').val().toLowerCase());
	
	$.getJSON("ottieniFilmPerTitolo", {title: textTitle}, function(responseJson){
		
		showResults(responseJson);
		
		highlightTextSearch($('#idTitle').val(), 1);
		
	});
}


// Ajax per regista
function filmSearchMovieDirector()
{		    	
	var textMovieDirector = capitalizeFirstLetter($('#idMovieDirector').val().toLowerCase());
	
	$.getJSON("ottieniFilmPerRegista", {movieDirector: textMovieDirector}, function(responseJson){
		
		showResults(responseJson);
		
		highlightTextSearch($('#idMovieDirector').val(), 2);
		
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
    
    $("#idMovieDirector").keypress(function(e){
        if(e.keyCode == 13)
        {
            $('#btnCercaPerRegista').click();
        }
    });
    
    // Hide pagination
	$("#idPages").hide();
    
    // Rendering dei risultati
    $('#result').css("display", "flex");
    
    
    
    
    
    /* da aggiustare
    var textTitle = capitalizeFirstLetter($('#inputSrc').val().toLowerCase());
    $.getJSON("ottieniFilmPerTitolo", {title: textTitle}, function(responseJson){
		
		showResults(responseJson);
		
		highlightTextSearch($('#idTitle').val(), 1);
		
	}); */
});



// Mostra i risultati paginati
function showResults(responseJson)
{	
	$("#result").empty();
	
	var contElement = 0;
	
	$.each(responseJson, function(i, element){
		var regista = element.regista;
		var locandina = element.locandina;
		var titolo = element.titolo;
		var durata = element.durata;
		var anno = element.anno;
		var genere = element.genere;
		var id = element.id_film;
		
		var html = '<div class="content col-lg-4 col-md-6 mb-4">';
		html += '<div class="card h-100">';
		html += '<a href="ottieniContenuto?id='+id+'" class="imageContent">';
		html += '<img id="imgCardFilm" class="card-img-top" src="images/'+locandina+'" alt="">';
		html += '</a>';
		html += '<div class="card-body">';
		html += '<h4 id="cardTitleFilm" class="card-title jumbotron">';
		html += '<a class="searchTitleHere" href="ottieniContenuto?id='+id+'">'+titolo+'</a>';
		html += '</h4>';
		html += '</div>';
		html += '<div class="card-footer">';
		html += '<div class="row">';
		html += '<div class="col-sm-5"><h4 class="searchMovieDirectorHere">'+regista+'</h4></div>';
		html += '<div id="yearFilm" class="col-sm-3">'+anno+'</div>';
		html += '<div id="genderFilm" class="col-sm-4">'+genere+'</div>';		
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


// Barra e highlight testo ricerca
function highlightTextSearch(text, fieldSearch) {
	
	// Barra testo cercato
	$("#txtSearched").empty();
	$("#txtSearched").append("<p>Risultati per \"<span class='highlight'>"+text+"</span>\" :</p>");
	
	// Highlight testo cercato
	var searchIn;
	
	if(fieldSearch==1)
		searchIn = '.searchTitleHere';
	else
		searchIn = '.searchMovieDirectorHere';
	
	$(searchIn).each(function(){
		   var search_value = text.toUpperCase();
		   var search_regexp = new RegExp(search_value, "i");
		   $(this).html($(this).html().replace(search_regexp,"<span class='highlight'>"+search_value+"</span>"));
	});
}


/* Get Url parameter
$.urlParam = function(name){
    var results = new RegExp('[\?&]' + name + '=([^&#]*)').exec(window.location.href);
    if (results==null) {
       return null;
    }
    return decodeURI(results[1]) || 0;
} */