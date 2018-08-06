/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaevolution;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class PruebaEvolution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            
            Connection cnx;
            
            Class.forName("com.mysql.jdbc.Driver");
            
            cnx = DriverManager.getConnection("jdbc:mysql://192.168.1.36/EVOLUTIONDB?useServerPrepStmts=true","NCADMIN","ADMN1cr@");
            
            //cnx = DriverManager.getConnection("jdbc:mysql://192.168.1.38/glm_dep?useServerPrepStmts=true","grupolotto","RTqEP5TPTOJN");
            //cnx = DriverManager.getConnection("jdbc:mysql://95.215.62.29/glm_dep?useServerPrepStmts=true","root","1Manager");
            PreparedStatement ps;
            ResultSet rs;
            
            ps=cnx.prepareStatement("select top 10 NOMBRE,APELLIDO1,APELLIDO2 from CLIENTES");
            
            rs=ps.executeQuery();
            
            while(rs.next()){
                
                System.out.println(rs.getString("NOMBRE") + " " + rs.getString("APELLIDO1") + " " + rs.getString("APELLIDO2"));
            }
            
            /*Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            cnx=DriverManager.getConnection("jdbc:odbc:conexservidor");*/
            cnx.setAutoCommit(false);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PruebaEvolution.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private static void pruebita(){
        
        
            
           
        
    }
    
}
