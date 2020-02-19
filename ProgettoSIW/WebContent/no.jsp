<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta name="description" content="">
		<meta name="author" content="">
		
		<title>Abbonati</title>
		
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.2/animate.css" />
    <link rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.0-1/css/all.css" />
    <link rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/css/bootstrap.min.css" />
      

    <link rel="stylesheet" href="css/index.css" rel="no-referrer" />
        <link rel="stylesheet" href="css/ok.css" rel="no-referrer" />
	
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
		          		<li class="nav-item">
		          			<a class="nav-link" href="index.html">Home</a>
		          		</li>
		          		<li class="nav-item active">
		            		<a class="nav-link" href="ottieniFilm">Film</a>
		          		</li>
		          		<li class="nav-item">
		            		<a class="nav-link" href="serieTV.html">Serie TV</a>
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
	      		
							<% String username = (String) session.getAttribute("username"); 
								String ruolo = (String) session.getAttribute("role");
							%>
										<ul class="navbar-nav lg-auto ml-auto sg-auto">
											<% if (username == null) { %>
												<li class="nav-item">
													<a class="nav-link" href="${pageContext.request.contextPath}/fintologin">Login</a>
												</li>

												<% } else if (ruolo != null && ruolo.equals("admin")) {%>
												<li class="nav-item">
													<a class="nav-link" href="${pageContext.request.contextPath}/pannelloadmin">Area Admin</a>
												</li>
												<li class="nav-item">
													<a class="nav-link" href="#">${username}  &#128100;</a>
												</li>
												<li class="nav-item">
													<a class="nav-link" href="${pageContext.request.contextPath}/logoutfake">Log out</a>
												</li>
												<% } else {%>
													<li class="nav-item">
														<a class="nav-link" href="${pageContext.request.contextPath}/user">Area Utente</a>
													</li>
												<li class="nav-item">
													<a class="nav-link" href="#">${username}  &#128100;</a>
												</li>
												<li class="nav-item">
													<a class="nav-link" href="${pageContext.request.contextPath}/logoutfake">Log out</a>
												</li>
												
									<% } %>
										</ul>
								</div>
	    	</div>
	    </nav>
	    
	    <!-- Page Content -->
	    <div class="container" id="main">
        

		<div class="ok-page">
<div class="ok-txt">
<h1>OPS! Something went wrong</h1>
<p>In a few seconds you will be redirected to your personal page, if the link does not work click on the menu above</p>
</div>
<div class="ok-img">
<i class="fas fa-times-circle no-ico"></i>
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
        <script
    src="https://www.paypal.com/sdk/js?client-id=AYWDsSzrI192Fz26mTpZUGsOZu-kCi4AVTakm5K8AebnzBBllJdPn82F6_QIhsamFhFvsBLxfBDnJt5R"> // Required. Replace SB_CLIENT_ID with your sandbox client ID.
  </script>
<script src="https://www.paypalobjects.com/api/checkout.js"></script>
      <script src="js/no.js"></script>
	</body>
</html>