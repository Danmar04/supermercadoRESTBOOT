<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<form:form name="formulario" action="mostrarProductos.htm" commandName="producto" method="post">
	
	<form:hidden path="idProducto"/>
	<table align="center">
			<tr>
<%-- 				<td><spring:message code="producto_nombre"/></td> --%>
				<td>nombre</td>
				<td>
					<form:input path="nombre"/>
					<form:errors path="nombre"/>
				</td>			
			</tr>
			<tr>
<%-- 				<td><spring:message code="producto_precio"/></td> --%>
				<td>precio</td>
				<td>
					<form:input path="precio"/>
					<form:errors path="precio"/>
				</td>			
			</tr>
			<tr>
<%-- 				<td><spring:message code="producto_cantidad"/></td> --%>
				<td>cantidad</td>
				<td>
					<form:input path="cantidad"/>
					<form:errors path="cantidad"/>
				</td>			
			</tr>
			<tr>
<%-- 				<td><spring:message code="producto_disponible"/></td> --%>
				<td>DISPONIBLE</td>
				<td>
					<form:checkbox path="disponible"/>
					<form:errors path="disponible"/>
				</td>			
			</tr>
		</table>
		<p align="center">
			<input type="submit" onclick="document.formulario.action='crearProducto.htm'"  value='Insertar'/>
			<input type="submit" onclick="document.formulario.action='actualizarProducto.htm'" value="Actualizar"/>
		</p>
		
	
		<form:hidden path="idProducto"/>

		<table align="center" border="1">
		<tr>
<%-- 			<th><spring:message code="producto_nombre"/></th> --%>
<%-- 			<th><spring:message code="producto_precio"/></th> --%>
<%-- 			<th><spring:message code="producto_cantidad"/></th> --%>
<%-- 			<th><spring:message code="producto_disponible"/></th> --%>
				<th>NOMBRE</th>
				<th>PRECIO</th>
				<th>CANTIDAD</th>
				<th>DISPONIBLE</th>
			
		</tr>
		<c:forEach var="c" items="${listadoProductos}">
			<tr>
				<td>
					${c.idProducto}-${c.nombre}
				</td>
				<td>${c.precio}</td>
				<td>${c.cantidad}</td>
				<td>${c.disponible}</td>
				<td><input type="submit" onclick="document.formulario.action='seleccionarProducto.htm?idProducto=${c.idProducto}'"   value='MODIFICAR'/></td>
				<td><input type="submit" onclick="document.formulario.action='borrarProducto.htm?idProducto=${c.idProducto}'"   value='BORRAR'/></td>
				
			</tr>		
		</c:forEach>	
	</table>
	</form:form>
	

</body>
</html>