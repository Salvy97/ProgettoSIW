<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Posts di <%= request.getParameter("username") %></title>
		<!-- Bootstrap core CSS -->
		<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.2/animate.css"/>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.0-1/css/all.css" />
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/css/bootstrap.min.css"/>
	
		<!-- Custom styles for this template -->
		<link href="css/forum.css" rel="stylesheet">
		
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
	    
	   	<div class="container" style="padding-bottom: 16%;"> 
		   	<div class="card row">
		    	<div class="card-body col-lg-12 row">
		    		<div class="col-lg-5"></div>
		    		<h2 class="card-title col-lg-5">Posts di <%= request.getParameter("username") %></h2>
		    		<div class="col-lg-2"></div>	
		    	</div>
		    </div>
	    
		    <div class="row">
			    <div class="card h-100 col-lg-4 col-md-6 mb-4">
			    	<div class="card-body">
		                <h3 class="card-title" style="color: blue;">
		                    Ultimi Posts
		                </h3>
		                <c:forEach items="${posts}" var="post">
			                <div class="post card-footer" onclick="showPost('${post.id}', '${post.username}', '${post.data}', '${post.ora}', '${post.titolo}', '${post.descrizione}', '${post.profileImage}', '${post.commenti}')">
			                	<div class="row">	
				                	<img class="col-lg-4" src="${post.profileImage}" width="80" height="80"/>
					                <p id="titoloPost" class="col-lg-8 card-text">
					                	${post.titolo}
					                </p>
					            </div>
					            <div class="row">
					            	<p id="usernamePost" class="col-lg-6">${post.username}</p>
					            	<div id="dataPost" class="col-lg-6">${post.data}</div>
					            </div>				  
				            </div>
			            </c:forEach>
		            </div>
			    </div>
			   	
			    <div class="col-lg-8 col-md-6 mb-8 card h-100" >
			    	<div class="card-body">
			    		<div class="row">
			    			<div class="col-lg-4">
			    				<img id="profilePicture" onclick="goToProfileFromPost();" src="" width="100" height="100"/>
			    				<p id="username" onclick="goToProfileFromPost();" style="font-size: 18px; padding-top: 10px;"></p>
			    			</div>
			    			<div class="lg-auto ml-auto sg-auto">
				    			<div id="data"></div>
				    			<p id="ora" style="text-align: right;"></p>
				    		</div>
			    		</div>
			    		<div id="titolo"></div>
			    		<hr>
			    		<div id="descrizione"></div>
			    		<hr>
			    		<div id="commentiInfo"><span id="numeroCommenti"></span> Commenti</div>
			    		<div id="commenti" class="jumbotron"></div>
			    	</div>
			    	<div class="card-footer">
			    		<div class="row">
			    			<form id="commenta" action="creaCommento" method="POST">
				    			<input name="commento" id="commento" class="col-lg-10" placeholder="Commenta" onkeyup="updateCharNumber();"/>
				    			<input type="hidden" name="post" id="postCommento"/>
				    			<input type="hidden" name="contenuto" id="contenutoCommento"/>
				    			<input type="hidden" name="username" value="<%= request.getParameter("username") %>"/>
				    		</form>
				    		<button class="btn btn-info col-lg-2" name="posta" style="margin: 0 10px;" onclick="commenta();">Posta</button>
			    		</div>
			    		<div id="showCharNumber">
					    	<span id="currentCharNumber">0</span> / 128
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
	    <script src="js/userPosts.js"></script>
	    <script src="js/notifiche.js"></script>
	</body>
</html>