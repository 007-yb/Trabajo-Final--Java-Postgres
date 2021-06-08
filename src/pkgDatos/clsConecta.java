/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkgDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author amartinez
 */
public class clsConecta {
    java.sql.Connection con;// 1. Para cargar el Driver de JDBC para Postgres
    java.sql.Statement st; // 2. Para conectarse con el Motor
    java.sql.ResultSet res; // 3. Procesar las consultas (información)
 
    Connection conecta=null; 
    public clsConecta() {
        try {
            try {
                Class.forName("org.postgresql.Driver"); // Carga el drive
                System.out.println("Driver Correcto");
            } 
            catch (ClassNotFoundException ex) {
                System.out.println("Error cargando el Driver");
            }
            
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/base", "postgres", "admin");
        } catch (SQLException ex) {
            System.out.println("No se pudo conectar con el Motor");
        }
    }
    
    public boolean validar(String sql){
        // JDBC
        java.sql.ResultSet hoja_resultado=null;
        try { 
            st=con.createStatement(); // Se conecta con el motor
            hoja_resultado=st.executeQuery(sql);
            return hoja_resultado.next(); // Si los datos correctos
            // No está registro en la base de datos
        } catch (SQLException ex) {
            System.out.println("Error consultando: "+ex.toString());
            return false;
        }
    }
    
    public boolean procesarSQL(String SQL){
        try { 
            st=con.createStatement();
            return st.execute(SQL);
        } catch (SQLException ex) {
            System.out.println("Problema con el SQL "+ex.toString());
            return false;
        }
    }
    
    public java.sql.ResultSet consultarSQL(String SQL){
        try { 
            st=con.createStatement();
            return st.executeQuery(SQL);
        } catch (SQLException ex) {
            System.out.println("Problema con el SQL "+ex.toString());
            return null;
        }
    }
    
}
