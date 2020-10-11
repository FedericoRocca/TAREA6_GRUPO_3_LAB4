<%@page import="dominio.SeguroDAO"%>
<%@page import="dominio.Seguro"%>
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
	<a href="/TAREA6_GRUPO_3_LAB4/ListarSeguros.jsp" style="margin-right: 5px">Listar seguros</a>
	
	<form method="get">
		<label for="lblID">ID seguro</label><br/>
		<label for="lblID">Descripción</label> <input type="text" name="txbDescripcion"><br/>
		<label for="lblID">Tipo de seguro</label> <input type="text" name=""><br/>
		<label for="lblID">Costo de contratación</label> <input type="text" name="txbCosto"><br/>
		<label for="lblID">Costo máximo asegurado</label> <input type="text" name="txbCostoMaximo"><br/>
		<input type="submit" name="btnAceptar" value="Aceptar">
	</form>
	
	<%
		if(request.getParameter("btnAceptar") != null)
		{
		    Seguro seguro = new Seguro();
		    seguro.setDescripcion( request.getParameter("txbDescripcion") );
		    seguro.setCosto( Float.parseFloat(request.getParameter("txbCosto")) );
		    seguro.setCostoMaximoAsegurado( Float.parseFloat(request.getParameter("txbCostoMaximo")) );
		    //seguro.setTipo(Integer.parseInt(request.getParameter("txbCosto")) );
		    
		    SeguroDAO data = new SeguroDAO();
		    data.newSeguro(seguro);
		}
	%>
</body>
</html>