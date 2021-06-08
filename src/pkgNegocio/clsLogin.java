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
public class clsLogin {
    private String correoe;
    private String clave;

    public clsLogin() {
    }

    public clsLogin(String correoe, String clave) {
        this.correoe = correoe;
        this.clave = clave;
    }

    /**
     * @return the correoe
     */
    public String getCorreoe() {
        return correoe;
    }

    /**
     * @param correoe the correoe to set
     */
    public void setCorreoe(String correoe) {
        this.correoe = correoe;
    }

    /**
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
    }
    
    
}
