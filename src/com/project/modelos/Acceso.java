
package com.project.modelos;


public class Acceso {
     private Usuarios codUsuario;
    private String correoAcceso;
    private String claveAcceso;

    public Acceso() {
    }

    public Acceso(Usuarios codUsuario, String correoAcceso, String claveAcceso) {
        this.codUsuario = codUsuario;
        this.correoAcceso = correoAcceso;
        this.claveAcceso = claveAcceso;
    }

    public Usuarios getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(Usuarios codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getCorreoAcceso() {
        return correoAcceso;
    }

    public void setCorreoAcceso(String correoAcceso) {
        this.correoAcceso = correoAcceso;
    }

    public String getClaveAcceso() {
        return claveAcceso;
    }

    public void setClaveAcceso(String claveAcceso) {
        this.claveAcceso = claveAcceso;
    }

    @Override
    public String toString() {
        return "Acceso{" + "codUsuario=" + codUsuario + ", correoAcceso=" + correoAcceso + ", claveAcceso=" + claveAcceso + '}';
    }


   

 

   

    
}
