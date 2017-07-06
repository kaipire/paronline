



<%@page import="modelo.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>.:HOME:.</title>
	<link rel="stylesheet" href="estilo.css">
	<link rel="stylesheet" href="carrito_style.css">
</head>
<body id = "pagina">
		<header id="header">
			<div id="logo">
				<img src="logopar.png">
			</div>
			<div id="login">
				<nav>
					<a href="/paronline/Login.jsp">Login</a>
					<a href="/paronline/LoginServlet?cerrar=cerrar">Cerrar Sesion</a>
				</nav>
			</div>
		</header>
		<div id="menu">
			<ul>
				<li><a href="/paronline/CarritoServlet?confirmar=conf_carrito">Carrito</a></li>
				<li><a href="/paronline/HistorialCliente.jsp">Historial</a></li>
				<li><a href="">Categorias ></a>
					<ul style="position: relative; max-height: 100%">
						<li><a href="/paronline/FiltroProductoServlet?cat=1">Deportes</a></li>
						<li><a href="/paronline/FiltroProductoServlet?cat=2">Rol</a></li>
						<li><a href="/paronline/FiltroProductoServlet?cat=3">Shooter</a></li>
					</ul>
				</li>
			</ul>
		</div>
		<div id="espacio">
		</div>
		<div id="contenido">
				<section id="content_tablita">
					
						<h1>Bienvenido</h1>
						<h3>${sessionScope.usuario}</h3>
						<div style="height:80%;overflow-y:auto">
							<table id="table2" style="width:80%; margin-left:10%">
								<tr>
									<th>ID</th>
									<th>Descripcion</th>
									<th>Cantidad</th>
								</tr>
                                                                <%
                                                                    //aca vamos a poner al getALL() de producto y que vaya listando
                                                                    ArrayList<Producto> p1 = (ArrayList<Producto>) request.getAttribute("array_producto");

                                                                    if (p1 != null) {
                                                                        for (Producto p : p1) {
                                                                %>
								<tr>
									<td><%=p.getId_producto()%></td>
									<td><%=p.getDescripcion()%></td>
									<td style="width: 150px">
                                                                            <form action="/paronline/CarritoServlet" method="post">
                                                                                <input type="hidden" name="vaccion" value="agregar_carrito"/>
                                                                                <input type="hidden" name="vid" value="<%=p.getId_producto()%>"/>
                                                                                <input type="submit" id="add" value="Add" />
                                                                                <input title="Ingrese una cantidad valida" type="text" placeholder="" id="cantidad" name="cantidad" required pattern="[0-9]"/>
                                                                            </form>
										
									</td>
								</tr>
                                                                <% } }%>
							</table>
						</div>
					<!-- form -->
				</section>
				<section id="content">
					<form action="/paronline/FiltroProductoServlet" method="post">
						<h1>Busqueda</h1>
						<div>
							<input type="text" placeholder="Ingrese nombre de producto" name="descripcion"/>
						</div>
						<div>
							<input type="submit" value="Buscar" />
						</div>
					</form>
				</section>
		</div>
		<footer id="footer">
		</footer>
</body>
</html>
