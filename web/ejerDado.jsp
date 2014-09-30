<%-- 
    Document   : ejerDado
    Created on : 29-sep-2014, 18:39:00
    Author     : al037542
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>juego dado</title>
    </head>
    <body>



        <%
            String usuario = (String) request.getSession().getAttribute("UserUsuario");
            if (usuario != null) {
        %>

        
        <h1>Bienvenido al juego</h1>
        <div id="numeroaleatorio"></div>
        <input type="submit" id="lanzar" value="Lanzar Dado" name="Lanzar" /><br />
        <br />
        <br />
        <a href="autenticado?logout=logout"> LOGOUT</a>

        <% String logout = (String) request.getParameter("logout");
            HttpSession oSession = request.getSession();

            if ("logout".equals(logout)) {
                oSession.invalidate();%>
        <p> Sesión Acabada </p>
        <a href="peticionUsuario.html"> Volver al formulario</a>

        <%}%>

        <script type="text/javascript">
            $(document).ready(function () {
                $('#lanzar').click(function () {
                    $.ajax({
                        url: "/proyectoSesion/numeroRandom",
                        type: "GET",
                        async: false,
                        dataType: "json",
                        success: function (source) {
                            document.getElementById('numeroaleatorio').innerHTML = source.resultado;
                        }
                    });
                });
            });


        </script><%
        } else {%>
        <h1> Lo siento, no puedes acceder </h1>
        <a href="peticionUsuario.html"> Volver al formulario</a>
        <%  }
        %>


    </body>
</html>
