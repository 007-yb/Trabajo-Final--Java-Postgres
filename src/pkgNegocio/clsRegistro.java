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
public class clsRegistro {
    private String persona;
    private String hora;

    public clsRegistro() {
    }

    public clsRegistro(String persona, String hora) {
        this.persona = persona;
        this.hora = hora;
    }

    /**
     * @return the persona
     */
    public String getPersona() {
        return persona;
    }

    /**
     * @param persona the persona to set
     */
    public void setPersona(String persona) {
        this.persona = persona;
    }

    /**
     * @return the hora
     */
    public String getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(String hora) {
        this.hora = hora;
    }
    
    
}
