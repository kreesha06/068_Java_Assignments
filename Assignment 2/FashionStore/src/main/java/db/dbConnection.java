/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;
import java.sql.*;

/**
 *
 * @author root
 */
public class dbConnection {
    
    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(
               "jdbc:mysql://localhost:3306/fashion_store",
                    "root","root"
            );
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return null;
    }
}
