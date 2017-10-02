/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Jhon Galvis
 */
public class Compromiso {

    public String tipo;
    public String idUsu;

    public Compromiso(String tipo, String idUsu) {
        this.tipo = tipo;
        this.idUsu = idUsu;
    }

    public Compromiso() {
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getIdUsu() {
        return idUsu;
    }

    public void setIdUsu(String idUsu) {
        this.idUsu = idUsu;
    }
    
    

}
