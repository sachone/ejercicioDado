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
        <h1>Bienvenido a la zona privada</h1>
        <a href="ejerDado.jsp"> Ir al Juego</a><br />
        <br />
        <br />
        <a href="peticionUsuario.html"> Volver al formulario..</a>

        <%
        } else {
        %>
        <h1> No tiene permiso para acceder aqui</h1>
        <a href=\"peticionUsuario.html\"> Volver al formulario..</a>
        <% }

        %>
    </body>
</html>