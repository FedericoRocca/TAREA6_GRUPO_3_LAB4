<%@page import="dominio.TipoSeguroDAO"%>
<%@page import="dominio.TipoSeguro"%>
<%@page import="dominio.SeguroDAO"%>
<%@page import="dominio.Seguro"%>
<%@page import="java.util.ArrayList"%>
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
	
	<%
		Seguro seguro = new Seguro();
		ArrayList<TipoSeguro> tipoSeguro = new ArrayList<TipoSeguro>();
		TipoSeguroDAO sDao = new TipoSeguroDAO();
		tipoSeguro = sDao.getTiposSeguros();
	%>
	
	<form method="get" action="/TAREA6_GRUPO_3_LAB4/AgregarSeguro.jsp">
		<table>
		<tbody>
		  <tr>
		    <td><label for="lblID">ID seguro</label></td>
		    <td><%=seguro.getId()%></td>
		  </tr>
		  <tr>
		    <td><label for="lblID">Descripción</label></td>
		    <td><input type="text" name="txbDescripcion"></td>
		  </tr>
		  <tr>
		    <td><label for="TiposSeguro">Tipo de seguro:</label></td>
		    <td>
			    <select name="TiposSeguro" id="selectTipos">
			  	<% 
					for (TipoSeguro ts:tipoSeguro)
					{
					    %><option value="<%=ts.getIdTipo()%>"><%=ts.getDescripcion()%></option><%
					}
			  	%>
				</select>
		    </td>
		  </tr>
		  <tr>
		    <td><label for="lblID">Costo de contratación</label></td>
		    <td><input type="text" name="txbCosto"></td>
		  </tr>
		  <tr>
		    <td><label for="lblID">Costo máximo asegurado</label></td>
		    <td><input type="text" name="txbCostoMaximo"></td>
		  </tr>
		  <tr>
		    <td><input type="submit" name="btnAceptar" value="Aceptar"></td>
		  </tr>
		</tbody>
		</table>
		
	</form>
	
	<%
		try
		{
		    if(request.getParameter("btnAceptar") != null)
			{
		        seguro.setDescripcion( request.getParameter("txbDescripcion") );
			    seguro.setCosto( Float.parseFloat(request.getParameter("txbCosto")) );
			    seguro.setCostoMaximoAsegurado( Float.parseFloat(request.getParameter("txbCostoMaximo")) );
			    seguro.setTipo(Integer.parseInt(request.getParameter("TiposSeguro")) );
			    
			    SeguroDAO data = new SeguroDAO();
			    if( data.newSeguro(seguro) > 0 )
			    {
			        %> Seguro creado exitosamente <%
			    }
			}
		}
		catch(NumberFormatException ne)
		{
		    %> Alguno de los campos no se completó correctamente <%
		}
		catch(Exception e)
		{
		    %> Hubo un error al dar de alta el seguro <%
		}
		finally{}
	%>
</body>
</html>