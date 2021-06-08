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
public class clsDAOLogin extends clsLogin{
    pkgDatos.clsConecta con;
  
    public clsDAOLogin() {
        con = new pkgDatos.clsConecta();
    }
    
    public boolean valideLogin(){
        String SQL="SELECT correoe, clave FROM administrador.tbl_login WHERE correoe='"+super.getCorreoe()+"' AND clave='"+super.getClave()+"';";
        return con.validar(SQL);
    }
    
}
