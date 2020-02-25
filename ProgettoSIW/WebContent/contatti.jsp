<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta name="description" content="">
		<meta name="author" content="">
	
		<title>Golden Streaming - Contatti</title>
	
		<!-- Bootstrap core CSS -->
		<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.2/animate.css"/>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.0-1/css/all.css" />
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/css/bootstrap.min.css"/>
	
		<!-- Custom styles for this template -->
		<link href="css/contact.css" rel="stylesheet">
		
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
		          		<li class="nav-item">
		            		<a class="nav-link" href="ottieniSerieTV">Serie TV</a>
		          		</li>
		          		<li class="nav-item">
		            		<a class="nav-link" href="ottieniForum">Forum</a>
		          		</li>
		         		<li class="nav-item active">
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
	    <section class="container">

		    <!--Contact heading-->
		    <h2 class="h1 m-0">Contattaci</h2>
		    <!--Contact description-->
		    <p class="pb-4">Hai un problema con il tuo account? Vuoi ricevere consulenza o informazioni su un problema che hai riscontrato?</p>
		
		    <div class="row">
		
		        <!--Grid column-->
		        <div class="col-lg-5 mb-4">
		
		            <!--Form with header-->
		            <div class="card border-primary rounded-0">
		
		                <div class="card-header p-0">
		                    <div class="bg-primary text-white text-center py-2">
		                        <h3><i class="fa fa-envelope"></i> Scrivici:</h3>
		                        <p class="m-0">Ti risponderemo il più presto possibile!</p>
		                    </div>
		                </div>
		                <div class="card-body p-3">
		
		                    <!--Body-->
		                    <div class="form-group">
		                        <label>Nome</label>
		                        <div class="input-group">
		                            <div class="input-group-addon bg-light"><i class="fa fa-user text-primary"> |</i></div>
		                            <input type="text" class="form-control" id="nome" placeholder="Nome">
		                        </div>
		                    </div>
		                    <div class="form-group">
		                        <label>Email</label>
		                        <div class="input-group mb-2 mb-sm-0">
		                            <div class="input-group-addon bg-light"><i class="fa fa-envelope text-primary"> |</i></div>
		                            <input type="text" class="form-control" id="email" placeholder="Email">
		                        </div>
		                    </div>
		                    <div class="form-group">
		                        <label>Oggetto</label>
		                        <div class="input-group mb-2 mb-sm-0">
		                            <div class="input-group-addon bg-light"><i class="fa fa-tag prefix text-primary"> |</i></div>
		                            <input type="text" class="form-control" id="servizio" placeholder="Oggetto">
		                        </div>
		                    </div>
		                    <div class="form-group">
		                        <label>Messaggio</label>
		                        <div class="input-group mb-2 mb-sm-0">
		                            <div class="input-group-addon bg-light"><i class="fa fa-pencil text-primary"> |</i></div>
		                            <textarea class="form-control"></textarea>
		                        </div>
		                    </div>
		
		                    <div class="text-center">
		                        <button class="btn btn-primary btn-block rounded-0 py-2">Invia</button>
		                    </div>
		
		                </div>
		
		            </div>
		            <!--Form with header-->
		
		        </div>
		        <!--Grid column-->
		
		        <!--Grid column-->
		        <div class="col-lg-7">
		
		            <!--Google map-->
		            <div class="mb-4">
		               
		            </div>
		
		            <!--Buttons-->
		            <div class="row text-center">
		                <div class="col-md-4">
		                    <a class="bg-primary px-3 py-2 rounded text-white mb-2 d-inline-block" onclick="centraMappa();"><i class="fa fa-map-marker"></i></a>
		                    <p>Rende, RE 87036,<br> Italia</p>
		                    
		                </div>
		
		                <div class="col-md-4">
		                    <a class="bg-primary px-3 py-2 rounded text-white mb-2 d-inline-block" href="tel:+0123456789"><i class="fa fa-phone"></i></a>
		                    <p>+ 01 234 567 89, <br> Mar - Ven, 8:00 - 22:00</p>
		                </div>
		
		                <div class="col-md-4">
		                    <a class="bg-primary px-3 py-2 rounded text-white mb-2 d-inline-block" href="mailto:goldenstreaming@gmail.com"><i class="fa fa-envelope"></i></a>
		                    <p>goldenstreaming@gmail.com</p>
		                </div>
		                <div id="mappa">
		                	<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3084.7195279261705!2d16.22439596592964!3d39.362587643029855!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x133f999aaa86af19%3A0xe6050cd7c28559ba!2sUniversit%C3%A0%20della%20Calabria!5e0!3m2!1sit!2sit!4v1582475883333!5m2!1sit!2sit" width="670" height="600" style="border:0;"></iframe>
		                </div>
		            </div>
		
		        </div>
		       <!--Grid column-->
		
		    </div>
		
		</section>
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
	    	    
	    <script src="js/contatti.js"></script>
	    <script src="js/notifiche.js"></script>
	</body>
</html>