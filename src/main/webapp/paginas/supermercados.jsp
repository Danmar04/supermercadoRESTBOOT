<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form:form name="formulario" action="mostrarSupermercados.htm" commandName="supermercado" method="post">
	
	<form:hidden path="idSuper"/>
	<table align="center">
			<tr>
				<td>Nombre</td>
				<td>
					<form:input path="nombre"/>
					<form:errors path="nombre"/>
				</td>			
			</tr>
			<tr>
				<td>Direccion</td>
				<td>
					<form:input path="direccion"/>
					<form:errors path="direccion"/>
				</td>			
			</tr>
		</table>
		<p align="center">
			<input type="submit" onclick="document.formulario.action='crearSupermercado.htm'"  value='Insertar'/>
			<input type="submit" onclick="document.formulario.action='actualizarSupermercado.htm'" value='Actualizar'/>
		</p>
		
	
		<form:hidden path="idSuper"/>

		<table align="center" border="1">
		<tr>
			<th>Nombre</th>
			<th>Direccion</th>
			
		<c:forEach var="c" items="${listadoSupermercados}">
			<tr>
				<td>
					<a href="verProducto.htm?idProducto=${c.idSuper}">${c.nombre}</a>
				</td>
				<td>${c.direccion}</td>
				<td><a href="verProductos.htm?idSupermercado=${c.idSuper}">Productos</a></td>
				<td><input type="submit" onclick="document.formulario.action='seleccionarProducto.htm?idSuper=${c.idSuper}'"   value='Modificar'/></td>
				<td><input type="submit" onclick="document.formulario.action='borrarProducto.htm?idSuper=${c.idSuper}'"   value='Borrar'/></td>
				
			</tr>		
		</c:forEach>	
	</table>
	</form:form>
	

</body>
</html>