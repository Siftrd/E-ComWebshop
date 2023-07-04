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
import java.util.List;
import model.Product;

/**
 *
 * @author rioxv
 */
public class ManageProductDao {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Product> getProductBySellerID(int ID) {
        List<Product> list = new ArrayList<>();
        String stm = "select * from product where sell_ID = ?";
        try {
            conn = new DBHelper().getConnection();
            ps = conn.prepareStatement(stm);
            ps.setInt(1, ID);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(5), rs.getDouble(4), rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void deleteProduct(String pid) {
        String stm = "delete from product where id = ?";
        try {
            conn = new DBHelper().getConnection();
            ps = conn.prepareStatement(stm);
            ps.setString(1, pid);
            ps.executeUpdate();

        } catch (Exception e) {
        }
    }

    public void addProduct(String name, String image, String price, String title, String description, String category, int sid) {
        String stm = "INSERT [dbo].[product] \n"
                + "([name], [image], [price], [title], [description], [cateID], [sell_ID]) \n"
                + "VALUES (?,?,?,?,?,?,?)";
        try {
            conn = new DBHelper().getConnection();
            ps = conn.prepareStatement(stm);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setString(3, price);
            ps.setString(4, title);
            ps.setString(5, description);
            ps.setString(6, category);
            ps.setInt(7, sid);
            ps.executeUpdate();

        } catch (Exception e) {
        }
    }

    public void editProduct(String name, String image, String price, String title, String description, String category, String id) {
        String stm = "update product set [name] = ?,image = ?,price = ?, title =?,[description] = ?,cateID = ? where id = ? ";
        try {
            conn = new DBHelper().getConnection();
            ps = conn.prepareStatement(stm);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setString(3, price);
            ps.setString(4, title);
            ps.setString(5, description);
            ps.setString(6, category);
            ps.setString(7, id);
            ps.executeUpdate();

        } catch (Exception e) {
        }
    }
}
