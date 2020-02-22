<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
    	<meta charset="utf-8"/>
   		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
   		<meta name="description" content=""/>
   		<meta name="author" content=""/>

   		<title>Profilo di ${profilo.username}</title>

   		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.2/animate.css"/>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.0-1/css/all.css" />
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/css/bootstrap.min.css"/>
		<link rel="stylesheet" href="css/profilo.css" rel="no-referrer" />
   
   		<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
		<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
		<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

		<!-- Favicon -->
		<link rel="shortcut icon" type="image/png" href="images/favicon.png" />
	</head>
  
  	<body onload="javascript:calculateRating('${profilo.contenutiGuardati}', '${profilo.postsCreati}', '${profilo.recensioniEffettuate}');">
    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="ottieniIndex" id="logo">
          <img src="images/logo.gif" />
        </a>
        <button
          class="navbar-toggler"
          type="button"
          data-toggle="collapse"
          data-target="#navbarResponsive"
          aria-controls="navbarResponsive"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
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

    <!-- Page Content -->
    <div class="container emp-profile">
        <div class="row">
            <div class="col-md-4">
                <div class="profile-img">
                    <img src="${profilo.immagineDiProfilo}" alt=""/>
                    <c:choose>
                    	<c:when test="${profilo.username==sessionScope.name}">
		                    <div class="file btn btn-lg btn-primary" onclick="showCambiaImmagineForm();">
		                        Cambia Immagine di Profilo
		                    </div>
		                </c:when>
		            </c:choose>
                </div>
            </div>
            <div class="col-md-6">
                <div class="profile-head">
                    <h5>
                        ${profilo.username}
                    </h5>
                    <h6 id="fraseInfo"></h6>
                    <p class="proile-rating">RATING : <span id="rating"></span></p>
                    <ul class="nav nav-tabs" id="myTab" role="tablist">
                        <li class="nav-item">
                            <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">Informazioni</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="false">Timeline</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4">
                <div class="profile-work">
                	<div id="mainDivProfile"></div>
                	<c:choose>
                		<c:when test="${profilo.username==sessionScope.name}">
		                    <p>GESTISCI ACCOUNT</p>
		                    <a href="abbonamento.jsp">Il tuo abbonamento</a><br/>
		                    <a href="">Storico pagamenti</a><br/>
		                    <a href="cambiaUsername.jsp">Modifica username</a><br/>
		                    <a href="cambiaPassword.jsp">Modifica password</a>
		                </c:when>
	                </c:choose>
                    <p>SCOPRI</p>
                    <a href="ottieniFilmGuardati?username=<%= request.getParameter("username") %>">Film guardati</a><br/>
                     <a href="ottieniEpisodiGuardati?username=<%= request.getParameter("username") %>">Episodi guardati</a><br/>
                    <a href="ottieniPostUser?username=${profilo.username}">Posts creati</a><br/>
                </div>       	
            </div>
            <div class="col-md-8">
                <div class="tab-content profile-tab" id="myTabContent">
                    <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                        <div class="row">
                            <div class="col-md-6">
                                <label>Nome</label>
                            </div>
                            <div class="col-md-6">
                                <p>${profilo.nome}</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Cognome</label>
                            </div>
                            <div class="col-md-6">
                                <p>${profilo.cognome}</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Email</label>
                            </div>
                            <div class="col-md-6">
                                <p>${profilo.email}</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Contenuti guardati</label>
                            </div>
                            <div class="col-md-6">
                                <p>${profilo.contenutiGuardati}</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Recensioni effettuate</label>
                            </div>
                            <div class="col-md-6">
                                <p>${profilo.recensioniEffettuate}</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Posts creati</label>
                            </div>
                            <div class="col-md-6">
                                <p>${profilo.postsCreati}</p>
                            </div>
                        </div>
            		</div>
            		
                    <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                           <div class="row">
                               <div class="col-md-6">
                                   <label>Experience</label>
                               </div>
                               <div class="col-md-6">
                                   <p>Expert</p>
                               </div>
                           </div>
                           <div class="row">
                               <div class="col-md-6">
                                   <label>Hourly Rate</label>
                               </div>
                               <div class="col-md-6">
                                   <p>10$/hr</p>
                               </div>
                           </div>
                           <div class="row">
                               <div class="col-md-6">
                                   <label>Total Projects</label>
                               </div>
                               <div class="col-md-6">
                                   <p>230</p>
                               </div>
                           </div>
                           <div class="row">
                               <div class="col-md-6">
                                   <label>English Level</label>
                               </div>
                               <div class="col-md-6">
                                   <p>Expert</p>
                               </div>
                           </div>
                           <div class="row">
                               <div class="col-md-6">
                                   <label>Availability</label>
                               </div>
                               <div class="col-md-6">
                                   <p>6 months</p>
                               </div>
                           </div>
                        <div class="row">
                            <div class="col-md-12">
                                <label>Your Bio</label><br/>
                                <p>Your detail description</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>        
	</div>
    
    <footer class="py-4 bg-dark fixed-bottom">
    	<div class="container">
     		<p class="m-0 text-right text-white">
          		Copyright &copy; Golden Streaming 2019-2020
        	</p>
      	</div>
      <!-- /.container -->
    </footer>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/lodash.js/4.17.15/lodash.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>
    <script src="https://www.paypal.com/sdk/js?client-id=AYWDsSzrI192Fz26mTpZUGsOZu-kCi4AVTakm5K8AebnzBBllJdPn82F6_QIhsamFhFvsBLxfBDnJt5R"></script>
    <script src="https://www.paypalobjects.com/api/checkout.js"></script>
    <script src="js/profilo.js"></script>
  </body>
</html>