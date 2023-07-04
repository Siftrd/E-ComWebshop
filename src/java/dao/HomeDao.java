package dao;


import Util.DBHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import model.Category;
import model.Product;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author rioxv
 */
public class HomeDao {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public List<Product> getAllProduct(){
        List<Product> list = new ArrayList<>();
        String stm = "select * from product";
        try{
            conn = new DBHelper().getConnection();
            ps = conn.prepareStatement(stm);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(5),rs.getDouble(4),rs.getString(6)));
            }
            
        }catch(Exception e){
        }
        
        return list;
    }
    
    public Product getLatestProduct(){
        String stm = "select top (1)* from product order by id  desc";
        try{
            conn = new DBHelper().getConnection();
            ps = conn.prepareStatement(stm);
            rs = ps.executeQuery();
            while(rs.next()){
                return new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(5),rs.getDouble(4),rs.getString(6));
            }
            
        }catch(Exception e){
        }
        return null;
    }
    
    
}
