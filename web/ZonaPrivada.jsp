<%-- 
    Document   : ZonaPrivada
    Created on : 29-sep-2014, 13:50:00
    Author     : worten
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css">

    </head>
    <body>
        <%
            String usuario = (String) request.getSession().getAttribute("UserUsuario");
            if (usuario != null) {
        %>
        <div class="container">

            <h1>Zona privada</h1>

            <br />

            <blockquote>
                <a  class="btn btn-success" href="ejerDado.jsp"> Juego del dado</a>
                <br />
                <br />
                <a  class="btn btn-success" href="carrito.jsp"> Carrito de la compra</a>
                <br />
                <br />

                <a class="btn btn-danger" href="peticionUsuario.html"> Volver al formulario..</a>
            </blockquote>


        </div>

        <%
        } else {
        %>
        <div class="container">
            <h1> No tiene permiso para acceder aqui</h1>
            <a href="peticionUsuario.html"> Volver al formulario..</a>
        </div>
        <% }

        %>
    </body>
</html>