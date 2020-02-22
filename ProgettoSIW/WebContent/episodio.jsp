<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		
		<c:set var="serieTV" value="${serieTV}"></c:set>
		<c:set var="stagione" value="${stagione}"></c:set>
		<c:set var="episodio" value="${episodio}"></c:set>
		
		<title>${serieTV.titolo} - ${episodio.titolo}</title>
		
		<!-- Bootstrap core CSS -->
		<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
	
		<!-- Custom styles for this template -->
		<link href="css/episode.css" rel="stylesheet">
		
		<!-- Favicon -->
		<link rel="shortcut icon" type="image/png" href="images/favicon.png"/>
	
		<!-- My javascript
	    <script src="js/contenuto.js"></script> -->
	    
	    <!-- rating -->
  		<link rel="stylesheet" href="css/jquery.rateyo.css"/>
	
	</head>
			
	<body>
		<!-- Navigation -->
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	   		<div class="container">
	      		<a class="navbar-brand" href="ottieniIndex" id="logo">
	      			<img src="images/logo.gif"/>
	      		</a>
	      		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
	        		<span class="navbar-toggler-icon"></span>
	      		</button>
	      		<div class="collapse navbar-collapse" id="navbarResponsive">
		        	<ul class="navbar-nav">
		          		<li class="nav-item">
		          			<a class="nav-link" href="ottieniIndex">Home
		              			 <span class="sr-only">(current)</span>
		            		</a>
		          		</li>
		          		<li class="nav-item">
		            		<a class="nav-link" href="ottieniFilm">Film</a>
		          		</li>
		          		<li class="nav-item">
		            		<a class="nav-link" href="ottieniSerieTV">Serie TV</a>
		          		</li>
		          		<li class="nav-item">
		            		<a class="nav-link" href="#">Forum</a>
		          		</li>
		         		<li class="nav-item">
		            		<a class="nav-link" href="#">Contatti</a>
		          		</li>
		        	</ul>
	      		</div>
	      		<div class="collapse navbar-collapse" id="navbarResponsive">
	      			<ul class="navbar-nav lg-auto ml-auto sg-auto">
	          			
	          			<c:choose>
						    <c:when test="${sessionScope.name!=null}">
							    <li class="nav-item">
						        	<span class="btn btn-outline-primary">${sessionScope.name}</span>
						        </li>
							    <div class="dropdown">
							        <button class="btn btn-outline-primary dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
									    &#128100;
									</button>
							        <div class="dropdown-menu">
							        	<h6 class="dropdown-header">${sessionScope.name}</h6>
							        	<div class="dropdown-divider"></div>
							            <a href="#" class="dropdown-item">Profilo</a>
							            <a href="LogoutServlet" class="dropdown-item">Logout</a>
							        </div>
							    </div>
						    </c:when>    
						    <c:otherwise>
						    	<li class="nav-item">
						        	<a class="nav-link" href="ottieniLogin"><span class="btn btn-outline-success">Login</span></a>
						        </li>
						        <li class="nav-item">
			            			<a class="nav-link" href="ottieniRegistration"><span class="btn btn-outline-danger">Sign up</span></a>
			          			</li>
						    </c:otherwise>
						</c:choose>
	          			
	        		</ul>
	    		</div>
	    	</div>
	    </nav>
	    	    
	    
	        
	    <div class="contentBackground">
	    	<img src="images/${serieTV.locandina}"/>
	    </div>
	    
	    <div id="videoTitle">${episodio.titolo}</div>
	    
	    
	    <div class="row col-lg-12 justify-content-center">
		    
		    <div class="col-lg-1"></div>
		    <div class="col-lg-2 leftBar jumbotron">
		    	Stagione: 
		   	 	<span class="info type">
		    		${stagione.numero_stagione}
		    	</span>
		    	<br>
		    	Episodio: 
		   	 	<span class="info genre">
		   	 		${episodio.numero_episodio}
		    	</span>
		    	<br><br>		    	
		   	 	Anno:  
		   	 	<p class="info genre">${serieTV.anno}</p>
		   	 	Durata:  
		   	 	<p class="info genre">${episodio.durata}'</p>
		    </div>
		    
		    
		    <div class="video col-lg-6">
		    	<iframe width="715" height="460" src="${episodio.filmato}" frameborder="1" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
		    </div>
			
		    
		    <div class="col-lg-2 rightBar jumbotron">
		    	Tipo: 
		   	 	<p class="info type">
		    		Serie TV
		    	</p>
		    	Genere: 
		   	 	<p class="info genre">${serieTV.genere}</p>
		    	Visualizzazioni:  
		   	 	<p class="info views">${episodio.visualizzazioni}</p>
		   	 			    	
		   	 	Valutazione:	    	
		    	<div id="rateYo" ></div>
		    </div>
		    <div class="col-lg-1"></div>
		</div>
		
		
		<div id="sinossi" class="row col-lg-11 jumbotron">
	   		<h3 class="text-danger">Sinossi</h3>
	   		<h5 class="lead">${episodio.sinossi}</h5>
	   </div>
	   
		
		<div id="valutation" class="row col-lg-11 justify-content-center jumbotron">
	   		<h3>Quanto ti è piaciuta la serie?</h3>
	   		<br>	    	
	   		<div id="rateYo2"></div>
	   </div>
	
		<!-- Footer -->
	    <footer class="py-4 bg-dark">
	        <div class="container">
	            <p class="m-0 text-right text-white">Copyright &copy; Golden Streaming 2019-2020</p>
	        </div>
	        <!-- /.container -->
	    </footer>
	
		<!-- Bootstrap core JavaScript -->
	 	<script src="jquery/jquery.min.js"></script>
	    <script src="bootstrap/js/bootstrap.bundle.min.js"></script>
	
		<!--  rating -->
		<script src="js/jquery.rateyo.js"></script>
		
		<script src="js/episodio.js"></script>
	</body>
</html>