<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="css/estilos.css"/>

</head>
<body>



	<div class="contenedor">
	
		<div class="cabecera">
			<tiles:insertAttribute name="cabecera"/>
		</div>
		
		<div class="menu">
			<tiles:insertAttribute name="menu"/>
		</div>
		
		<div class="cuerpo">
			<tiles:insertAttribute name="principal"/>
		</div>
		
		<div class="pie">
			<tiles:insertAttribute name="pie"/>
		</div>
		
	</div>

</body>
</html>