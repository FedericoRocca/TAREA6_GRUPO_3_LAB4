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


@WebServlet("/servletSeguro")
public class servletSeguro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public servletSeguro() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("Param")!=null) {
			
			SeguroDAO sDao= new SeguroDAO();
			ArrayList<Seguro> lista=sDao.obtenerSeguro();
			
			request.setAttribute("listaS", lista);
			
		    RequestDispatcher rd = request.getRequestDispatcher("/ListarSeguros.jsp");   // S2 is the alias name of Product servlet

		    rd.forward(request, response);
			
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("btnFiltrar")!=null) {
			
			SeguroDAO sDao= new SeguroDAO();
			ArrayList<Seguro> lista=sDao.obtenerSeguro(Integer.parseInt(request.getParameter("TiposSeguro")));
			
			request.setAttribute("listaS", lista);
			
		    RequestDispatcher rd = request.getRequestDispatcher("/ListarSeguros.jsp");

		    rd.forward(request, response);
		}
	}

}
