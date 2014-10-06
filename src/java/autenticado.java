/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
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

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");
            out.println("<link rel=\"stylesheet\" href=\"//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css\">");
            out.println("</head>");
            out.println("<body>");

            /* TODO output your page here. You may use following sample code. */
            if ("logout".equals(logout)) {
                oSession.invalidate();
                out.println("<div class=\"container\">");
                out.println("<h2> Sesión Acabada </h2>");
                out.println("<a href=\"peticionUsuario.html\"> Volver al formulario</a>");
                out.println("</div>");
            }
            switch (usuario) {
                case "victor":
                    if ("vic123".equals(contraseña)) {

                        HashMap<String, Integer> existencias = new HashMap<String, Integer>();
                        HashMap<String, Integer> carrito = new HashMap<String, Integer>();

                        existencias.put("pulsera", 5);
                        existencias.put("gafas", 5);
                        existencias.put("cartera", 5);

                        carrito.put("pulsera", 0);
                        carrito.put("gafas", 0);
                        carrito.put("cartera", 0);

                        oSession.setAttribute("tienda", existencias);
                        oSession.setAttribute("carrito",carrito);

                        out.println("<div class=\"container\">");
                        out.println("<h2> Bienvenido " + usuario + "</h2>");
                        out.println("<a href=\"ZonaPrivada.jsp\"> ZONA PRIVADA</a> <br />");
                        out.println("<br />");
                        out.println("<a href=\"autenticado?logout=logout\"> LOGOUT</a>");
                        out.println("</div>");
                        oSession.setAttribute("UserUsuario", usuario);

                    } else {
                        out.println("<div class=\"container\">");
                        out.println("<h2> Lo siento, su contraseña es incorrecta, vuelva a intentarlo </h2>");
                        out.println("<a href=\"peticionUsuario.html\"> Volver..</a>");
                        out.println("</div>");
                    }
                    break;

                case "admin":
                    if ("admin".equals(contraseña)) {
                        out.println("<div class=\"container\">");
                        out.println("<h2> Bienvenido " + usuario + "</h2>");
                        out.println("<a href=\"ZonaPrivada.jsp\"> ZONA PRIVADA</a> <br />");
                        out.println("<a href=\"autenticado?logout=logout\"> LOGOUT</a>");
                        out.println("</div>");
                        oSession.setAttribute("UserUsuario", usuario);

                    } else {
                        out.println("<div class=\"container\">");
                        out.println("<h2> Lo siento, su contraseña es incorrecta, vuelva a intentarlo </h2>");
                        out.println("<a href=\"peticionUsuario.html\"> Volver..</a>");
                        out.println("</div>");
                    }
                    break;

                default:
                    out.println("<div class=\"container\">");
                    out.println("<h2> Lo siento, su Usuario no existe </h2>");
                    out.println("<a href=\"peticionUsuario.html\"> Volver..</a>");
                    out.println("</div>");

            }
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
