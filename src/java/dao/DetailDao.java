/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Util.DBHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Product;

/**
 *
 * @author rioxv
 */
public class DetailDao {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public Product getProductByID(String id){
        String stm = "select * from product where id = ?";
        try{
            conn = new DBHelper().getConnection();
            ps = conn.prepareStatement(stm);
            ps.setString(1,id);
            rs = ps.executeQuery();
            while(rs.next()){
                return new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(5),rs.getDouble(4),rs.getString(6));
            }
        }catch(Exception e){
        }  
        return null;
    }
}
