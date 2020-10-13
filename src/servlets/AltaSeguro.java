package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Seguro;
import dominio.SeguroDAO;
import dominio.TipoSeguro;
import dominio.TipoSeguroDAO;

/**
 * Servlet implementation class AltaSeguro
 */
@WebServlet("/AltaSeguro")
public class AltaSeguro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    private Seguro seguro = new Seguro();
    private ArrayList<TipoSeguro> tipoSeguro = new ArrayList<TipoSeguro>();
    
       
    public AltaSeguro() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try
        {
	        request.setAttribute("resultMessage", "");
	        TipoSeguroDAO sDao = new TipoSeguroDAO();
	        tipoSeguro = sDao.getTiposSeguros();
	        
            if(request.getParameter("btnAceptar") != null)
            {
                seguro.setDescripcion( request.getParameter("txbDescripcion") );
                seguro.setCosto( Float.parseFloat(request.getParameter("txbCosto")) );
                seguro.setCostoMaximoAsegurado( Float.parseFloat(request.getParameter("txbCostoMaximo")) );
                seguro.setTipo(Integer.parseInt(request.getParameter("TiposSeguro")) );
                
                SeguroDAO data = new SeguroDAO();
                if( data.newSeguro(seguro) > 0 )
                {
                    request.setAttribute("resultMessage", "Seguro creado correctamente");
                }
            }
        }
        catch(NumberFormatException ne)
        {
            request.setAttribute("resultMessage", "Algúno de los campos no se completó de manera correcta o tiene un formato incorrecto");
        }
        catch(Exception e)
        {
            request.setAttribute("resultMessage", "Hubo un error al dar de alta el seguro");
        }
        finally{}
	    
	    RequestDispatcher requestDispatcher = request.getRequestDispatcher("AgregarSeguro.jsp");
	    requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
