$(function () {
	
  $("#rateYo").rateYo({
	  rating: parseFloat(document.getElementById("rating").value),
	  normalFill: "#808080",
	  spacing   : "7px",
	  readOnly: true,
	  multiColor: {
 
      "startColor": "#FF0000", //RED
      "endColor"  : "#00FF00"  //GREEN
	  }
  
  });
 
});



$(function () {
	 
	$("#rateYo2").rateYo({
		
		ratedFill: "#E74C3C"		
		
	  }).on("rateyo.set", function (e, data) {
	 
		      alert("Valutazione: " + data.rating);
		  
              var contenuto = $("#contenuto").val();
              $.post("valutaFilm", { contenuto: contenuto, rating: data.rating }).done(function(data) {});        
              
              $("#valutation").empty();
              $("#valutation").append('<h3>Grazie per la tua valutazione!</h3>');
              
          });
});

function initializeFilmato(filmato)
{	
	var idFilmato = filmato.substring(30);
	onYouTubeIframeAPIReady(idFilmato);
}

function onYouTubeIframeAPIReady(idFilmato) 
{
    player = new YT.Player('player', 
    {  
    	height: '560',
        width: '640',
        videoId: idFilmato.toString(),
	    events: 
	    {
	      'onStateChange': onPlayerStateChange
	   }
    });
}

var tag = document.createElement('script');
tag.src = "https://www.youtube.com/iframe_api"; 
var firstScriptTag = document.getElementsByTagName('script')[0];
firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);
var player;

function onPlayerStateChange(event)
{
	if (event.data == YT.PlayerState.PLAYING)
	{ 
		var contenuto = $('#contenuto').val();
		$.post("aggiungiFilmVisto", { contenuto: contenuto }).done(function(data) {}); 
    }
}

function addToFav()
{
	var contenuto = $('#contenuto').val();
	$.post("aggiungiFilmPreferito", { contenuto: contenuto }).done(function(data) {}); 
}