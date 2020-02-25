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

    <title>Gestione Episodi</title>

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

    <link rel="stylesheet" href="css/gestioneEpisodi.css" rel="no-referrer" />

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
						    		<div class="dropdown">
							    		<button class="btn btn-outline-primary" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
										    <i class="fa fa-envelope"></i>
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

	<div class="modal fade" id="exampleModalCenter" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalCenterTitle">Inserisci
						un nuovo episodio</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form action="salvaEpisodio" method="POST">
						<input type="hidden" name="id" value='<%= request.getParameter("id") %>'/>
						<div class="form-group">
							<label for="titolo">Titolo</label> <input type="text"
								class="form-control" name="titolo" id="titolo" aria-describedby="titoloHelp">
						</div>
						<div class="form-group">
							<label for="anno">Durata</label> <input type="number"
								class="form-control" name="durata" id="durata">
						</div>
						<div class="form-group">
							<label for="genere">Filmato</label> <input type="text"
								class="form-control" name="filmato" id="filmato">
		       			</div>
		       			<div class="form-group">
							<label for="locandina">Numero episodio</label> <input type="text"
								class="form-control" name="numeroEpisodio" id="numeroEpisodio">
						</div>
						<div class="form-group">
							<label for="locandina">Sinossi</label> <input type="text"
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

	<div class="modal fade" id="aggiornaEpisodio" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalCenterTitle">Modifica
						un episodio</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form action="aggiornaEpisodio" method="POST">
						<input type="hidden" name="idEpisodio" id="idA"/>
						<input type="hidden" name="idStagione" value='<%= request.getParameter("id") %>'/>
						<div class="form-group">
							<label for="titolo">Titolo</label> <input type="text"
								class="form-control" name="titolo" id="titoloA" aria-describedby="titoloHelp">
						</div>
						<div class="form-group">
							<label for="anno">Durata</label> <input type="number"
								class="form-control" name="durata" id="durataA">
						</div>
						<div class="form-group">
							<label for="genere">Filmato</label> <input type="text"
								class="form-control" name="filmato" id="filmatoA">
		       			</div>
		       			<div class="form-group">
							<label for="locandina">Numero episodio</label> <input type="text"
								class="form-control" name="numeroEpisodio" id="numeroEpisodioA">
						</div>
						<div class="form-group">
							<label for="locandina">Sinossi</label> <input type="text"
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
      <h1>Gestione Episodi della stagione ${stagione.numero_stagione} di ${serieTV.titolo}</h1>
      <div class="row">
      	<div class="col-lg-2" style="padding-left: 20px; padding-bottom: 20px;">
	      <button type="button" class="btn btn-success adminAddBtn " data-toggle="modal" data-target="#exampleModalCenter">Aggiungi un episodio</button>
		</div>
		<div class="col-lg-10"></div>
	  </div>
	
      <table class="table table-hover">
        <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">ID</th>
            <th scope="col">Titolo</th>
            <th scope="col">Durata</th>
            <th scope="col">Filmato</th>
            <th scope="col">Numero Episodio</th>
            <th scope="col">Sinossi</th>
          </tr>
          <% int i = 1; %>
          <c:forEach items="${episodi}" var="episodio">
          	<tr>
          		<td><%= i %></td>
          		<td class="cella">${episodio.id_episodio}</td>
          		<td class="cella">${episodio.titolo}</td>
          		<td class="cella">${episodio.durata}</td>
          		<td class="cella">${episodio.filmato}</td>
          		<td class="cella">${episodio.numero_episodio}</td>
          		<td class="cella" id="cellaSinossi">${episodio.sinossi}</td>
          		<td class="buttonCella">
          			<button class="btn btn-warning" onclick="aggiornaEpisodio('${episodio.id_episodio}', '${episodio.durata}', '${episodio.filmato}', '${episodio.numero_episodio}');">Aggiorna</button>
          		</td>
          		<td class="buttonCella">
          			<form action="eliminaEpisodio" method="POST">
          				<input name="id" type="hidden" value="${episodio.id_episodio}"/>
          				<button class="btn btn-danger" type="submit">Elimina</button>
          			</form>
          		</td>
          	</tr>
          	<% i++; %>
          	<input type="hidden" id="titolo${episodio.id_episodio}" value="${episodio.titolo}"/>
          	<input type="hidden" id="sinossi${episodio.id_episodio}" value="${episodio.sinossi}"/>
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
    <script src="js/gestioneEpisodi.js"></script>
    <script src="js/notifiche.js"></script>
  </body>
</html>