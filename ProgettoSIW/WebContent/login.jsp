<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta name="description" content="">
		<meta name="author" content="">
	
		<title>Golden Streaming - Login</title>
	
		<!-- Bootstrap core CSS -->
		<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.2/animate.css"/>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.0-1/css/all.css" />
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/css/bootstrap.min.css"/>
	
		<!-- Custom styles for this template -->
		<link href="css/login.css" rel="stylesheet">
		
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
	
		<!-- Page Content -->
	    <div class="container">

			 <c:choose>
				<c:when test="${sessionScope.error=='email'}">
			    	<div id="myModal" class="modal fade" tabindex="-1">
				        <div class="modal-dialog">
				            <div class="modal-content">
				                <div class="modal-header">
				                    <h5 class="modal-title">Attenzione</h5>
				                    <button type="button" class="close" data-dismiss="modal">&times;</button>
				                </div>
				                <div class="modal-body">
				                    <p>L'email inserita � errata o inesistente!</p>
				                    <p class="text-secondary"><small>Riprova.</small></p>
				                </div>
				                <div class="modal-footer">
				                    <button type="button" class="btn btn-primary" data-dismiss="modal">OK</button>
				                </div>
				            </div>
				        </div>
				    </div>    
			    </c:when>
			</c:choose>
			
			<c:choose>
				<c:when test="${sessionScope.error=='password'}">
			    	<div id="myModal" class="modal fade" tabindex="-1">
				        <div class="modal-dialog">
				            <div class="modal-content">
				                <div class="modal-header">
				                    <h5 class="modal-title">Attenzione</h5>
				                    <button type="button" class="close" data-dismiss="modal">&times;</button>
				                </div>
				                <div class="modal-body">
				                    <p>La password inserita non corrisponde con l'account in questione!</p>
				                    <p class="text-secondary"><small>Riprova.</small></p>
				                </div>
				                <div class="modal-footer">
				                    <button type="button" class="btn btn-primary" data-dismiss="modal">OK</button>
				                </div>
				            </div>
				        </div>
				    </div>    
			    </c:when>
			</c:choose>

			<div class="card card-container">
	            <!-- <img id="profile-img" class="profile-img-card" src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" />
	            <p id="profile-name" class="profile-name-card">Login</p> -->
	            <form class="form-signin" action="LoginServlet" method="post">
	            	<h2>Login</h2>
					<p class="hint-text">Accedi al tuo account. Inserisci email e password.</p>
	     			
	                <span id="reauth-email" class="reauth-email"></span>
	                <input name="email" type="email" id="inputEmail" class="form-control" placeholder="Indirizzo email" required autofocus>
	                <input name="password" type="password" id="inputPassword" class="form-control" placeholder="Password" required>
	                <div id="remember" class="checkbox">
	                    <label>
	                        <input type="checkbox" value="remember-me"> Ricordami
	                        
	                    </label>
	                </div>
	                <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Login</button>
	            </form><!-- /form -->
	            <a href="#" class="forgot-password">
	                Password dimenticata?
	            </a>
	        </div><!-- /card-container -->		
		
	    
		    
		    <!-- /.row -->
	    </div>
		<!-- container -->
		
	
	    <!-- Footer -->
	    <footer class="py-4 bg-dark fixed-bottom">
	        <div class="container">
	            <p class="m-0 text-right text-white">Copyright &copy; Golden Streaming 2019-2020</p>
	        </div>
	        <!-- /.container -->
	    </footer>
	
		<!-- Bootstrap core JavaScript -->
	 	<script src="jquery/jquery.min.js"></script>
	    <script src="bootstrap/js/bootstrap.bundle.min.js"></script>
	    	    
	    <script src="js/login.js"></script>
	    <script src="js/notifiche.js"></script>
	</body>
</html>