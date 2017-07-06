
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
            <meta charset="UTF-8">
            <title>.:CATEGORIA:.</title>
            <link rel="stylesheet" href="login_style.css">
            <link rel="stylesheet" href="estilo.css">
            <script src="redirect.js" language="javascript" type="text/javascript"></script>
    </head>
    <body id = "pagina">
        <div id="contenedor">
            <section id="content">
                <form action="/paronline/CategoriaProductoServlet" method="post">
                    <h1>Categorias</h1>
                    <div>
                        <input type="text" placeholder="Descripcion" id="username" name="descripcion" required/>
                    </div>
                    <div>
                        <input type="hidden" name="vaccion" value="GrabarNuevo"/>
                        <input type="submit" value="Registrar" />
                        <input type="button" value="Atras" onclick="javascript:ir_a_list_cat()"/>
                    </div>
                </form><!-- form -->
            </section><!-- content -->
        </div>
    </body>
</html>
