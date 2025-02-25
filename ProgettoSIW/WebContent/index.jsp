<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta name="description" content="">
		<meta name="author" content="">
		
		<title>Golden Streaming - Home</title>
	
		<!-- Bootstrap core CSS -->
		<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
	
		<!-- Custom styles for this template -->
		<link href="css/index.css" rel="stylesheet">
		
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
		          		<li class="nav-item active">
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
	    
	    
	    <!-- Message modal -->
	    <c:choose>
		<c:when test="${sessionScope.name==null}">
	    	<div id="myModal" class="modal fade" tabindex="-1">
		        <div class="modal-dialog">
		            <div class="modal-content">
		                <div class="modal-header">
		                    <h5 class="modal-title">Avviso - Termini di Utilizzo</h5>
		                    <button type="button" class="close" data-dismiss="modal">&times;</button>
		                </div>
		                <div class="modal-body">
		                    <p>Per usufruire dei contenuti presenti sulla piattaforma � necessario
		                    essere registrati e disporre di un abbonamento attivo!</p>
		                    <p class="text-secondary"><small>Accedi o registrati per iniziare subito...</small></p>
		                </div>
		                <div class="modal-footer">
		                    <button type="button" class="btn btn-primary" data-dismiss="modal">OK</button>
		                </div>
		            </div>
		        </div>
		    </div>    
	    </c:when>
	    <c:when test="${sessionScope.abbonamento==false}">
	    	<div id="myModal" class="modal fade" tabindex="-1">
		        <div class="modal-dialog">
		            <div class="modal-content">
		                <div class="modal-header">
		                    <h5 class="modal-title">Avviso - Termini di Utilizzo</h5>
		                    <button type="button" class="close" data-dismiss="modal">&times;</button>
		                </div>
		                <div class="modal-body">
		                    <p>Per usufruire dei contenuti presenti sulla piattaforma � necessario
		                    essere registrati e disporre di un abbonamento attivo!</p>
		                    <p class="text-secondary"><small>Accedi o registrati per iniziare subito...</small></p>
		                </div>
		                <div class="modal-footer">
		                    <button type="button" class="btn btn-primary" data-dismiss="modal">OK</button>
		                </div>
		            </div>
		        </div>
		    </div>    
	    </c:when>
	    </c:choose>
	    
	    
	
		<!-- Page Content -->
	    <div class="container">
		
	    
		    <div class="row leftBox">
		    	<div class="col-lg-3">
		    		
		    		<!-- Search form -->
		    		<div id="searchBox" class="jumbotron text-center">
				        <div class="p-1 bg-light rounded rounded-pill shadow-sm">
				        	<form id="ricercaContenutiForm" action="ottieniContenutoDaTitolo" method="GET">
				         		<div class="input-group">
						    		<input list="resultContenuti" id="ricercaContenuto" class="form-control border-0 bg-light" type="text" placeholder="Cerca..." aria-label="Search" aria-describedby="button-addon1"/>
									<datalist id="resultContenuti"></datalist>
									<input type="hidden" name="contenuto" id="contenutoScelto"/>
									<div class="input-group-append">
										<button id="cerca" class="btn btn-link" onclick="scegliContenuto();"><i class="fa fa-search"></i></button>
									</div>
								</div>
							</form>
				        </div>
			 		</div>
					
		    		<div id="description" class="carousel slide jumbotron row" data-ride="carousel" style="margin: 0 auto;">
			    		<div class="col-lg-3" style="margin: 0 auto; padding: 0;">
			    			<img src="images/logoDescription.gif"/>	
			    		</div>
			    		<div class="carousel-inner col-lg-9">
						   	<div class="carousel-item active">
						    	<p>Film</p>
						   	</div>
						   	<div class="carousel-item">
						    	<p>Serie TV</p>
						   	</div>
						</div>
		    		</div>
		    		<div class="socialNetworks">
		    			<a href="#" class="col-lg-3 fa fa-facebook"></a>
		    			<a href="#" class="col-lg-3 fa fa-twitter"></a>
		    			<a href="#" class="col-lg-3 fa fa-google"></a>
		    			<a href="#" class="col-lg-3 fa fa-instagram"></a>
		    		</div>
				</div>
				
		        <div id="carouselExampleIndicators" class="mainCarousel carousel slide col-lg-9" data-ride="carousel">
		            <ol class="mainCarousel carousel-indicators">
		                <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
		                <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
		            	<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
		            	<li data-target="#carouselExampleIndicators" data-slide-to="3"></li>
		          	</ol>
		          	<div class="carousel-inner" role="listbox">
		                <div class="carousel-item active">
		                    <img class="noMargin d-block img-fluid imgCar" src="${filmPiuVisti[0].immagineForum}" alt="First slide">
		                </div>
		                <div class="carousel-item">
		                    <img class="noMargin d-block img-fluid imgCar" src="${serieTVPiuViste[0].immagineForum}" alt="Second slide">
		                </div>
		                <div class="carousel-item">
		                    <img class="noMargin d-block img-fluid imgCar" src="${filmPiuVisti[1].immagineForum}" alt="Third slide">
		                </div>
		                <div class="carousel-item">
		                    <img class="noMargin d-block img-fluid imgCar" src="${serieTVPiuViste[1].immagineForum}" alt="Fourth slide">
		                </div>
		            </div>
		            <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
		                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
		                <span class="sr-only">Previous</span>
		            </a>
		            <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
		                <span class="carousel-control-next-icon" aria-hidden="true"></span>
		                <span class="sr-only">Next</span>
		            </a>
				</div>				
				
				
		    </div>
		    
		    <!-- Film -->
		    <div class="mostPopularFilm jumbotron">Ultimi Film inseriti</div>
		      
		    <div class="row jumbotron">
		        
		        <c:forEach items="${ultimiFilmInseriti}" var="film">
		            
			        <div class="content col-lg-4 col-md-6 mb-4">
			            <div class="card h-100">
			            	<a href="ottieniContenuto?id=${film.id_film}" class="imageContent">
			            		<img id="imgCard" class="card-img-top" src="images/${film.locandina}" alt="">
			            	</a>
				            <div class="card-body"> 
				                <h4 id="cardTitle" class="card-title jumbotron">
				                	<a href="ottieniContenuto?id=${film.id_film}">${film.titolo}</a>
				                </h4>
				            </div> 
			                <div class="card-footer">
			                    <div class="row">
			                	    <div id="durationFilm" class="col-sm-4">${film.durata}'</div>
			              		    <div id="yearFilm" class="col-sm-4">${film.anno}</div>
			              		    <div id="genderFilm" class="col-sm-4">${film.genere}</div>		
			              	    </div>
			                </div>
			             </div>
			         </div>
			         
		         </c:forEach>
		         
	         </div>
	         
	         
	         
	         <div class="mostWatchedFilm jumbotron">Film pi� visti</div>
			 
			 <div class="row jumbotron">
		         <c:forEach items="${filmPiuVisti}" var="film">
		            
			        <div class="content col-lg-4 col-md-6 mb-4">
			            <div class="card h-100">
			            	<a href="ottieniContenuto?id=${film.id_film}" class="imageContent">
			            		<img id="imgCard" class="card-img-top" src="images/${film.locandina}" alt="">
			            	</a>
				            <div class="card-body"> 
				                <h4 id="cardTitle" class="card-title jumbotron">
				                	<a href="ottieniContenuto?id=${film.id_film}">${film.titolo}</a>
				                </h4>
				            </div> 
			                <div class="card-footer">
			                    <div class="row">
			                	    <div id="durationFilm" class="col-sm-4">${film.durata}'</div>
			              		    <div id="yearFilm" class="col-sm-4">${film.anno}</div>
			              		    <div id="genderFilm" class="col-sm-4">${film.genere}</div>		
			              	    </div>
			                </div>
			             </div>
			         </div>
			         
		         </c:forEach>
		         
		    </div>
		    
		    
		    
		    <!-- Serie TV -->
		    <div class="mostPopularEpisode jumbotron">Ultimi Episodi inseriti</div>
		      
		    <div class="row jumbotron">
		        
		        <c:forEach items="${ultimiEpisodiInseriti}" varStatus="loop">		            
		            
					        <div class="content col-lg-4 col-md-6 mb-4">
					            <div class="card h-100">
					            	<a href="ottieniEpisodio?id_ep=${ultimiEpisodiInseriti[loop.index].id_episodio}&id_stg=${stagioniPiuViste[loop.index].id_stagione}&id_serie=${serieTVPiuViste[loop.index].id_serieTV}" class="imageContent">
					            		<img id="imgCard" class="card-img-top" src="images/${ultimeSerieTVInserite[loop.index].locandina}" alt="">
					            	</a>
						            <div class="card-body"> 
						                <h4 id="cardTitle" class="card-title jumbotron">
						                	<a href="ottieniEpisodio?id_ep=${ultimiEpisodiInseriti[loop.index].id_episodio}&id_stg=${stagioniPiuViste[loop.index].id_stagione}&id_serie=${serieTVPiuViste[loop.index].id_serieTV}">${stagioniPiuViste[loop.index].numero_stagione}x${ultimiEpisodiInseriti[loop.index].numero_episodio} - ${ultimiEpisodiInseriti[loop.index].titolo}</a>
						                </h4>
						            </div> 
					                <div class="card-footer">
					                    <div class="row">
					                	    <div id="durationEpisode" class="col-sm-6">${ultimiEpisodiInseriti[loop.index].durata}'</div>
					              		    <div id="viewsEpisode" class="col-sm-6">${ultimiEpisodiInseriti[loop.index].visualizzazioni} visualizzazioni</div>
					              	    </div>
					                </div>
					             </div>
					         </div>
			         
		         </c:forEach>
		         
	         </div>
	         
	         
	         
	         <div class="mostWatchedEpisode jumbotron">Episodi pi� visti</div>
			 
			 <div class="row jumbotron">
			 
		         <c:forEach items="${episodiPiuVisti}" varStatus="loop">		            
		            
					        <div class="content col-lg-4 col-md-6 mb-4">
					            <div class="card h-100">
					            	<a href="ottieniEpisodio?id_ep=${episodiPiuVisti[loop.index].id_episodio}&id_stg=${stagioniPiuViste[loop.index].id_stagione}&id_serie=${serieTVPiuViste[loop.index].id_serieTV}" class="imageContent">
					            		<img id="imgCard" class="card-img-top" src="images/${serieTVPiuViste[loop.index].locandina}" alt="">
					            	</a>
						            <div class="card-body"> 
						                <h4 id="cardTitle" class="card-title jumbotron">
						                	<a href="ottieniEpisodio?id_ep=${episodiPiuVisti[loop.index].id_episodio}&id_stg=${stagioniPiuViste[loop.index].id_stagione}&id_serie=${serieTVPiuViste[loop.index].id_serieTV}">${stagioniPiuViste[loop.index].numero_stagione}x${episodiPiuVisti[loop.index].numero_episodio} - ${episodiPiuVisti[loop.index].titolo}</a>
						                </h4>
						            </div> 
					                <div class="card-footer">
					                    <div class="row">
					                	    <div id="durationEpisode" class="col-sm-6">${episodiPiuVisti[loop.index].durata}'</div>
					              		    <div id="viewsEpisode" class="col-sm-6">${episodiPiuVisti[loop.index].visualizzazioni} visualizzazioni</div>
					              	    </div>
					                </div>
					             </div>
					         </div>
			         
		         </c:forEach>
		         
		    </div>
		    
		    
		    <!-- /.row -->
	    </div>
		<!-- container -->
		
		
		
	
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
	    	    
	    <script src="js/index.js"></script>
	    <script src="js/notifiche.js"></script>
	</body>
</html>