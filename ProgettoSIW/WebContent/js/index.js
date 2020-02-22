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

$(document).ready(function()
{
	$("#ricercaContenuto").unbind();
	$("#ricercaContenuto").keyup(function()
	{
		$("#resultContenuti").empty();
		$("resultContenuti").html("");
		var searchFieldContenuto = $("#ricercaContenuto").val();
		$.getJSON("cercaContenuto?titolo=" + searchFieldContenuto, function(data)
		{
			$.each(data, function(key, value)
			{
				$("#resultContenuti").append('<option value="'+ value.titolo + '"></option>');
			})
		})
	});
});

function scegliContenuto()
{
	var searchFieldContenuto = $("#ricercaContenuto").val();
	if (searchFieldContenuto == "")
		alert("Inserisci un titolo.");
	else
	{
		$.getJSON("cercaContenuto?titolo=" + searchFieldContenuto, function(data)
		{
			document.getElementById("contenutoScelto").value = searchFieldContenuto;
			document.getElementById("ricercaContenutiForm").submit();
		})
	}
}