<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>

xmlHttp = new XMLHttpRequest();

function buscarSupermercado(id){
	xmlHttp.open("GET","verSupermercado/"+id,true);
	xmlHttp.onreadystatechange = function(){
		if( this.readyState == 4 ){
			//alert(this.responseText);
			rellenarFormulario(JSON.parse(this.responseText));
		}		
	};
	xmlHttp.send(null);
}

function rellenarFormulario(supermercado){
	with(document.formulario){
		id.value = supermercado.idSupermercado;
		nombre.value   = supermercado.nombre;
		direccion.value = supermercado.direccion;
	}
}

function listarSupermercados(){
	xmlHttp.open("GET","listarSupermercados",true);
	xmlHttp.onreadystatechange = function(){
		if( this.readyState == 4 ){
			//alert(this.responseText);
			rellenarTabla(JSON.parse(this.responseText));
		}		
	};
	xmlHttp.send(null);
}

function rellenarTabla(supermercados){
	
	tabla = document.getElementById("tablaSupermercados");
	tabla.innerHTML = "";
	
	for(var a=0; a<supermercados.length; a++){
		
		p = supermercados[a];
		
		tr = document.createElement("tr");
		td1 = document.createElement("td");
		td2 = document.createElement("td");
		td3 = document.createElement("td");
		td4 = document.createElement("td");
		txt1 = document.createTextNode(p.idSupermercado);
		txt2 = document.createTextNode(p.nombre);
 		txt3 = document.createTextNode(p.direccion);
 		txt4 = document.createTextNode(p.listaProductos);
		td1.appendChild(txt1);
		td2.appendChild(txt2);
 		td3.appendChild(txt3);
 		td4.appendChild(txt4);
		tr.appendChild(td1);
		tr.appendChild(td2);
 		tr.appendChild(td3);
 		tr.appendChild(td4);
		
		//Para la selección:
		atr = document.createAttribute("id");
		atr.value = p.idSupermercado;
		tr.setAttributeNode(atr);
		
		tr.onclick = function(){
			buscarSupermercado(this.id);
		}
		
		tabla.appendChild(tr);		
	}
}

function insertar(){
	with(document.formulario){
		supermercado = { "idSupermercado"       : id.value,
				     "nombre"   : nombre.value,
		             "direccion" : direccion.value,
			         };
	}
	console.log(supermercado);
	
	xmlHttp.open("POST","insertarSupermercado",true);
	xmlHttp.onreadystatechange = function(){
		if( this.readyState == 4 ){
			listarSupermercados();
		}		
	};
	xmlHttp.setRequestHeader("Content-Type", 
			                 "application/json;charset=UTF-8")
	xmlHttp.send(JSON.stringify(supermercado));	
}


function borrar(){
	xmlHttp.open("DELETE","borrarSupermercado/"+document.formulario.id.value,true);
	xmlHttp.onreadystatechange = function(){
		if( this.readyState == 4 ){
			listarSupermercados();
			vaciar();
		}		
	};
	xmlHttp.send(null);
}
function modificar(){

	with(document.formulario){
		supermercado = { 
					 "idSupermercado"       : id.value,
				     "nombre"   : nombre.value,
		             "direccion" : direccion.value
			         };
	}
	
	
	xmlHttp.open("PUT","actualizarSupermercado",true);
	xmlHttp.onreadystatechange = function(){
		if( this.readyState == 4 ){
			listarSupermercados();
		}		
	};
	xmlHttp.setRequestHeader("Content-Type", 
			                 "application/json;charset=UTF-8")
	xmlHttp.send(JSON.stringify(supermercado));	
}

function vaciar(){
	document.formulario.reset();

}




</script>

<body onload="listarSupermercados()">

	<h1 align="center">
		Supermercados
	</h1>
	
	<form name="formulario">
	
		<p align="center">
			<input type="button" value="Insertar"  onclick="insertar()"/>
			<input type="button" value="Modificar" onclick="modificar()"/>
			<input type="button" value="Borrar"    onclick="borrar()"/>
			<input type="button" value="Vaciar"    onclick="vaciar()"/>
		</p>

		<input type="hidden" id="id" name="id"/>
	
		<table align="center">
			<tr>
				<td>Nombre</td>
				<td>
					<input type="text" id="nombre"/>
				</td>
			</tr>
			<tr>
				<td>Direccion</td>
				<td>
					<input type="text" id="direccion"/>
				</td>
			</tr>
		</table>

		<table align="center" width="500px" border="1">
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Direccion</th>
				<th>Productos</th>
			</tr>
			<tbody id="tablaSupermercados"></tbody>
		</table>
	
	</form>


</body>
</html>
