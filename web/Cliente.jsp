<%@page import="modelo.Cliente"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
            <meta charset="UTF-8">
            <title>.:LIST_CLIENT:.</title>
            <link rel="stylesheet" href="carrito_style.css">
            <link rel="stylesheet" href="estilo.css">
            <script src="redirect.js" language="javascript" type="text/javascript"></script>
    </head>
    <body id = "pagina">
        <div id="contenedor">
            <section id="content_lista">
                <h1>Lista de Clientes</h1>
                <div>
                    <table id="table1">
                        <tr>
                            <th>ID</th>
                            <th>NOMBRE</th>
                            <th>APELLIDO</th>
                            <th>CEDULA</th>
                            <th>EMAIL</th>
                            <th colspan="2">ACCION</th>
                        </tr>
                        <%
                            ArrayList<Cliente> clientes = (ArrayList<Cliente>) request.getAttribute("clientes");
                            if(clientes == null){
                                System.out.println("vacio");
                            }else{
                                for (Cliente c : clientes) {
                        %>
                        <tr>
                            <td><%=c.getId_cliente()%></td>
                            <td><%=c.getNombre()%></td>
                            <td><%=c.getApellido()%></td>
                            <td><%=c.getCedula()%></td>
                            <td><%=c.getEmail()%></td>
                            <td style="width: 90px">
                                <form action="/paronline/ClienteServlet" method="post" style="margin:0">
                                    <input type="hidden" name="vaccion" value="Editar"/>
                                    <input type="hidden" name="id_cli" value="<%=c.getId_cliente()%>"/>
                                    <input type="submit" id="deledit"value="Edit" />
                                </form>
                            </td>
                            <td style="width: 90px">
                                <form action="/paronline/ClienteServlet" method="post"style="margin:0">
                                    <input type="hidden" name="vaccion" value="Eliminar"/>
                                    <input type="hidden" name="vid" value="<%=c.getId_cliente()%>"/>
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
                <div>
                    <input type="button" id="btn_lista" value="Salir" onclick="javascript:ir_a_admin()"/>
                </div>
            </section>
        </div>
    </body>
</html>
