<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta name="description" content="">
		<meta name="author" content="">
		
		<c:set var="serieTV" value="${serieTV}"></c:set>
		<c:set var="stagione" value="${stagione}"></c:set>
		
		<title>${serieTV.titolo} - Episodi</title>
		
		<!-- Material Design Bootstrap
        <link href="MDB/css/mdb.min.css" rel="stylesheet"> -->
		
		<!-- Bootstrap core CSS -->
		<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.2/animate.css"/>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.0-1/css/all.css" />
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/css/bootstrap.min.css"/>
		
		<!-- Custom styles for this template -->
		<link href="css/episodes.css" rel="stylesheet">
		
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	
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
		          		<li class="nav-item">
		            		<a class="nav-link" href="ottieniFilm">Film</a>
		          		</li>
		          		<li class="nav-item active">
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
	    
	    <!-- Page Content -->
	    <div class="container">			
	    
		    <div class="row searchSerieTVPosition">
				
				<!-- Lista serieTV form -->
			    <div class="row jumbotron col-lg-12 searchSerieTV justify-content-center">
				  
			        <div class="row col-lg-12 catalogoSerieTV justify-content-center">Episodi</div>
					
				</div>
				
				
		    </div>
		    
		    
		    
		    
		    <!-- Result-->
		    <div id="result" class="row jumbotron">


		    	<c:forEach items="${episodi}" var="episodio">
		            
			        <div class="content col-lg-4 col-md-6 mb-4">
			            <div class="card h-100">
			            	<a href="ottieniEpisodio?id_ep=${episodio.id_episodio}&id_stg=${stagione.id_stagione}&id_serie=${serieTV.id_serieTV}" class="imageContent">
			            		<img id="imgCardSerieTV" class="card-img-top" src="images/${serieTV.locandina}" alt="">
			            	</a>
				            <div class="card-body"> 
				                <h4 id="cardTitleSerieTV" class="card-title jumbotron">
				                	<a href="ottieniEpisodio?id_ep=${episodio.id_episodio}&id_stg=${stagione.id_stagione}&id_serie=${serieTV.id_serieTV}">${stagione.numero_stagione}x${episodio.numero_episodio} - ${episodio.titolo}</a>
				                </h4>
				            </div> 
			                <div class="card-footer">
			                    <div class="row">
			                	    <div id="durationEpisode" class="col-sm-6">${episodio.durata}'</div>
			              		    <div id="viewsEpisode" class="col-sm-6">${episodio.visualizzazioni} visualizzazioni</div>
			              	    </div>
			                </div>
			             </div>
			         </div>
			         
		         </c:forEach>		         
		         
		         
			</div>
		    
		    
		    <!-- Pagination -->
		    <div id="idPages" class="row justify-content-center">
				<ul id="ul" class="pagination">
				</ul>
	        </div>
	        
			 
	    </div>
		<!-- container -->
		
	    
	    
	    <!-- Footer -->
	    <footer class="py-4 bg-dark">
	        <div class="container">
	            <p class="m-0 text-right text-white">Copyright &copy; Golden Streaming 2019-2020</p>
	        </div>
	        <!-- /.container -->
	    </footer>
	    
	    
	    <!-- jQuery library -->
	 	<script src="jquery/jquery.min.js"></script>
	 	<!-- Bootstrap core JavaScript -->
	    <script src="bootstrap/js/bootstrap.min.js"></script>
	    <!-- MDB core JavaScript
        <script type="text/javascript" src="MDB/js/mdb.min.js"></script> -->
	    
	    <!-- Pagination file -->
	    <script src="js/jquery.twbsPagination.js"></script>
	    
	    <!-- My javascript -->
	    <script src="js/pagination.js"></script>
	    <script src="js/searchCharacterSerieTV.js"></script>
	    <script src="js/notifiche.js"></script>
	    
	    <!-- <script src="js/contenuto.js"></script> -->    
	    	    
	</body>
</html>