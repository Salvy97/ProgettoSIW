function centraMappa()
{
	var map = document.createElement("iframe");
	map.setAttribute("src", "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3084.7195279261705!2d16.22439596592964!3d39.362587643029855!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x133f999aaa86af19%3A0xe6050cd7c28559ba!2sUniversit%C3%A0%20della%20Calabria!5e0!3m2!1sit!2sit!4v1582475883333!5m2!1sit!2sit");
	map.setAttribute("width", "670");
	map.setAttribute("height", "600");
	map.setAttribute("style", "border: 0;");
	var divMap = document.getElementById("mappa");
	while (divMap.firstChild)
		divMap.removeChild(divMap.firstChild);
	divMap.appendChild(map);
}