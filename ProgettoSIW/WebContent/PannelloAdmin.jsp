	<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<!DOCTYPE html>
	<html>
		<head>
			<meta charset="utf-8">
			<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
			<meta name="description" content="">
			<meta name="author" content="">
			
			<title>Pannello Admin</title>
			
	    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.2/animate.css" />
	    <link rel="stylesheet"
	      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.0-1/css/all.css" />
	    <link rel="stylesheet"
	      href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/css/bootstrap.min.css" />
	      
	

	        <link rel="stylesheet" href="css/pannelloAdmin.css" rel="no-referrer" />
		
			<!-- Favicon -->
			<link rel="shortcut icon" type="image/png" href="images/favicon.png"/>
			
		
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
			          			<a class="nav-link" href="ottieniIndex">Home</a>
			          		</li>
			          		<li class="nav-item active">
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
										    <i class="fa fa-envelope"></i>
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
	    
	    <!-- Page Content -->
	    <div class="container" id="main">
	    	<div class="card h-100">
			    <h1 class="card-title"> Pannello Admin </h1>
			    <div class="card-body">
					<a href="${pageContext.request.contextPath}/gestioneFilm"><button type="button" class="btn btn-success">Gestione Film</button></a>
				    <a href="${pageContext.request.contextPath}/gestioneSerieTV"><button type="button" class="btn btn-success">Gestione Serie TV</button></a>
	    		</div>
	    		<div class="card-footer">
	    			Gestisci i contenuti da qui
	    		</div>
	    	</div>
	    </div>

	    <footer class="py-4 bg-dark fixed-bottom">
	        <div class="container">
	            <p class="m-0 text-right text-white">Copyright &copy; Golden Streaming 2019-2020</p>
	        </div>
	        <!-- /.container -->
	    </footer>
	    

      <script src="https://cdnjs.cloudflare.com/ajax/libs/lodash.js/4.17.15/lodash.min.js"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.js"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.js"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.js"></script>
      <script src="https://www.paypal.com/sdk/js?client-id=AYWDsSzrI192Fz26mTpZUGsOZu-kCi4AVTakm5K8AebnzBBllJdPn82F6_QIhsamFhFvsBLxfBDnJt5R"> // Required. Replace SB_CLIENT_ID with your sandbox client ID.</script>
	  <script src="https://www.paypalobjects.com/api/checkout.js"></script>
      <script src="js/pannelloAdmin.js"></script>
      <script src="js/notifiche.js"></script>
	</body>
</html>