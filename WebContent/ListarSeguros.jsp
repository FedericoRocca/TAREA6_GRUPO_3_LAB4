<%@ page import="dominio.Seguro" %>
<%@page import="dominio.TipoSeguroDAO"%>
<%@page import="dominio.TipoSeguro"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TP6 Lab IV, Grupo 3</title>
</head>
<body>
	<a href="/TAREA6_GRUPO_3_LAB4/Inicio.jsp" style="margin-right: 5px">Inicio</a>
	<a href="/TAREA6_GRUPO_3_LAB4/AgregarSeguro.jsp" style="margin-right: 5px">Agregar seguro</a>
	<a href="servletSeguro?Param=1" style="margin-right: 5px">Listar seguros</a>
	
	<%
		ArrayList<TipoSeguro> tipoSeguro = new ArrayList<TipoSeguro>();
		TipoSeguroDAO sDao = new TipoSeguroDAO();
		tipoSeguro = sDao.getTiposSeguros();
	%>
	
	<br/>
	<br/>
	<strong>Seguros</strong>
	<br/>
	<br/>
	<form method="post" action="servletSeguro">
		Busqueda por tipo de Seguros: 
	    <select name="TiposSeguro" id="selectTipos">
	  	<% 
			for (TipoSeguro ts:tipoSeguro)
			{
			    %><option value="<%=ts.getIdTipo()%>"><%=ts.getDescripcion()%></option><%
			}
	  	%>
		</select>
		<input type="submit" name="btnFiltrar" value="Filtrar">	
	</form>
	<br/>
	<br/>
	<%
		ArrayList<Seguro>listaSeguros=null;
		if(request.getAttribute("listaS")!=null){
			
			listaSeguros=(ArrayList<Seguro>)request.getAttribute("listaS");
			
		}
	%>
	
	<table border="1">
	
		<tr><th>ID Seguro</th><th>Descripcion Seguro</th><th>Descripcion tipo seguro</th><th>Costo contratacion</th><th>Costo maximo asegurado</th></tr>
		<%
			if(listaSeguros!=null)
			for(Seguro seg : listaSeguros){	
		%>	
			<tr><td><%=seg.getId() %></td><td><%=seg.getDescripcion() %></td><td><%=seg.getDescripcionTipoSeguro() %></td><td><%=seg.getCosto() %></td><td><%=seg.getCostoMaximoAsegurado() %></td></tr>
		
		<%	
				}
		%>
	</table>
	
</body>
</html>