/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkgNegocio;

/**
 *
 * @author amartinez
 */
public class clsDAORegistro extends clsRegistro{
    pkgDatos.clsConecta con;

    public clsDAORegistro() {
        con = new pkgDatos.clsConecta();
    }
    
    public boolean registrar(){
        String SQL="INSERT INTO administrador.tbl_registro(persona, hora)VALUES ('"+super.getPersona()+"', '"+super.getHora()+"')";
        return con.procesarSQL(SQL);
    }
}
