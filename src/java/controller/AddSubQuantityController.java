/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Cart;

/**
 *
 * @author rioxv
 */
@WebServlet(name = "AddSubQuantityController", urlPatterns = {"/addSubQuantity"})
public class AddSubQuantityController extends HttpServlet {

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
        try {
            String action = request.getParameter("action");
            int id = Integer.parseInt(request.getParameter("id"));
            HttpSession session = request.getSession();

            ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute("cartList");

            if (action != null && id >= 1) {
                if (action.equals("add")) {
                    for (Cart o : cartList) {
                        if (o.getId() == id) {
                            int quantity = o.getQuantity();
                            quantity++;
                            o.setQuantity(quantity);
                            response.sendRedirect("showCart");
                        }
                    }
                }
                if (action.equals("sub")) {
                    for (Cart o : cartList) {
                        if (o.getId() == id && o.getQuantity() > 1) {
                            int quantity = o.getQuantity();
                            quantity--;
                            o.setQuantity(quantity);
                            break;
                        }
                    }
                    response.sendRedirect("showCart");
                }
            } else {
                response.sendRedirect("showCart");
            }

        } catch (Exception e) {
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
