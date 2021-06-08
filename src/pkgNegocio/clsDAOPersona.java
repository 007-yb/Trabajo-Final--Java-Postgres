/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgNegocio;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import pkgDatos.clsConecta;

/**
 *
 * @author amartinez
 */
public class clsDAOPersona extends clsPersona {

    pkgDatos.clsConecta con;

    public clsDAOPersona() {
        con = new clsConecta();
    }

    public boolean insertar() {
        String SQL = "INSERT INTO administrador.tbl_Libro(id_, nombre,genero,autor) VALUES ('" + super.getId() + "','" + super.getNombre() + super.getAutor() + super.getGenero() + "')";
        return con.procesarSQL(SQL);
    }

    public void borrar() {
        String SQL = "DELETE FROM administrador.tbl_Libro WHERE id='" + super.getId() + "'";
        con.procesarSQL(SQL);
    }

    public boolean modificar(){
        String SQL = "UPDATE administrador.tbl_Libro SET nombre='" + super.getNombre() + "UPDATE administrador.tbl_Libro SET genero='" + super.getGenero()+ "UPDATE administrador.tbl_Libro SET autor='" + super.getAutor()+ "' WHERE id='" + super.getId() + "'";
        return con.procesarSQL(SQL);
    }

    public String consultar() {
        String SQL = "SELECT id, nombre, genero, autor FROM administrador.tbl_Libro WHERE id='" + super.getId() + "'";
        java.sql.ResultSet hr = null;
        hr = con.consultarSQL(SQL);
        try {
            if (hr.next()) {
                return hr.getString(2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(clsDAOPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "no";
    }

    public javax.swing.table.DefaultTableModel listar(JTable tbl) {
        javax.swing.table.DefaultTableModel modelo;
        modelo = new DefaultTableModel(new Object[]{tbl.getColumnName(0), tbl.getColumnName(1)}, 0);

        String SQL = "SELECT id, nombre, genero, autor FROM administrador.tbl_Libro";
        java.sql.ResultSet res =null;

        res = con.consultarSQL(SQL);

        try {
            while (res.next()) {
                modelo.addRow(new Object[]{res.getString(1), res.getString(2), res.getString(3), res.getString(4)});
            }
        } catch (SQLException ex) {
            System.out.println("Error consultando para listar");
        }
        return modelo;
    }
    
    /**
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    public javax.swing.DefaultComboBoxModel listarCombo() {
        javax.swing.DefaultComboBoxModel modelo;
        modelo = new javax.swing.DefaultComboBoxModel();

        String SQL = "SELECT id, nombre,genero,autor FROM administrador.tbl_Libro";
        java.sql.ResultSet res = null;

        res = con.consultarSQL(SQL);

        try {
            while (res.next()) {
                modelo.addElement(res.getString(4));
            }
        } catch (SQLException ex) {
            System.out.println("Error consultando para listar en combo");
        }
        return modelo;
    }
}
