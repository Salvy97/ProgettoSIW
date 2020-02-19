$('#description.carousel').carousel({
  interval: 2000
})


$(document).ready(function(){
	$("#myModal").modal('show');
});


/*$("#btnSrc").click(function() {
	
});*/

	
/*function jsonFlickrFeed(json) {
	  $.each(json.items, function(i, item) {
	    $("<img />").attr("src", item.media.m).appendTo("#flickr");
	  });
	};

	$.ajax({
	  url: 'https://api.flickr.com/services/feeds/photos_public.gne',
	  dataType: 'jsonp',
	  data: { "tags": "", "format": "json" }
});*/


function checkIfLogged()
{
	var name = document.getElementById("name").value;
	
	if (name == "null")
		alert("Devi essere autenticato per discutere un contenuto.");
	else
		location.href = "cercaContenuto.jsp";
}