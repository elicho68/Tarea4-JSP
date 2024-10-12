/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Empleado;

/**
 *
 * @author Elicho
 */
public class ar_empleado extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Empleado empleado;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ar_empleado</title>");
            out.println("</head>");
            out.println("<body>");
//            out.println("<h1>Servlet ar_empleado at " + request.getContextPath() + "</h1>");
            if("agregar".equals(request.getParameter("btn_agregar"))){
            empleado = new Empleado(request.getParameter("txt_codigo"),Integer.valueOf(request.getParameter("drop_sangre")),0,request.getParameter("txt_nombres"),request.getParameter("txt_apellidos"),request.getParameter("txt_direccion"),request.getParameter("txt_telefono"),request.getParameter("txt_fn"));
            if(empleado.agregar()>0){            
                 out.println("<h1>Ingreso Exitoso</h1>");
                 out.println("<a href='index.jsp'>Regresar</a>");
            }
            else {
            out.println("<h1>Error...</h1>");
            out.println("<a href='index.jsp'>Regresar</a>");
            }
            }

            
            //out.println("<h1>Ingreso Exitoso</h>");
            /*
            out.println("<p>"+ request.getParameter("txt_codigo") +"</p>");
            out.println("<p>"+ request.getParameter("txt_nombres") +"</p>");
            out.println("<p>"+ request.getParameter("txt_apellidos") +"</p>");
            out.println("<p>"+ request.getParameter("txt_direccion") +"</p>");
            out.println("<p>"+ request.getParameter("txt_telefono") +"</p>");
            out.println("<p>"+ request.getParameter("txt_fn") +"</p>");
            out.println("<p>"+ request.getParameter("drop_sangre") +"</p>");            
            */
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
