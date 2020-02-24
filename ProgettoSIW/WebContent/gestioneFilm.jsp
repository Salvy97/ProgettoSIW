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

    <title>Gestione Film</title>

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

    <link rel="stylesheet" href="css/gestioneFilm.css" rel="no-referrer" />

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

	<div class="modal fade" id="exampleModalCenter" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalCenterTitle">Inserisci
						un nuovo film</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form action="salvaFilm" method="POST">
						<div class="form-group">
							<label for="titolo">Titolo</label> <input type="text"
								class="form-control" name="titolo" id="titolo" aria-describedby="titoloHelp">
						</div>
						<div class="form-group">
							<label for="anno">Anno</label> <input type="number"
								class="form-control" name="anno" id="anno">
						</div>
						<div class="form-group">
							<label for="durata">Durata</label> <input type="number"
								class="form-control" name="durata" id="durata">
						</div>
						<div class="form-group">
							<label for="genere">Genere</label> <input type="text"
								class="form-control" name="genere" id="genere">
		       			</div>
		       			<div class="form-group">
							<label for="locandina">Locandina</label> <input type="text"
								class="form-control" name="locandina" id="locandina">
						</div>
		       			<div class="form-group">
							<label for="regista">Regista</label> <input type="text"
								class="form-control" name="regista" id="regista">
						</div>
		        		<div class="form-group">
							<label for="filmato">Filmato</label> <input type="text"
								class="form-control" name="filmato" id="filmato">
						</div>
						<div class="form-group">
							<label for="immagineForum">Immagine Forum</label> <input type="text"
								class="form-control" name="immagineForum" id="immagineForum">
						</div>
						<div class="form-group">
							<label for="immagineForum">Sinossi</label> <input type="text"
								class="form-control" name="sinossi" id="sinossi">
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Chiudi</button>
							<button type="submit" class="btn btn-primary salvaContenuto">Salva</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="aggiornaFilm" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalCenterTitle">Modifica
						un film</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form action="aggiornaFilm" method="POST">
						<input type="hidden" name="idFilm" id="idA"/>
						<div class="form-group">
							<label for="titolo">Titolo</label> <input type="text"
								class="form-control" name="titolo" id="titoloA" aria-describedby="titoloHelp">
						</div>
						<div class="form-group">
							<label for="anno">Anno</label> <input type="number"
								class="form-control" name="anno" id="annoA">
						</div>
						<div class="form-group">
							<label for="durata">Durata</label> <input type="number"
								class="form-control" name="durata" id="durataA">
						</div>
						<div class="form-group">
							<label for="genere">Genere</label> <input type="text"
								class="form-control" name="genere" id="genereA">
		       			</div>
		       			<div class="form-group">
							<label for="locandina">Locandina</label> <input type="text"
								class="form-control" name="locandina" id="locandinaA">
						</div>
		       			<div class="form-group">
							<label for="regista">Regista</label> <input type="text"
								class="form-control" name="regista" id="registaA">
						</div>
		        		<div class="form-group">
							<label for="filmato">Filmato</label> <input type="text"
								class="form-control" name="filmato" id="filmatoA">
						</div>
						<div class="form-group">
							<label for="immagineForum">Immagine Forum</label> <input type="text"
								class="form-control" name="immagineForum" id="immagineForumA">
						</div>
						<div class="form-group">
							<label for="immagineForum">Sinossi</label> <input type="text"
								class="form-control" name="sinossi" id="sinossiA">
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Chiudi</button>
							<button type="submit" class="btn btn-primary salvaContenuto">Salva</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

    <!-- Page Content -->
    <div class="main container card" id="main">
      <h1>Gestione Film</h1>
      <div class="row">
      	<div class="col-lg-2" style="padding-left: 20px; padding-bottom: 20px;">
	      <button type="button" class="btn btn-success adminAddBtn " data-toggle="modal" data-target="#exampleModalCenter">Aggiungi un film</button>
		</div>
		<div class="col-lg-10"></div>
	  </div>
	
      <table class="table table-hover">
        <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">ID</th>
            <th scope="col">Titolo</th>
            <th scope="col">Anno</th>
            <th scope="col">Durata</th>
            <th scope="col">Genere</th>
            <th scope="col">Regista</th>
            <th scope="col">Locandina</th>
   			<th scope="col">Filmato</th>
   			<th scope="col">Immagine Forum</th>
   			<th scope="col">Sinossi</th>
          </tr>
          <% int i = 1; %>
          <c:forEach items="${films}" var="film">
          	<tr>
          		<td><%= i %></td>
          		<td class="cella">${film.id_film}</td>
          		<td class="cella">${film.titolo}</td>
          		<td class="cella">${film.anno}</td>
          		<td class="cella">${film.durata}</td>
          		<td class="cella">${film.genere}</td>
          		<td class="cella">${film.regista}</td>
          		<td class="cella">${film.locandina}</td>
          		<td class="cella">${film.filmato}</td>
          		<td class="cella">${film.immagineForum}</td>
          		<td class="cella" id="cellaSinossi">${film.sinossi}</td>
          		<td class="buttonCella">
          			<button class="btn btn-warning" onclick="aggiornaFilm('${film.id_film}', '${film.anno}', '${film.durata}', '${film.genere}', '${film.regista}', '${film.locandina}', '${film.filmato}', '${film.immagineForum}');">Aggiorna</button>
          		</td>
          		<td class="buttonCella">
          			<form action="eliminaFilm" method="POST">
          				<input name="id" type="hidden" value="${film.id_film}"/>
          				<button class="btn btn-danger" type="submit">Elimina</button>
          			</form>
          		</td>
          	</tr>
          	<% i++; %>
          	<input type="hidden" id="titolo${film.id_film}" value="${film.titolo}"/>
          	<input type="hidden" id="sinossi${film.id_film}" value="${film.sinossi}"/>
          </c:forEach>
        </thead>
        <tbody id="table-content"></tbody>
      </table>
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
    <script src="js/gestioneFilm.js"></script>
  </body>
</html>
