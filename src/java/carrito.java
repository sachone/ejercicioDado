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
public class carrito extends HttpServlet {

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

            HttpSession oSession = request.getSession();
            String usuSesion = (String) oSession.getAttribute("usuario");

            if (usuSesion == null || usuSesion.length() == 0) {
                out.print("<br />Lo siento no puedes entrar");
                out.print("<br /><a href=\"peticionUsuario.html\" > Volver </a>");
            } else {

                Integer stock = 0;
                Integer reservas = 0;
                Integer cantidad;
                String producto = request.getParameter("Componentes");

                if (request.getParameter("Cantidad").equalsIgnoreCase("")) {
                    cantidad = 0;
                } else {
                    cantidad = Integer.parseInt(request.getParameter("Cantidad"));
                }

                HashMap<String, Integer> productosTienda = (HashMap) oSession.getAttribute("tienda");
                HashMap<String, Integer> productosCarrito = (HashMap) oSession.getAttribute("carrito");

                switch (producto) {
                    case "pulsera":

                        stock = productosTienda.get("pulsera");
                        reservas = productosCarrito.get("pulsera");

                        if ((stock - cantidad) >= 0) {
                            productosTienda.put("pulsera", stock - cantidad);
                            productosCarrito.put("pulsera", reservas + cantidad);
                        }
                        break;
                    case "hdd":
                        stock = productosTienda.get("hdd");
                        reservas = productosCarrito.get("hdd");

                        if ((stock - cantidad) >= 0) {
                            productosTienda.put("hdd", stock - cantidad);
                            productosCarrito.put("hdd", reservas + cantidad);
                        }
                        break;
                    case "ssd":

                        stock = productosTienda.get("ssd");
                        reservas = productosCarrito.get("ssd");
                        if ((stock - cantidad) >= 0) {
                            productosTienda.put("ssd", stock - cantidad);
                            productosCarrito.put("ssd", reservas + cantidad);
                        }
                        break;
                    default:
                        break;
                }
                if (producto != "" || producto != null) {
                    oSession.setAttribute("tienda", productosTienda);
                    oSession.setAttribute("carrito", productosCarrito);
                }
                response.sendRedirect("/ProyectoHolaMundo/Sesiones/CarritoCompra.jsp");
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
