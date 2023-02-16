/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connexion3a18.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BKHmidi
 */
public class Myconnection {
    private String url="jdbc:mysql://localhost:3306/autoxpress";
    private String login="root";
    private String pwd="";
    private Connection cnx;
    private static Myconnection instance;
    
    public  Myconnection() {
        try{
       cnx= DriverManager.getConnection(url,login,pwd);
           System.out.println("connexion etablie!");
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
        
}
    
    
    public Connection getCnx(){
        return cnx;
    }

   public static Myconnection getInstance(){
   if(instance == null){
       instance= new Myconnection();
   }
   return instance;
   }


} 
  
    
    
    
    
    
    

