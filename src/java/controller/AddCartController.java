/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.DetailDao;
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
import model.Product;

/**
 *
 * @author rioxv
 */
@WebServlet(name = "AddCartController", urlPatterns = {"/addCart"})
public class AddCartController extends HttpServlet {

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
        String id = request.getParameter("pid");
        DetailDao dDao = new DetailDao();
        Product p = dDao.getProductByID(id);
        HttpSession session = request.getSession();
        Cart c = new Cart();
        c.setId(p.getId());
        c.setName(p.getName());
        c.setImage(p.getImage());
        c.setQuantity(1);
        c.setPrice(p.getPrice());
        
        if(session.getAttribute("cartList") == null){
            ArrayList<Cart> listCart = new ArrayList<>();
            listCart.add(c);
            session.setAttribute("cartList", listCart);
            response.sendRedirect("home");
        }else{
            ArrayList<Cart> listCart = (ArrayList<Cart>) session.getAttribute("cartList");
            boolean check = false;
            for(Cart o : listCart){
                if(o.getId()== p.getId()){
                    o.setQuantity(o.getQuantity()+1);
                    check =true;               
                }
            }
            if(!check){
                listCart.add(c);
            }
            session.setAttribute("cartList", listCart);
            response.sendRedirect("home");
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
