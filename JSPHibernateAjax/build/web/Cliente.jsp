<%-- 
    Document   : Cliente
    Created on : 12-jun-2016, 11:29:35
    Author     : xxcin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="funciones.js">
        </script>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form method="post">
            <input type="text" id="rut" name="rut" placeholder="Rut"/>
            <input type="text" id="nombre" name="nombre" placeholder="Nombre"/>
            <input type="text" id="apellido" name="apellido" placeholder="Apellido"/>
            <input type="button" value="Insertar" onclick="InsertarCliente(rut.value, nombre.value, apellido.value)"/>
            <input type="button" value="ConsultarTodos" onclick="ClienteConsultaAll(nombre.value)"/>
            <input type="submit" value="ConsultarTodos"/>
        </form>
        <table id="tableClient" border="1">
            <tr>
                <th>Nombres</th>
                <th>Apellidos</th>
            </tr>
        </table>
        <div id="divParcial"></div>
    </body>
</html>
