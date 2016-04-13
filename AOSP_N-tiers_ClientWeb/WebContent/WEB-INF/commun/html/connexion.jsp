<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"	href='<s:url namespace="/resources" action="css_style"/>'/>


<title>Avec ou sans patates - Gestion de potager en ligne -</title>
</head>
<body>

	<div class="blur">
		<header>
			<img class="logo" alt="logo-avec ou sans patates" src="<s:url namespace="/resources" action="resources_logo"/>">
		</header>
		
		<section id="slogan">
			<h1>Gérez votre potager en ligne</h1>
			<h2>Faites du bio en un clic</h2>	
		</section>
		
		<section id="connexion">
		
			<div>
				<form method="POST" action="<%=request.getContextPath() %>/aosp/connexion" class="fond-transparent">
				
					<input type="text" name="login" placeholder="Identifiant" autofocus></input>
					<input type="password" name="password" placeholder="Password"></input>
					<button>Se connecter</button>
					
				</form>
			</div>	
			
		</section>
		
		<section id="inscription">
				Pas encore inscrit? <span><a href="">S'inscrire</a></span>
		</section>
	</div>
	

</body>
</html>