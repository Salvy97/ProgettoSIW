$(function () {
 
  $("#rateYo").rateYo({
	  rating: 4.5,
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
              
              $("#valutation").empty();
              $("#valutation").append('<h3>Grazie per la tua valutazione!</h3>');
              
          });
});