
<%@page import="modelo.CategoriaProducto"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>.:EDIT-CATEGORIA:.</title>
        <link rel="stylesheet" href="login_style.css">
        <link rel="stylesheet" href="estilo.css">
        <script src="redirect.js" language="javascript" type="text/javascript"></script>
    </head>
    <body id = "pagina">
        <%
            CategoriaProducto c = (CategoriaProducto)request.getAttribute("categoria");
        %>
        <div id="contenedor">
            <section id="content">
                <form action="/paronline/CategoriaProductoServlet" method="post">
                    <h1>Editar Categoria</h1>
                    <div>
                        <input type="text" placeholder="<%=c.getDescripcion()%>" required="" id="username" name="descripcion" required/>
                    </div>
                    <div>
                        <input type="hidden" name="vid" value="<%=c.getId_categoria()%>"/>
                        <input type="hidden" name="vaccion" value="GrabarModificado"/>
                        <input type="submit" name="vaccion" value="Guardar" />
                        <input type="button" value="Cancelar" onclick="javascript:ir_a_list_cat()"/>
                    </div>
                </form><!-- form -->
            </section><!-- content -->
        </div>
    </body>
</html>
