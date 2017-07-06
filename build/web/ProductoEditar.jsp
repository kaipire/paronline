<%@page import="modelo.Producto"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>.:EDIT-PRODUCT:.</title>
        <link rel="stylesheet" href="login_style.css">
        <link rel="stylesheet" href="estilo.css">
        <script src="redirect.js" language="javascript" type="text/javascript"></script>
    </head>
    <body id = "pagina">
        <%
            Producto p = (Producto)request.getAttribute("producto");
        %>
        <div id="contenedor">
            <section id="content_grande">
                <form action="/paronline/ProductoServlet" method="post">
                    <h1>Editar Producto</h1>
                    <div>
                        <input type="text" placeholder="<%=p.getDescripcion()%>" id="username" name="descripcion" required/>
                    </div>
                    <div>
                        <input type="text" placeholder="<%=p.getCategoria().getId_categoria()%>" id="username" name="id_cat" required pattern="[0-9]"/>
                    </div>
                    <div>
                        <input type="text" placeholder="<%=p.getPrecio()%>" id="username" name="precio" required pattern="[0-9]"/>
                    </div>
                    <div>
                        <input type="hidden" name="id_pro" value="<%=p.getId_producto()%>"/> 
                        <input type="hidden" name="vaccion" value="GrabarModificado"/>
                        <input type="submit" name="vaccion" value="Guardar" />
                        <input type="button" value="Cancelar" onclick="javascript:ir_a_list_prod()"/>
                    </div>
                </form><!-- form -->
            </section><!-- content -->
        </div>
    </body>
</html>

