<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta name="description" content="">
		<meta name="author" content="">
		
		<title>Golden Streaming - Cerca una Serie TV</title>
		
		<!-- Material Design Bootstrap
        <link href="MDB/css/mdb.min.css" rel="stylesheet"> -->
		
		<!-- Bootstrap core CSS -->
		<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
		
		<!-- Custom styles for this template -->
		<link href="css/serieTV.css" rel="stylesheet">
		
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	
		<!-- Favicon -->
		<link rel="shortcut icon" type="image/png" href="images/favicon.png"/>
	
		
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
	    <script src="js/searchFormSerieTV.js"></script>
	    
			    
	    
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
	    
	    <!-- Page Content -->
	    <div class="container">			
	    
		    <div class="row searchSerieTVPosition">
				
				<!-- Search form -->
			    <div class="row jumbotron col-lg-12 searchSerieTV justify-content-center">
				  
			        <div class="row col-lg-9 cercaSerieTV justify-content-center">Cerca una Serie TV</div>
			    	
			    	<div class="row col-lg-3 justify-content-center">
	    				<a class="jumbotron linkPageBoxSerieTV" href="ottieniSerieTV">Lista serie TV</a>
					</div>
					
					
					<div class="row jumbotron col-lg-11 justify-content-center searchBarSerieTV">
			    	
				        <div class="col-sm-3">
							<select class="form-control" id="idGender" name="gender" onchange="serieTVSearchGenderYear()">
								<option value="---">Serie TV per Genere</option>
								<option value="Azione">azione</option>
								<option value="Animazione">animazione</option>
								<option value="Avventura">avventura</option>
								<option value="Biografico">biografico</option>
								<option value="Commedia">commedia</option>
								<option value="Documentario">documentario</option>
								<option value="Drammatico">drammatico</option>
								<option value="Erotico">erotico</option>
								<option value="Fantascienza">fantascienza</option>
								<option value="Fantasy">fantasy</option>
								<option value="Giallo">giallo</option>
								<option value="Guerra">guerra</option>
								<option value="Horror">horror</option>
								<option value="Musical">musical</option>
								<option value="Poliziesco">poliziesco</option>
								<option value="Romatico">romantico</option>
								<option value="Sportivo">sportivo</option>
								<option value="Thriller">thriller</option>
								<option value="Western">western</option>
							</select>
						</div>
						
						<div class="col-sm-2">
							<select id="idYear" name="year" class="form-control" onchange="serieTVSearchGenderYear()">
								<option value="0">serie TV per anno</option>
								<script type="text/javascript">
									for (var i = 2019; i >= 1960; i--) {
										var opt = $("<option>").val(i).text(i);
										$("#idYear").append(opt);
								    }
								</script>
							</select>
						</div>
						
	
						
						<div class="col-sm-3 txtSearch">
							<div>
	  							<input class="form-control" type="text" name="title" placeholder="Titolo..." id="idTitle">
							</div>
						</div>
						<div>
							<div>
	  							<button class="btnSearch btn btn-secondary btn-sm" type="button" id="btnCercaPerTitolo" onclick="serieTVSearchTitle()">
	  								<i class="fa fa-search fa"></i>
	  							</button>
							</div>					
						</div>
						
						
					
					</div>
					
				</div>
				
				
				
		    </div>
		    
		    
		    		    
		    <!-- Result-->
		    <div id="result" class="row jumbotron">
		    
		    	<h1 id="risultatoRicercaText">I risultati della ricerca appaiono qui...</h1>
		         
	        </div>
	    
	        
	        
	        <!-- <div class="container">
			   <div id="idPages" class="row col-lg-12 text-center justify-content-center">
			      <ul class="pagination pagination-sm">
									
			      </ul>
			   </div>
			</div> -->
			
			
			
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
			    
		
	</body>
</html>