/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author worten
 */
public class autenticado extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String usuario = (String) request.getParameter("usuario");
            String contraseña = (String) request.getParameter("contraseña");
            String logout = (String) request.getParameter("logout");
            HttpSession oSession = request.getSession();


            /* TODO output your page here. You may use following sample code. */
            if("logout".equals(logout)){
                oSession.invalidate();
                out.println("<p> Sesión Acabada </p>");
                out.println("<a href=\"peticionUsuario.html\"> Volver al formulario</a>");
            }
            switch (usuario) {
                case "victor":
                    if ("vic123".equals(contraseña)) {
                        out.println("<p> Bienvenido " + usuario + "</p>");
                        out.println("<a href=\"ZonaPrivada.jsp\"> ZONA PRIVADA</a> <br />");
                        out.println("<a href=\"autenticado?logout=logout\"> LOGOUT</a>");
                        oSession.setAttribute("UserUsuario", usuario);

                    } else {
                        out.println("<p> Lo siento, su contraseña es incorrecta, vuelva a intentarlo </p>");
                        out.println("<a href=\"peticionUsuario.html\"> Volver..</a>");
                    }
                    break;

                case "admin":
                    if ("admin".equals(contraseña)) {
                        out.println("<p> Bienvenido " + usuario + "</p>");
                        out.println("<a href=\"ZonaPrivada.jsp\"> ZONA PRIVADA</a> <br />");
                        out.println("<a href=\"autenticado?logout=logout\"> LOGOUT</a>");
                        oSession.setAttribute("UserUsuario", usuario);

                    } else {
                        out.println("<p> Lo siento, su contraseña es incorrecta, vuelva a intentarlo </p>");
                        out.println("<a href=\"peticionUsuario.html\"> Volver..</a>");
                    }
                    break;

                default:
                    out.println("<p> Lo siento, su Usuario no existe </p>");
                    out.println("<a href=\"peticionUsuario.html\"> Volver..</a>");

            }

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
