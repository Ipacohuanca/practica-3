package com.emergente.controlador;
import com.emergentes.dao.AvisoDAO;
import com.emergentes.dao.AvisoDAOimpl;
import com.emergentes.modelo.Aviso;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "inicio", urlPatterns = {"/inicio"})
public class inicio extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            AvisoDAO dao = new AvisoDAOimpl();
            int id;
            Aviso avi = new Aviso();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {
                case "add":
                    request.setAttribute("aviso", avi);
                    request.getRequestDispatcher("frmaviso.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    avi = dao.getById(id);
                    System.out.println(avi);
                    request.setAttribute("aviso", avi);
                    request.getRequestDispatcher("frmaviso.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect(request.getContextPath() + "/inicio");
                    break;

                case "view":
                    List<Aviso> lista = dao.getAll();
                    request.setAttribute("productos", lista);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                default:
                    break;
            }
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String producto = request.getParameter("producto");
        String precio = request.getParameter("precio");
        String cantidad = request.getParameter("cantidad");

        Aviso avi = new Aviso();

        avi.setId(id);
        avi.setProducto(producto);
        avi.setPrecio(precio);
        avi.setCantidad(cantidad);

        if (id == 0){
            try {
                AvisoDAO dao = new AvisoDAOimpl();
                dao.insert(avi);
                response.sendRedirect(request.getContextPath() + "/inicio");
            } catch (Exception ex) {
                System.out.println("ERROR..!" + ex.getMessage());
            }
        }else{
            try {
                AvisoDAO dao = new AvisoDAOimpl();
                dao.update(avi);
                response.sendRedirect(request.getContextPath() + "/inicio");
            } catch (Exception ex) {
                System.out.println("ERROR..!" + ex.getMessage());
            }
        }
    }

}
