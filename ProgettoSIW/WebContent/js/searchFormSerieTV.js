// Ajax per genere e anno
function serieTVSearchGenderYear()
{    
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
		var id = element.id_film;
		
		
		var html = '<div class="content col-lg-4 col-md-6 mb-4">';
		html += '<div class="card h-100">';
		html += '<a href="ottieniContenuto?id='+id+'" class="imageContent">';
		html += '<img id="imgCardSerieTV" class="card-img-top" src="images/'+locandina+'" alt="">';
		html += '</a>';
		html += '<div class="card-body">';
		html += '<h4 id="cardTitleSerieTV" class="card-title jumbotron">';
		html += '<a href="ottieniContenuto?id='+id+'">'+titolo+'</a>';
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
		
		
		
		/*// match search
		var yourstring="hobbit";

		$('h4:contains('+yourstring+')', document.body).each(function(){
		      $(this).html($(this).html().replace(
		            new RegExp(yourstring, 'g'), '<span class=someclass>'+yourstring+'</span>'
		      ));
		});*/
	}
}