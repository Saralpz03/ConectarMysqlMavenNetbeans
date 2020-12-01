/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tpvmaven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Alexara
 */
public class Conexion {
    public static void main(String[] args) {
        String usuario="root";
        String clave="";
        String url="jdbc:mysql://localhost:3306/tpv";
        Connection con;
        Statement stmt;
        ResultSet rs;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(url,usuario,clave);
            System.out.println("Conexion exitosa");
            stmt=con.createStatement();
            rs=stmt.executeQuery("SELECT * FROM dependientes");
            while(rs.next()){
                System.out.println(rs.getInt("id_dependiente")+" "+rs.getString("nombre")+" "+rs.getString("password"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
