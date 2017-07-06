
<%@page import="modelo.CategoriaProducto"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
            <meta charset="UTF-8">
            <title>.:LIST_CAT:.</title>
            <link rel="stylesheet" href="carrito_style.css">
            <link rel="stylesheet" href="estilo.css">
            <script src="redirect.js" language="javascript" type="text/javascript"></script>
    </head>
    <body id = "pagina">
	<div id="contenedor">
            <section id="content_lista">
                <h1>Lista de Categorias</h1>
                <div>
                    <table id="table3">
			<tr>
                        	<th>ID</th>
				<th>DESCRIPCION</th>
				<th colspan="2">ACCION</th>
			</tr>
                        <%
                            ArrayList<CategoriaProducto> categorias = (ArrayList<CategoriaProducto>) request.getAttribute("categorias");
                            if(categorias == null){
                                System.out.println("vacio");
                            }else{
                            for (CategoriaProducto c : categorias) {
                        %>
			<tr>
                            <td><%=c.getId_categoria()%></td>
                            <td><%=c.getDescripcion()%></td>
                            <td style="width: 90px">
                                <form action="/paronline/CategoriaProductoServlet" method="post" style="margin:0">
                                    <input type="hidden" name="vaccion" value="Editar"/>
                                    <input type="hidden" name="vid" value="<%=c.getId_categoria()%>"/>							
                                    <input type="submit" id="deledit"value="Edit" />
                                </form>
                            </td>
                            <td style="width: 90px">
                                <form action="/paronline/CategoriaProductoServlet" method="post" style="margin:0">
                                    <input type="hidden" name="vaccion" value="Eliminar"/>
                                    <input type="hidden" name="vid" value="<%=c.getId_categoria()%>"/>                                                        
                                    <input type="submit" id="deledit"value="Del" />
                                </form>
                            </td>
			</tr>
                        <%
                            }
                            }
                        %>
                    </table>
                </div>

		<div style= "margin-left:20%">
                    <input type="button" id="btn_lista" value="Agregar" onclick="javascript:ir_a_reg_cat()"/>
                    <input type="button" id="btn_lista" value="Salir" onclick="javascript:ir_a_admin()"/>
		</div>
            </section>
	</div>
    </body>
</html>
