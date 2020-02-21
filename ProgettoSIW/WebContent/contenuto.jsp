<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		
		<c:set var="film" value="${film}"></c:set>
		
		<title>${film.titolo}</title>
		
		<!-- Bootstrap core CSS -->
		<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
	
		<!-- Custom styles for this template -->
		<link href="css/content.css" rel="stylesheet">
		
		<!-- Favicon -->
		<link rel="shortcut icon" type="image/png" href="images/favicon.png"/>
	
		<!-- My javascript
	    <script src="js/contenuto.js"></script> -->
	
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
		            		<a class="nav-link" href="ottieniForum">Forum</a>
		          		</li>
		         		<li class="nav-item">
		            		<a class="nav-link" href="contatti.jsp">Contatti</a>
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
							            <a href="${pageContext.request.contextPath}/user?username=${sessionScope.name}" class="dropdown-item">Profilo</a>
							            <c:choose>
						    				<c:when test="${sessionScope.abbonamento==false}">
						    					 <a href="abbonamento" class="dropdown-item">Abbonati</a>
						    				</c:when>
						    			</c:choose>
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
	    	<img src="${film.immagineForum}"/>
	    </div>
	    
	    <div id="videoTitle">${film.titolo}</div>
    	<div class="video video-container" style="text-align: center;">
    		<iframe width="1100" height="720" src="${film.filmato}"></iframe>
    	</div>
		
		<div class="container" style="padding-bottom: 40px;">
			<div class="card h-100">
				<div class="card-title" id="informazioni">Informazioni:</div>
				<div class="card-footer">
					<div class="row">
						<div class="col-lg-6">
							<span class="infoTitle">Titolo: </span>
							<span class="info">${film.titolo}</span>
						</div>
						<div class="col-lg-2"></div>
						<div class="col-lg-4">
							<span class="infoTitle">Genere: </span>
							<span class="info">${film.genere}</span>		
						</div>				
					</div>
					<div class="row">
						<div class="col-lg-6">
							<span class="infoTitle">Anno: </span>
							<span class="info">${film.anno}</span>
						</div>
						<div class="col-lg-2"></div>
						<div class="col-lg-4">
							<span class="infoTitle">Durata: </span>
							<span class="info">${film.durata}</span>		
						</div>				
					</div>
					<div class="row">
						<div class="col-lg-6">
							<span class="infoTitle">Regista: </span>
							<span class="info">${film.regista}</span>
						</div>
						<div class="col-lg-2"></div>
						<div class="col-lg-4">
							<span class="infoTitle">Visualizzazioni: </span>
							<span class="info">${film.visualizzazioni}</span>		
						</div>				
					</div>
				</div>
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
	</body>
</html>