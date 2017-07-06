
<%@page import="java.sql.ResultSet"%>
<%@page import="modelo.Usuario"%>
<%@page import="modelo.TransaccionDet"%>
<%@page import="conexion.TransaccionDetConexion"%>
<%@page import="conexion.TransaccionCabConexion"%>
<%@page import="modelo.TransaccionCab"%>
<%@page import="modelo.Cliente"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
            <meta charset="UTF-8">
            <title>.:HISTORY:.</title>
            <link rel="stylesheet" href="carrito_style.css">
            <link rel="stylesheet" href="estilo.css">
            <script src="redirect.js" language="javascript" type="text/javascript"></script>
    </head>
    <body id = "pagina">
	<div id="contenedor">
            <section id="content_lista">
     		<h1>Historial</h1>
		<div style="height:60%;overflow-y:auto">
                    <table id="table1">
                        <tr>
                            <th>ID TRANS</th>
                            <th>ID PROD</th>
                            <th>DESCRIPCION</th>
                            <th>PRECIO UNIT</th>
                            <th>CANT</th>
                            <th>IMPORTE</th>
                            <th>TOTAL</th>
                            <th>FECHA</th>
			</tr>
                        <%
                            Usuario u = (Usuario) request.getSession().getAttribute("usuario");
                            TransaccionDetConexion tdc= new TransaccionDetConexion(); 
                            TransaccionDet td = new TransaccionDet();
 
                            if(u == null || u.getCedula() == 12345){
                                out.print("Debe loguearse para revisar su historial");
                            }
                            else{
                                int cedula = u.getCedula();
                                ResultSet rs = tdc.historial(cedula);
                                while(rs.next()){
                        %>
			<tr>
                            <td><% out.print(rs.getInt(1));%></td>
                            <td><% out.print(rs.getInt(2));%></td>
                            <td><% out.print(rs.getString(3));%></td>
                            <td><% out.print(rs.getInt(4));%></td>
                            <td><% out.print(rs.getInt(5));%></td>
                            <td><% out.print(rs.getInt(6));%></td>
                            <td><% out.print(rs.getInt(7));%></td>
                            <td><% out.print(rs.getDate(8));%></td>
			</tr>
                        <%}}%> 
                    </table>
		</div>

		<div>
                    <input type="button" id="btn_lista"value="Atras" onclick="javascript:ir_a_inicio()"/>
		</div>
            </section>
	</div>
    </body>
</html>

