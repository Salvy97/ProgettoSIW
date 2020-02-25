$(document).ready(function()
{
	$.getJSON("ottieniNotifiche", function(data)
	{
		if (data.length == 0)
			$("#notifiche").append('<p>Non hai nuove notifiche</p>');
		$.each(data, function(key, value)
		{
			var idNotifica = value.idNotifica;
			$("#notifiche").append('<a style="display: inline-block;" href="ottieniPost?contenuto=' + value.post.contenuto + '" class="dropdown-item">' + value.commento.username + ' ha commentato il tuo post su ' + value.post.contenuto + '</a><img style="display: inline; float: right; position: absolute;" onclick="javascript:cancellaNotifica(' + idNotifica + ');" width="10%" src="images/redX.png"/>');
			empty = false;
		})
	})
});

function cancellaNotifica(idNotifica)
{
	$.post("eliminaNotifica", { idNotifica: idNotifica }).done(function(data) {});        
}