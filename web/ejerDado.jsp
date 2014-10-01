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
        <style>

            td{
                height: 150px;
                width: 150px;
                text-align: center;

            }
        </style>
    </head>
    <body>



        <%
            String usuario = (String) request.getSession().getAttribute("UserUsuario");
            if (usuario != null) {
        %>

        <div class="container">

            <h1>Bienvenido al juego del dado</h1> 


            <br />
            <br />
            <div>
                <table class="table table-bordered">
                    <tr>
                        <td id="1">1</td>
                        <td id="2">2</td>
                        <td id="3">3</td>
                        <td id="4">4</td>
                        <td id="5">5</td>
                        <td id="6">6</td>
                        <td id="7">7</td>
                        <td id="8">8</td>
                        <td id="9">9</td>
                        <td id="10">10</td>
                    </tr>
                    <tr>
                        <td id="20">20</td>
                        <td id="19">19</td>
                        <td id="18">18</td>
                        <td id="17">17</td>
                        <td id="16">16</td>
                        <td id="15">15</td>
                        <td id="14">14</td>
                        <td id="13">13</td>
                        <td id="12">12</td>
                        <td id="11">11</td>
                    </tr>
                </table>
            </div>

            <h1 id="idDado">0</h1>

            <input class="btn btn-primary" type="submit" id="lanzar" value="Lanzar Dado" name="Lanzar" />

            <br />
            <br />

            <div class="row">
                <div class="col-md-10 col-md-offset-10">
                    <a  class="btn btn-danger" href="autenticado?logout=logout"> LOGOUT</a>
                </div>
            </div>

        </div>
        <script type="text/javascript">
            posicionDado = 1;
            var ficha = document.getElementById(posicionDado).innerHTML = "<img src='https://cdn2.iconfinder.com/data/icons/function_icon_set/circle_green.png'>";


            $(document).ready(function () {
                $('#lanzar').click(function () {
                    $.ajax({
                        url: "/proyectoSesion/numeroRandom",
                        type: "GET",
                        async: false,
                        dataType: "json",
                        success: function (source) {
                            document.getElementById('idDado').innerHTML = source.resultado;
                            if ((posicionDado + source.resultado) <= 20) {
                                ficha = document.getElementById(posicionDado).innerHTML = "";
                                posicionDado += source.resultado;
                                ficha = document.getElementById(posicionDado).innerHTML = "<img src='https://cdn2.iconfinder.com/data/icons/function_icon_set/circle_green.png'>";

                            }
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
