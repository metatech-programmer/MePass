package com.project.configuraciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private final String usuario;
    private final String clave;
    private final String url;
    private final String driver;
    protected Connection objConexion;

    public Conexion() {
     usuario = "poo2022";
        clave = "123456";

        url = "jdbc:postgresql://localhost:8096/bd_contrasenasGuardadas";
        driver = "org.postgresql.Driver";
        activar();
    }

    public void activar() {
        try {
            Class.forName(driver);  
            objConexion = DriverManager.getConnection(url, usuario, clave);
            System.out.println("Coenctadoo");
        } catch (ClassNotFoundException | SQLException miError) {
            System.out.println(miError);
        }
    }

}
