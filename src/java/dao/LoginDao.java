/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Util.DBHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Account;

/**
 *
 * @author rioxv
 */
public class LoginDao {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public Account login(String user, String pass){
        String stm = "select * from Account where [user]= ? and [pass] = ?";
        try{
            conn = new DBHelper().getConnection();
            ps = conn.prepareStatement(stm);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while(rs.next()){
                return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
            }
            
        }catch(Exception e){
        }
        
        return null;
    }
}
