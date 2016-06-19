<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
      <script src="funciones.js">
        </script>
</head>
<body>
	<form method="post">
         	<input type="text" id="idTipo" name="idTipo" placeholder="idTipo"/>
            <input type="text" id="nombre" name="nombre" placeholder="Nombre"/>
            <input type="text" id="descuento" name="descuento" placeholder="descuento"/>
            <input type="button" value="Insertar" onclick="javascript:InsertarCliente(idTipo.value, nombre.value, descuento.value)"/>
            <input type="button" value="ConsultarTodos" onclick="PacienteConsultaAll(nombre.value)"/>
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