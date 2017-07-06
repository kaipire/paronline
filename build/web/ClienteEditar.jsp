
<%@page import="modelo.Cliente"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>.:EDIT-CLIENT:.</title>
	<link rel="stylesheet" href="login_style.css">
	<link rel="stylesheet" href="estilo.css">
        <script src="redirect.js" language="javascript" type="text/javascript"></script>
</head>
<body id = "pagina">
        <%
            Cliente c = (Cliente)request.getAttribute("cliente");
         %>
	<div id="contenedor">
	<section id="content_grande">
		<form action="/paronline/ClienteServlet" method="post">
			<h1>Editar Cliente</h1>
			<div>
				<input type="text" placeholder="Nombre:" value="<%=c.getNombre()%>" id="username" name="nombre" required/>
			</div>
			<div>
				<input type="text" placeholder="Apellido:" value="<%=c.getApellido()%>"  id="username" name="apellido" required/>
			</div>
			<div>
				<input type="text" maxlength="7" placeholder="Cedula:" value="<%=c.getCedula()%>" id="username" name="cedula" required pattern="[0-9]*"/>
			</div>
			<div>
				<input type="email" placeholder="Email:" value="<%=c.getEmail()%>" id="username" name="email" required/>
			</div>
			<div>
				<input type="password" placeholder="Contraseña" value="<%=c.getContrasenha()%>" id="password" name="cont" required/>
			</div>
			<div>
                                <input type="hidden" name="id_cli" value="<%=c.getId_cliente()%>"/>
                                <input type="hidden" name="vaccion" value="GrabarModificado"/>
				<input type="submit" value="Guardar" />
				<input type="button" value="Cancelar" onclick="javascript:ir_a_list_cli()"/>
			</div>
		</form><!-- form -->
	</section><!-- content -->
	</div>
</body>
</html>
