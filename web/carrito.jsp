<%-- 
    Document   : carrito
    Created on : 06-oct-2014, 12:56:11
    Author     : worten
--%>


<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<%
    HttpSession oSession = request.getSession();
    String usuario = (String) oSession.getAttribute("usuario");

%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css">

    </head>
    <body>
        <%  
            if (usuario != null) {
        %>

        <h1>NO PUEDES ESTAR AQUI!!!</h1><br />
        <br /><a href="Ejer1.html" > Volver </a>
        <%
        } else {

            HashMap<String, Integer> tienda = (HashMap) oSession.getAttribute("tienda");
            HashMap<String, Integer> carrito = (HashMap) oSession.getAttribute("carrito");

        %>

        <div class="header col-md-10 col-sm-10 col-md-offset-1 col-sm-offset-1">
            <ul class="nav nav-pills pull-right">
                <li class="active"><a href="autenticado?logout=logout">Logout</a></li>
                
            </ul>
            <h3>Carrito de la compra</h3>
        </div>


        <div id="idExistencias" class="col-md-3 col-sm-3 col-md-offset-1 col-sm-offset-1">
            <form name="formularioTienda"  role="form" class="jumbotron">
                <fieldset>
                    <legend>Existencias</legend>
                    <ol>
                        <li>
                            <label for="idPulsera">Pulsera:</label>
                            <input type="text" id="idpendrive" class="form-control" 
                                   readonly="readonly"  value="<%=tienda.get("pendrive")%>"/>
                        </li>
                        <li>
                            <label for="idhdd">Discos HDD:</label>
                            <input type="text" id="idhdd" class="form-control" 
                                   readonly="readonly" value="<%=tienda.get("hdd")%>"/>
                        </li>
                        <li>
                            <label for="idssd">Discos SSD:</label>
                            <input type="text" id="idssd" class="form-control" 
                                   readonly="readonly"  value="<%=tienda.get("ssd")%>"/>
                        </li>
                    </ol><br/>
                </fieldset>
            </form>
        </div>


        <div id="idpedido" class="col-md-3 col-sm-3">
            <form name="formularioPedido" action="../CompraCarrito" method="get" 
                  role="form" class="jumbotron">

                <fieldset>
                    <legend>Pedido</legend>

                    <label for="idComponentes">Componente: </label> <br/>
                    <select id="idComponentes" name="Componentes">
                        <option value="" selected="selected">- selecciona -</option>
                        <option value="pendrive">Pen Drive</option>
                        <option value="hdd">Disco HDD</option>
                        <option value="ssd">Disco SSD</option>
                    </select>
                    <br/><br/>
                    <label for="idCantidad">Cantidad:</label>
                    <input type="text" id="idCantidad" name="Cantidad" value="0" class="form-control"/>
                    <br/>
                    <input id="enviar" name="Enviar" type="submit" value="Enviar" 
                           class="btn btn-primary"/><br/>
                </fieldset>
            </form>
        </div>

        <div id="idCarrito" class="col-md-3 col-sm-3">

            <form name="formularioPedido" action="" method="get" role="form" class="jumbotron">
                <fieldset>
                    <legend>Carrito</legend>

                    <ul>
                        <li>
                            <label for="idpendrive2">Pen Drives:</label>
                            <input type="text" id="idpendrive2" class="form-control" 
                                   readonly="readonly" value="<%=carrito.get("pendrive")%>"/>
                        </li>
                        <li>
                            <label for="idhdd2">Discos HDD:</label>
                            <input type="text" id="idhdd2" class="form-control" 
                                   readonly="readonly" value="<%=carrito.get("hdd")%>"/>
                        </li>
                        <li>
                            <label for="idssd2">Discos SSD:</label>
                            <input type="text" id="idssd2" class="form-control" 
                                   readonly="readonly" value="<%=carrito.get("ssd")%>"/>
                        </li>
                    </ul>

                    <input id="pagar" name="pagar" type="submit" value="Pagar" 
                           class="btn btn-primary col-md-offset-1 col-sm-offset-1"/>
                    <br/>
                </fieldset>
            </form>
        </div>




        <%
            }
        %>
    </body>
</html>
