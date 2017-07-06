
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>.:PRODUCTO:.</title>
	<link rel="stylesheet" href="login_style.css">
	<link rel="stylesheet" href="estilo.css">
        <script src="redirect.js" language="javascript" type="text/javascript"></script>
</head>
<body id = "pagina">
	<div id="contenedor">
	<section id="content_grande">
		<form action="/paronline/ProductoServlet" method="post">
			<h1>Producto</h1>
			<div>
				<input type="text" placeholder="ID Producto" id="username" name="id_pro" required pattern="[0-9]*"/>
			</div>
			<div>
				<input type="text" placeholder="Descripcion" id="username" nameP="descripcion" required/>
			</div>
			<div>
				<input type="text" placeholder="ID Categoria" id="username" name="id_cat" required pattern="[0-9]*"/>
			</div>
			<div>
				<input type="text" placeholder="Precio" id="username" name="precio" required pattern="[0-9]*"/>
			</div>
			<div>
                                <input type="hidden" name="vaccion" value="Registrar"/>
				<input type="submit" value="Registrar" />
				<input type="button" value="Atras" onclick="javascript:ir_a_list_prod()"/>
			</div>
		</form><!-- form -->
	</section><!-- content -->
	</div>
</body>
</html>
