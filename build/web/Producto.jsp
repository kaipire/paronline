
<%@page import="modelo.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
            <meta charset="UTF-8">
            <title>.:LIST_PRODUCT:.</title>
            <link rel="stylesheet" href="carrito_style.css">
            <link rel="stylesheet" href="estilo.css">
            <script src="redirect.js" language="javascript" type="text/javascript"></script>
    </head>
    <body id = "pagina">
        <div id="contenedor">
                <section id="content_lista">
                    <h1>Lista de Productos</h1>
                    <div style="height:60%;overflow-y:auto">
                        <table id="table1">
                            <tr>
                                <th>ID</th>
                                <th>DESCRIPCION</th>
                                <th>CATEGORIA</th>
                                <th>PRECIO</th>
                                <th colspan="2">ACCION</th>
                            </tr>
                            <%
                                ArrayList<Producto> productos = (ArrayList<Producto>) request.getAttribute("productos");
                                if(productos == null){
                                    System.out.println("vacio");
                                }else{
                                for (Producto p : productos) {
                            %>
                            <tr>
                                <td><%=p.getId_producto()%></td>
                                <td><%=p.getDescripcion()%></td>
                                <td><%=p.getCategoria().getDescripcion()%></td>
                                <td><%=p.getPrecio()%></td>
                                <td style="width: 90px">
                                    <form action="/paronline/ProductoServlet" method="post" style="margin:0">
                                        <input type="hidden" name="vaccion" value="Editar"/>
                                        <input type="hidden" name="id_pro" value="<%=p.getId_producto()%>"/>
                                        <input type="submit" id="deledit" value="Edit" />
                                    </form>
                                </td>
                                <td style="width: 90px">
                                    <form action="/paronline/ProductoServlet" method="post" style="margin:0">
                                        <input type="hidden" name="vaccion" value="Eliminar"/>
                                        <input type="hidden" name="id_pro" value="<%=p.getId_producto()%>"/>
                                        <input type="submit" id="deledit" value="Del" />
                                    </form>
                                </td>
                            </tr>
                            <%
                              }
                              }
                             %>
                        </table>
                    </div>

                    <div>
                        <input type="button" id="btn_lista" value="Agregar" onclick="javascript:ir_a_reg_prod()"/>
                        <input type="button" id="btn_lista" value="Salir" onclick="javascript:ir_a_admin()"/>
                    </div>
                </section>
	</div>
    </body>
</html>
