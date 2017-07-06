<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>.:REGISTER:.</title>
	<link rel="stylesheet" href="login_style.css">
	<link rel="stylesheet" href="estilo.css">
        <script src="redirect.js" language="javascript" type="text/javascript"></script>
</head>
<body id = "pagina">
	<div id="contenedor">
	<section id="content_grande">
		<form action="/paronline/ClienteServlet" style="height: 100%;overflow-y:auto">
			<h1>Registro</h1>
                        <div>
                            <input type="text" placeholder="Nombre"  name="nombre" required/>
                        </div>
                        <div>
                            <input type="text" placeholder="Apellido" id="username" name="apellido"required/>
                        </div>
                        <div>
                            <input title="Ingrese un numero de cedula valido" maxlength="7" type="text"  placeholder="Cedula" id="username" name="cedula" required pattern="[0-9]*"/>
                        </div>
                        <div>
                            <input type="email" placeholder="Email" id="username" name="email" required/>
                        </div>
                        <div>
                            <input type="password" placeholder="Password" id="password" name="cont" required/>
                        </div>
			<div>
                            <input type="hidden" name="vaccion" value="Registrar"/>
                            <input type="submit" value="Registrar" />
                            <input type="button" value="Atras" onclick="javascript:ir_a_login()" />
			</div>
		</form>
	</section>
	</div>
</body>
</html>
