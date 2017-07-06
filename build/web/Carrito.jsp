
<%@page import="conexion.TransaccionCabConexion"%>
<%@page import="conexion.ClienteConexion"%>
<%@page import="modelo.Cliente"%>
<%@page import="modelo.Usuario"%>
<%@page import="modelo.TransaccionDet"%>
<%@page import="modelo.TransaccionCab"%>
<%@page import="modelo.Carrito"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
            <meta charset="UTF-8">
            <title>.:CARRITO:.</title>
            <link rel="stylesheet" href="carrito_style.css">
            <link rel="stylesheet" href="estilo.css">
            <script src="redirect.js" language="javascript" type="text/javascript"></script>
            <script src="habilitar.js" language="javascript" type="text/javascript"></script>
    </head>
    <body id = "pagina">
	<div id="contenedor">
            <section id="content_tablita">
		<h1>Carrito</h1>
		<div style="height:80%;overflow-y:auto">
                    <table id="table2" style="width:80%; margin-left:10%">
			<tr>
                            <th>ID</th>
                            <th>Descripcion</th>
                            <th>Precio</th>
                            <th>Cantidad</th>
                            <th>Accion</th>
			</tr>
                        <%
                            ArrayList<Carrito> carrito = (ArrayList<Carrito>) request.getSession().getAttribute("carrito");
                            int monto_total=0;
                            HttpSession hs = request.getSession();
                            if (carrito == null){
                                out.print("Debe loguearse para poder realizar compra");
                            }
                            else if (carrito != null) {
                                for (Carrito c : carrito) {
                        %>
			<tr>
                            <%monto_total = monto_total + (c.getProducto().getPrecio() * c.getCantidad());%>
                            <td><%=c.getProducto().getId_producto()%></td>
                            <td><%=c.getProducto().getDescripcion()%></td>
                            <td><%=c.getProducto().getPrecio()%></td>
                            <td><%=c.getCantidad()%></td>
                            <td style="width:80px">
                                <form action="/paronline/CarritoServlet" method="post"> 
                                    <input type="hidden" name="quitar" value="quitar"/>
                                    <input type="hidden" name="vid" value="<%=c.getProducto().getId_producto()%>"/>
                                    <input type="submit" id="add" value="Quitar" />
                                </form>
                            </td>
			</tr>
                        <% } }%>
			<tr>
                            <td colspan="5" style="background-color:white; color: #7E7E7E; border: 3px solid rgba(254,193,81,1);font-size: 15px;font-weight:bold">Total a pagar:<%=monto_total%></td>
			</tr>
                        <%
                            hs.setAttribute("monto_total",monto_total);
                        %>
                    </table>
                </div>
            </section>
            <section id="content">
		<form action="/paronline/TransaccionServlet" method="post" name="pagoenvio">
                    <h1>Pago & Envio</h1>
                    <div>
                        <div style="text-align: left">
                            <h4>Forma de Pago</h4>
                        </div>
                        <div style="text-align: left; margin: 0px 0px 20px 20px">
                            <input type="radio" id="efectivo" name="pago" value="efectivo" checked onClick="deshabilita(this.value)">
                            <label for="efectivo"><span></span>Efectivo</label>
                            <input type="radio" id="tarjeta" name="pago" value="tarjeta" onClick="habilita(this.value)"/>
                            <label for="tarjeta"><span></span>Tarjeta</label>
                        </div>
                    </div>
                    <div>
                        <input type="text" placeholder="Nro de Tarjeta" id="num_tarjeta" name="nro_tarjeta" required disabled/>
                    </div>
                    <div>
                        <input type="text" placeholder="Direccion de Envio" id="direccion" name="direccion" required/>
                    </div>
                    <div>
                        <input type="hidden" name="confirmar" value="confirmar"/> 
                        <input type="submit" value="Confirmar" />
                        <input type="hidden" name="cancelar" value="cancelar"/> 
                        <input type="button" value="Cancelar" onclick="javascript:ir_a_inicio()"/>
                    </div>
                </form><!-- form -->
            </section><!-- content -->
	</div>
    </body>
</html>
