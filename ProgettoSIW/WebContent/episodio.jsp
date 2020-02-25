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
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.2/animate.css"/>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.0-1/css/all.css" />
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/css/bootstrap.min.css"/>
	
		<!-- Custom styles for this template -->
		<link href="css/episode.css" rel="stylesheet">
		
		<!-- Favicon -->
		<link rel="shortcut icon" type="image/png" href="images/favicon.png"/>
	
		<!-- My javascript
	    <script src="js/contenuto.js"></script> -->
	    
	    <!-- rating -->
  		<link rel="stylesheet" href="css/jquery.rateyo.css"/>
	
	</head>
			
	<body onload="javascript:initializeFilmato('${episodio.filmato}');">
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
		            		<a class="nav-link" href="ottieniForum">Forum</a>
		          		</li>
		         		<li class="nav-item">
		            		<a class="nav-link" href="contatti.jsp">Contatti</a>
		          		</li>
		        	</ul>
	      		</div>
	      		<div class="collapse navbar-collapse" id="navbarResponsive">
	      			<div style="padding-right: 20px;">
		     			<c:choose>
						    <c:when test="${sessionScope.role=='admin'}">
						    	<button class="btn btn-warning" onclick="location.href = 'PannelloAdmin.jsp';">Pannello Admin</button>
						    </c:when>
						</c:choose>
					</div>
	      			<ul class="navbar-nav lg-auto ml-auto sg-auto">
		           		<c:choose>
						    <c:when test="${sessionScope.name!=null}">
						    	<li class="nav-item">
						    		<div class="dropdown">
							    		<button class="btn btn-outline-primary" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
										    <i id="notificationSymbol" class="fa fa-envelope"></i>
										</button>
										<div id="notifiche" class="dropdown-menu"></div>
									</div>
						    	</li>
							    <li class="nav-item">
							    	<div class="dropdown">
						        		<button class="btn btn-outline-primary dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">${sessionScope.name}  &#128100;</button>
						        		<div class="dropdown-menu">
								        	<h6 class="dropdown-header">${sessionScope.name}</h6>
								        	<div class="dropdown-divider"></div>
									        <a href="${pageContext.request.contextPath}/user?username=${sessionScope.name}" class="dropdown-item">Profilo</a>
									        <c:choose>
								    			<c:when test="${sessionScope.abbonamento==false}">
								    				<a href="abbonamento" class="dropdown-item">Abbonati</a>
								    			</c:when>
								    		</c:choose>
									        <a href="LogoutServlet" class="dropdown-item">Logout</a>
							        	</div>
							        </div>
						        </li>
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
	    	    
	    <input type="hidden" id="contenuto" value="<%= request.getParameter("id_ep") %>"/>
	    <input type="hidden" id="rating" value="${rating}"/>
	        
	    <div class="contentBackground">
	    	<img src="${serieTV.immagineForum}"/>
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
		    
		    <div id="player" class="video col-lg-6"></div>
		    
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
		
		
		<div id="sinossi" class="container jumbotron">
	   		<h3 class="text-danger">Sinossi</h3>
	   		<h5 class="lead">${episodio.sinossi}</h5>
	   </div>
	   
		<div class="container jumbotron" id="valutationDiv">
			<div id="valutation">
				<c:choose>
			    	<c:when test="${rated==false}">
				   		<h3>Quanto ti � piaciuto l'episodio?</h3>
				   		<br>	    	
				   		<div id="rateYo2"></div>
				   	</c:when>
				 	<c:otherwise>
				 		<h3>Hai gi� votato questo contenuto!</h3>
				 	</c:otherwise>
				</c:choose>
		    </div>
		    <div style="text-align: right;">
				<a href="ottieniPost?contenuto=${serieTV.titolo}"><button class="btn btn-success">Forum della serie</button></a>
			</div>
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
		<script src="js/notifiche.js"></script>
	</body>
</html>