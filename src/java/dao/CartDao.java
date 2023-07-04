/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Util.DBHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Cart;

/**
 *
 * @author rioxv
 */
public class CartDao {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public double getTotalCartPrice(ArrayList<Cart> cartList){
        double sum = 0;
        try {
            String stm = "select price from product where id = ?";
            if (!cartList.isEmpty()) {
                for (Cart o : cartList) {
                    conn = new DBHelper().getConnection();
                    ps = conn.prepareStatement(stm);
                    ps.setInt(1, o.getId());
                    rs = ps.executeQuery();

                    while (rs.next()) {
                        sum += (rs.getDouble("price")*o.getQuantity());
                    }
                }
            }
        } catch (Exception e) {
        }
       
        return sum;
          
    }
    public static void main(String[] args) {
        CartDao cDao = new CartDao();
        ArrayList<Cart> cartList = new ArrayList<>();
        Cart c = new Cart();
        c.setId(2);
        c.setQuantity(1);
        cartList.add(c);
        double sum = cDao.getTotalCartPrice(cartList);
        System.out.println(sum+" "+ c.getQuantity());
    }
}
