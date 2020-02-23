<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <meta name="description" content="" />
    <meta name="author" content="" />

    <title>Abbonati</title>

    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.2/animate.css"
    />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.0-1/css/all.css"
    />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/css/bootstrap.min.css"
    />

    <link rel="stylesheet" href="css/index.css" rel="no-referrer" />
    <link rel="stylesheet" href="css/abbonamento.css" rel="no-referrer" />

    <!-- Favicon -->
    <link rel="shortcut icon" type="image/png" href="images/favicon.png" />
  </head>
  <body>
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
    <div class="container" id="main">
      <div class="card-deck mb-3 text-center" id="catalog"></div>

      <div class="collapse" id="ppCollapse">
        <div class="card card-body container">
          <div class="row justify-content-center">
            <div class="col-5" id="purchaseInfo"></div>
          </div>

          <div class="row justify-content-center">
            <div class="col-3 formArea">
              <input
                class="form-control form-control-lg"
                type="text"
                placeholder="Username PP"
                id="usernamepp"
              />

              <div class="form-group form-check">
                <input
                  type="checkbox"
                  class="form-check-input"
                  id="autorenew"
                />
                <label class="form-check-label" for="exampleCheck1"
                  >Autorinnovo</label
                >
							</div>
							
							<button type="button" class="btn btn-success" id="savePrefBtn">Salva le preferenze</button>
            </div>
            <div class="col-3">
              Non sei registrato?
              <a href="https://www.paypal.com/it/home" target="_blank"
                >Registrati</a
              >
            </div>
            <div class="col-3">
              <div id="paypal-button"></div>
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
    <script
      src="https://www.paypal.com/sdk/js?client-id=AYWDsSzrI192Fz26mTpZUGsOZu-kCi4AVTakm5K8AebnzBBllJdPn82F6_QIhsamFhFvsBLxfBDnJt5R"
    >
      // Required. Replace SB_CLIENT_ID with your sandbox client ID.
    </script>
    <script src="https://www.paypalobjects.com/api/checkout.js"></script>
    <script src="js/abbonati.js"></script>
  </body>
</html>
