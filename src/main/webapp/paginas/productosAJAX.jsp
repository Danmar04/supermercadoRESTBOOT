<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Productos</title>
</head>
<script>

xmlHttp = new XMLHttpRequest();

function buscarProducto(id){
	xmlHttp.open("GET","verProducto/"+id,true);
	xmlHttp.onreadystatechange = function(){
		if( this.readyState == 4 ){
			//alert(this.responseText);
			rellenarFormulario(JSON.parse(this.responseText));
		}		
	};
	xmlHttp.send(null);
}

function rellenarFormulario(producto){
	with(document.formulario){
		idProducto.value = producto.idProducto;
		idSupermercado.value = producto.supermercadoDTO;
		nombre.value   = producto.nombre;
		precio.value = producto.precio;
		cantidad.value = producto.cantidad;
		disponible.value = producto.disponible;
	}
}

function listarProductos(){
	xmlHttp.open("GET","listarProductos",true);
	xmlHttp.onreadystatechange = function(){
		if( this.readyState == 4 ){
			rellenarTabla(JSON.parse(this.responseText));
			xmlHttp.open("GET","listarSupermercados",true);
			xmlHttp.onreadystatechange = function(){
				if( this.readyState == 4 ){
					rellenarSelect(JSON.parse(this.responseText));
				}		
			};
			xmlHttp.send(null);
		}		
	};
	xmlHttp.send(null);
	
}

function rellenarTabla(productos){
	
	tabla = document.getElementById("tablaProductos");
	tabla.innerHTML = "";
	
	for(var a=0; a<productos.length; a++){
		
		p = productos[a];
		
		tr = document.createElement("tr");
		td1 = document.createElement("td");
		td2 = document.createElement("td");
		td3 = document.createElement("td");
		td4 = document.createElement("td");
		td5 = document.createElement("td");
		td6 = document.createElement("td");
		txt1 = document.createTextNode(p.idProducto);
		txt2 = document.createTextNode(p.nombre);
 		txt3 = document.createTextNode(p.precio);
 		txt4 = document.createTextNode(p.cantidad);
 		txt5 = document.createTextNode(p.disponible);
 		txt6 = document.createTextNode(p.supermercadoDTO);
		td1.appendChild(txt1);
		td2.appendChild(txt2);
 		td3.appendChild(txt3);
 		td4.appendChild(txt4);
 		td5.appendChild(txt5);
 		td6.appendChild(txt6);
		tr.appendChild(td1);
		tr.appendChild(td2);
 		tr.appendChild(td3);
 		tr.appendChild(td4);
 		tr.appendChild(td5);
 		tr.appendChild(td6);
		
		//Para la selección:
		atr = document.createAttribute("id");
		atr.value = p.idProducto;
		tr.setAttributeNode(atr);
		
		tr.onclick = function(){
			buscarProducto(this.id);
		}
		
		tabla.appendChild(tr);		
	}
}

function rellenarSelect(supermercados){
	
	selector = document.getElementById("selector-supermercado");
	selector.innerHTML = "";

	
	
	for(var a=0; a<supermercados.length; a++){
		
		p = supermercados[a];
		
		td1 = document.createElement("option");
		txt1 = document.createTextNode(p.idSupermercado + " - " + p.nombre);
		td1.appendChild(txt1);
		
		//Para la selección:
		atr = document.createAttribute("id");
		atr.value = p.idSupermercado;
		td1.setAttributeNode(atr);
		
		
		
		selector.appendChild(td1);		
	}

	selector.onclick = function(){
// 		console.log("Elijo " + this.options[this.selectedIndex].id);
		document.getElementById("idSupermercadoOculto").setAttribute("value",this.options[this.selectedIndex].id);
	}
}

function insertar(){
	with(document.formulario){
		producto = { 
				"nombre"   : 		nombre.value,
				 "supermercadoDTO": 	idSupermercadoOculto.value,
				 "precio" :			precio.value,
	             "cantidad":		cantidad.value,
	             "disponible":		disponible.checked
		         };
	}
	console.log(producto);
	
	xmlHttp.open("POST","/"+producto.supermercadoDTO+"/insertarProducto",true);
	xmlHttp.onreadystatechange = function(){
		if( this.readyState == 4 ){
			listarProductos();
		}		
	};
	xmlHttp.setRequestHeader("Content-Type", 
			                 "application/json;charset=UTF-8")
	xmlHttp.send(JSON.stringify(producto));	
}


