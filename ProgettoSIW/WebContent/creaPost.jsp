<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Crea Post</title>
		<!-- Bootstrap core CSS -->
		<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
	
		<!-- Custom styles for this template -->
		<link href="css/creaPost.css" rel="stylesheet">
		
		<!-- Favicon -->
		<link rel="shortcut icon" type="image/png" href="images/favicon.png"/>
	</head>
		
	<body>
		 <!-- Navigation -->
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	   		<div class="container">
	      		<a class="navbar-brand" href="index.html" id="logo">
	      			<img src="images/logo.gif"/>
	      		</a>
	      		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
	        		<span class="navbar-toggler-icon"></span>
	      		</button>
	      		<div class="collapse navbar-collapse" id="navbarResponsive">
		        	<ul class="navbar-nav">
		          		<li class="nav-item active">
		          			<a class="nav-link" href="index.jsp">Home</a>
		          		</li>
		          		<li class="nav-item">
		            		<a class="nav-link" href="film.jsp">Film</a>
		          		</li>
		          		<li class="nav-item">
		            		<a class="nav-link" href="#">Serie TV</a>
		          		</li>
		          		<li class="nav-item">
		            		<a class="nav-link" href="cercaContenuto.jsp">Forum</a>
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
							            <a href="${pageContext.request.contextPath}/user" class="dropdown-item">Profilo</a>
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
	    
	    <div class="container"> 
		   	<div class="card row">
		    	<div class="card-body col-lg-12 row">
		    		<h2 class="col-lg-2">Crea Post</h2>
		    		<div class="col-lg-7"></div>
		    		<div class="col-lg-3">
		    			<div id="contentTitle"> <%= request.getParameter("titolo") %> </div>
		    			<div id="locandinaContenuto"></div>
		    		</div>
		    	</div>
		    </div>
		    
		    <div class="row" style="padding-bottom: 24%;">
			    <div class="card h-100 col-lg-12">
				    <div class="card-body">
					    <form id="posta" action="creaPost" method="POST">
				            <div id="titoloInfo">Titolo:</div>
				            <div>
				            	<input id="titolo" name="titolo" style="width: 90%;" placeholder="Titolo..."/>
				            </div>
				            <div id="descrizioneInfo">Descrizione:</div>
				            <div>
				            	<textarea id="descrizione" name="descrizione" rows="10" cols="130%" onkeyup="updateCharNumber();"></textarea>
				            </div>
				            <input type="hidden" id="contenuto" name="contenuto"/>
					    </form>
					    <div id="showCharNumber">
					    	<span id="currentCharNumber">0</span> / 256
					    </div>
			        </div>
			        
			        <div class="card-footer">
			        	<button class="btn btn-info col-lg-2" name="creaPost" style="margin: 0 10px;" onclick="creaPost();">Crea</button>
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
	    
	    <script src="js/creaPost.js"></script>
</html>