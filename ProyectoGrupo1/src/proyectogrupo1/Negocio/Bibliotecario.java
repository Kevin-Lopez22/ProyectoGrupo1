/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectogrupo1.Negocio;

/**
 *
 * @author Valery Vallejo
 */
public class Bibliotecario {
    private String ci;
    private String nombre;
    private String contrasenia;

    public Bibliotecario() {
        this.ci = "1723427348";
        this.nombre = "Juan Posso";
        this.contrasenia = "JP1234";
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
}
