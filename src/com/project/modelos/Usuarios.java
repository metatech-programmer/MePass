package com.project.modelos;

import java.util.Date;

public class Usuarios {

    private int codUsuario;
    private String documentoUsuario;
    private String nombresUsuario;
    private String apellidosUsuario;
    private Date fechaNacimientoUsuario;

    public Usuarios() {
    }

    public Usuarios(int codUsuario, String documentoUsuario, String nombresUsuario, String apellidosUsuario, Date fechaNacimientoUsuario) {
        this.codUsuario = codUsuario;
        this.documentoUsuario = documentoUsuario;
        this.nombresUsuario = nombresUsuario;
        this.apellidosUsuario = apellidosUsuario;
        this.fechaNacimientoUsuario = fechaNacimientoUsuario;
    }

    public Usuarios(String toString) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }


    public String getDocumentoUsuario() {
        return documentoUsuario;
    }

    public void setDocumentoUsuario(String documentoUsuario) {
        this.documentoUsuario = documentoUsuario;
    }

    public String getNombresUsuario() {
        return nombresUsuario;
    }

    public void setNombresUsuario(String nombresUsuario) {
        this.nombresUsuario = nombresUsuario;
    }

    public String getApellidosUsuario() {
        return apellidosUsuario;
    }

    public void setApellidosUsuario(String apellidosUsuario) {
        this.apellidosUsuario = apellidosUsuario;
    }

    public Date getFechaNacimientoUsuario() {
        return fechaNacimientoUsuario;
    }

    public void setFechaNacimientoUsuario(Date fechaNacimientoUsuario) {
        this.fechaNacimientoUsuario = fechaNacimientoUsuario;
    }

    @Override
    public String toString() {
        return "Usuarios{" + "codUsuario=" + codUsuario  + ", documentoUsuario=" + documentoUsuario + ", nombresUsuario=" + nombresUsuario + ", apellidosUsuario=" + apellidosUsuario + ", fechaNacimientoUsuario=" + fechaNacimientoUsuario + '}';
    }


   

}