function borrar(){
	xmlHttp.open("DELETE","borrarProducto/"+document.formulario.idProducto.value,true);
	xmlHttp.onreadystatechange = function(){
		if( this.readyState == 4 ){
			listarProductos();
			vaciar();
		}		
	};
	xmlHttp.send(null);
}
function modificar(){

	with(document.formulario){
		producto = { 
					"idProducto": idProducto.value,
					"nombre"   : 		nombre.value,
					 "supermercadoDTO": 	idSupermercado.value,
					 "precio" :			precio.value,
		             "cantidad":		cantidad.value,
		             "disponible":		disponible.checked
			         };
	}
	
	
	xmlHttp.open("PUT","actualizarProducto",true);
	xmlHttp.onreadystatechange = function(){
		if( this.readyState == 4 ){
			listarProductos();
		}		
	};
	xmlHttp.setRequestHeader("Content-Type", 
			                 "application/json;charset=UTF-8")
	xmlHttp.send(JSON.stringify(producto));	
}

function vaciar(){
	document.formulario.reset();

}


function filtrar(){
	nombreFiltro = document.getElementById("filtro-nombre").value;
	precioFiltro = document.getElementById("filtro-precio").value;
	cantidadFiltro = document.getElementById("filtro-cantidad").value;
	disponibleFiltro = document.getElementById("filtro-disponible").checked;
	mercadoFiltro = document.getElementById("filtro-mercado").value;

	hayFiltroPrevio = false;
	filtroCompleto = "";
	if(nombreFiltro!=""){
		filtroCompleto +=(hayFiltroPrevio? "&nombre="+nombreFiltro:"?nombre="+nombreFiltro);
	}
	if(precioFiltro!=""){
		filtroCompleto +=(hayFiltroPrevio? "&precio="+precioFiltro:"?precio="+precioFiltro);
	}
	if(cantidadFiltro!=""){
		filtroCompleto +=(hayFiltroPrevio? "&cantidad="+cantidadFiltro:"?cantidad="+cantidadFiltro);
	}
	if(disponibleFiltro!=""){
		filtroCompleto +=(hayFiltroPrevio? "&disponible="+disponibleFiltro:"?disponible="+disponibleFiltro);
	}
	if(mercadoFiltro!=""){
		filtroCompleto +=(hayFiltroPrevio? "&mercado="+mercadoFiltro:"?mercado="+mercadoFiltro);
	}
	

	xmlHttp.open("GET","filtrarProductos"+filtroCompleto,true);
	xmlHttp.onreadystatechange = function(){
		if( this.readyState == 4 ){
			rellenarTabla(JSON.parse(this.responseText));
			//xmlHttp.send(null);
		}		
	};
	xmlHttp.send(null);
	
}




</script>

<body onload="listarProductos()">

	<h1 align="center">
		Productos
	</h1>
	
	<form name="formulario">
	
		<p align="center">
			<input type="button" value="Insertar"  onclick="insertar()"/>
			<input type="button" value="Modificar" onclick="modificar()"/>
			<input type="button" value="Borrar"    onclick="borrar()"/>
			<input type="button" value="Vaciar"    onclick="vaciar()"/>
		</p>

		<input type="hidden" id="idProducto" name="idProducto"/>
		<input type="hidden" id="idSupermercadoOculto" name="idSupermercadoOculto">
	
		<table align="center">
			<tr>
				<td>Supermercado</td>
				<td>
<!-- 					<input type="hidden" id="idSupermercado"> -->
					<select id="selector-supermercado" name="selector-supermercado">
						 
					</select>
				</td>
			</tr>
			<tr>
				<td>Nombre</td>
				<td>
					<input type="text" id="nombre"/>
				</td>
			</tr>
			<tr>
				<td>Precio</td>
				<td>
					<input type="text" id="precio"/>
				</td>
			</tr>
			<tr>
				<td>Cantidad</td>
				<td>
					<input type="text" id="cantidad"/>
				</td>
			</tr>
			<tr>
				<td>Disponible</td>
				<td>
					<input type="checkbox" id="disponible"/>
				</td>
			</tr>
		</table>
		
		<p align="center">
		<input type="text" id="filtro-nombre" placeholder="Nombre?"/>
		<input type="text" id="filtro-precio" placeholder="Precio?"/>
		<input type="text" id="filtro-cantidad" placeholder="Cantidad?"/>
		<label>¿Disponible?</label>
		<input type="checkbox" id="filtro-disponible" placeholder="Disponible"/>
		<input type="text" id="filtro-mercado" placeholder="Supermercado?"/>
		</p>
		<p align="center">
		<input type="button" value="Buscar"  onclick="filtrar()"/></p>
		<table align="center" width="500px" border="1">
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Precio</th>
				<th>Cantidad</th>
				<th>Disponible</th>
				<th>Supermercado</th>
			</tr>
			<tbody id="tablaProductos"></tbody>
		</table>
	
	</form>


</body>
</html>
