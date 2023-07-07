/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author ADMIN
 */
public class DBConnection {
    
    private static Connection connection;
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Waseem2001*";
    private static final String DATABASE = "kurbookshop";
    
    private static Statement createConnection() throws Exception{
        
        if(connection == null){
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+DATABASE+"?useSSL=false",USERNAME,PASSWORD);
        }
        
        Statement statement = connection.createStatement();
        return statement;
        
    }
    
    public static void iud(String query){
        
        try{
            createConnection().executeUpdate(query);
        }catch (Exception e){
            e.printStackTrace();
        }
        
    }
    
    public static ResultSet search(String query) throws Exception{
        
        return createConnection().executeQuery(query);
        
    }
    
}
