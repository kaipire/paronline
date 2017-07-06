<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>.:LOGIN:.</title>
	<link rel="stylesheet" href="login_style.css">
	<link rel="stylesheet" href="estilo.css">
        <script src="redirect.js" language="javascript" type="text/javascript"></script>
</head>
<body id = "pagina">
	
	<div id="contenedor">
	<section id="content">
		<form action="/paronline/LoginServlet" id="login_form" method="post">
			<h1>Login</h1>
			<div>
				<input type="text" placeholder="Cedula" id="username" name="cedula" required/>
			</div>
			<div>
				<input type="password" placeholder="Contraseña" id="password" name="contrasenha" required/>
			</div>
			<div>
                                <input type="hidden" name="vaccion" value="login"/>
				<input type="submit" value="Log in" />
				<input type="button" value="Cancelar" onclick="javascript:ir_a_inicio()" />
				<a href="/paronline/ClienteNuevo.jsp">Register</a>
			</div>
		</form>
                <%if(request.getAttribute("error") != null){
                    out.print("Error de Login"); //hacer con javascrip posiblemente
                }%>
	</section><!-- content -->
	</div>
</body>
</html>
