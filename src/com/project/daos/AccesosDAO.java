package com.project.daos;

import com.project.configuraciones.Conexion;
import com.project.interfaces.OperacionesBasicas;
import com.project.modelos.Acceso;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccesosDAO extends Conexion implements OperacionesBasicas<Acceso> {

    private String mySql;
    private PreparedStatement consulta;

    public AccesosDAO() {
    }

    @Override
    public boolean agregar(Acceso objetito) {
        try {
            mySql = "INSERT INTO accesos (cod_usuario , correo_acceso, clave_acceso ) VALUES ( (SELECT cod_usuario FROM usuarios WHERE documento_usuario = ? AND nombres_usuario = ? AND apellidos_usuario = ?),?,?);";
            consulta = objConexion.prepareStatement(mySql);
            consulta.setObject(1, objetito.getCodUsuario().getDocumentoUsuario());
            consulta.setObject(2, objetito.getCodUsuario().getNombresUsuario());
            consulta.setObject(3, objetito.getCodUsuario().getApellidosUsuario());
            consulta.setObject(4, objetito.getCorreoAcceso());
            consulta.setObject(5, objetito.getClaveAcceso());

            int filitaAgregada = consulta.executeUpdate();
            objConexion.close();

            return filitaAgregada > 0;
        } catch (SQLException miErrorcito) {
            Logger.getLogger(AccesosDAO.class.getName()).log(Level.SEVERE, null, miErrorcito);
            return false;
        }
    }

    @Override
    public boolean borrar(Acceso objetito) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

    }

    @Override
    public boolean actualizar(Acceso objetito, Acceso objetito2) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

    }

    @Override
    public List<Acceso> listadito(String orden, String correo, String clave) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean verificarUsuarios(String orden, Acceso objetito) {
        boolean banderita;
        banderita = false;
        try {
            ResultSet rs;
            List<Acceso> arregloAccesos = new ArrayList<>();
            if (orden.isEmpty()) {
                orden = "cod_usuario";
            }
            mySql = "SELECT cod_usuario FROM usuarios "
                    + "WHERE cod_usuario IN (SELECT cod_usuario FROM accesos "
                    + "WHERE correo_acceso=? AND clave_acceso=?);";
            consulta = objConexion.prepareStatement(mySql);
            consulta.setObject(1, objetito.getCorreoAcceso());
            consulta.setObject(2, objetito.getClaveAcceso());

            rs = (ResultSet) consulta.executeQuery();

            while (rs.next()) {
                
                banderita = true;
            }
            objConexion.close();
            return banderita;

        } catch (NumberFormatException | SQLException miErrorcito) {
            Logger.getLogger(AccesosDAO.class.getName()).log(Level.SEVERE, null, miErrorcito);
            return false;
        }

    }
}
