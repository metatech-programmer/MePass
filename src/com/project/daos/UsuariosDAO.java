package com.project.daos;

import com.project.configuraciones.Conexion;
import com.project.interfaces.OperacionesBasicas;
import com.project.modelos.Usuarios;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuariosDAO extends Conexion implements OperacionesBasicas<Usuarios> {

    private String mySql;
    private PreparedStatement consulta;

    public UsuariosDAO() {
        
    }

    @Override
    public boolean agregar(Usuarios objetito) {
        try {
            mySql = "INSERT INTO usuarios ( documento_usuario, nombres_usuario, apellidos_usuario,fecha_nacimiento_usuario ) VALUES (?,?,?,?);";
            consulta = objConexion.prepareStatement(mySql);
            consulta.setObject(1, objetito.getDocumentoUsuario());
            consulta.setObject(2, objetito.getNombresUsuario());
            consulta.setObject(3, objetito.getApellidosUsuario());
            long milisegunditos = objetito.getFechaNacimientoUsuario().getTime();
            Date loMaximoMano = new Date(milisegunditos);
            consulta.setDate(4, loMaximoMano);

            int filitaAgregada = consulta.executeUpdate();
            objConexion.close();

            return filitaAgregada > 0;
        } catch (SQLException miErrorcito) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, miErrorcito);
            return false;
        }
    }

    @Override
    public boolean borrar(Usuarios objetito) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean actualizar(Usuarios objetito,Usuarios objetito2) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Usuarios> listadito(String orden, String correo, String clave) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

  
    
}
