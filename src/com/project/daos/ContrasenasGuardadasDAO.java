package com.project.daos;

import com.project.configuraciones.Conexion;
import com.project.interfaces.OperacionesBasicas;
import com.project.modelos.ContrasenasGuardadas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author santi
 */
public class ContrasenasGuardadasDAO extends Conexion implements OperacionesBasicas<ContrasenasGuardadas> {

    private String mySql;
    private PreparedStatement consulta;

    public ContrasenasGuardadasDAO() {
    }

    @Override
    public boolean agregar(ContrasenasGuardadas objetito) {
        try {
            mySql = "INSERT INTO contrasenasGuardadas (cod_usuario, nombre_pagina , url , nombre_usuario , contrasena ) VALUES ( (SELECT cod_usuario FROM accesos WHERE correo_acceso = ? AND clave_acceso = ?),?,?,?,?);";
            consulta = objConexion.prepareStatement(mySql);
            consulta.setObject(1, objetito.getCodUsuario().getCorreoAcceso());
            consulta.setObject(2, objetito.getCodUsuario().getClaveAcceso());
            consulta.setObject(3, objetito.getNombrePagina());
            consulta.setObject(4, objetito.getUrl());
            consulta.setObject(5, objetito.getNombreUsuario());
            consulta.setObject(6, objetito.getContrasenasGuardadas());

            int filitaAgregada = consulta.executeUpdate();
            objConexion.close();

            return filitaAgregada > 0;
        } catch (SQLException miErrorcito) {
            Logger.getLogger(ContrasenasGuardadasDAO.class.getName()).log(Level.SEVERE, null, miErrorcito);
            return false;
        }
    }

    @Override
    public boolean borrar(ContrasenasGuardadas objetito) {

        try {
            mySql = "DELETE FROM contrasenasGuardadas WHERE  nombre_pagina = ? AND url = ?  AND nombre_usuario = ? AND contrasena = ?  AND cod_usuario  IN (SELECT cod_usuario FROM accesos WHERE correo_acceso LIKE ? AND clave_acceso LIKE ? );";
            consulta = objConexion.prepareStatement(mySql);
            consulta.setString(1, objetito.getNombrePagina());
            consulta.setString(2, objetito.getUrl());
            consulta.setString(3, objetito.getNombreUsuario());
            consulta.setString(4, objetito.getContrasenasGuardadas());
            consulta.setString(5, objetito.getCodUsuario().getCorreoAcceso());
            consulta.setString(6, objetito.getCodUsuario().getClaveAcceso());

            int filitaPalami = consulta.executeUpdate();
            objConexion.close();

            return filitaPalami > 0;
        } catch (SQLException miErrorcito) {
            Logger.getLogger(ContrasenasGuardadasDAO.class.getName()).log(Level.SEVERE, null, miErrorcito);
            return false;
        }
    }

    @Override
    public boolean actualizar(ContrasenasGuardadas objetito, ContrasenasGuardadas objetito2) {
        try {
            mySql = "UPDATE contrasenasGuardadas SET  url = ?  , nombre_usuario = ? , contrasena = ?  WHERE nombre_pagina = ? AND url = ?  AND nombre_usuario = ? AND contrasena = ? AND cod_usuario IN (SELECT cod_usuario FROM accesos WHERE correo_acceso LIKE ? AND clave_acceso LIKE ? );";

            consulta = objConexion.prepareStatement(mySql);
            consulta.setString(1, objetito.getUrl());
            consulta.setString(2, objetito.getNombreUsuario());
            consulta.setString(3, objetito.getContrasenasGuardadas());
            consulta.setString(4, objetito.getNombrePagina());
            consulta.setString(5, objetito2.getUrl());
            consulta.setString(6, objetito2.getNombreUsuario());
            consulta.setString(7, objetito2.getContrasenasGuardadas());
            consulta.setString(8, objetito.getCodUsuario().getCorreoAcceso());
            consulta.setString(9, objetito.getCodUsuario().getClaveAcceso());

            int filitaNueva = consulta.executeUpdate();
            objConexion.close();

            return filitaNueva > 0;
        } catch (SQLException miErrorcito) {
            Logger.getLogger(ContrasenasGuardadasDAO.class.getName()).log(Level.SEVERE, null, miErrorcito);
            return false;
        }
    }

    @Override
    public List<ContrasenasGuardadas> listadito(String orden, String correo, String clave) {

        try {
            ResultSet rs;
            List<ContrasenasGuardadas> arreglocontasinas = new ArrayList<>();
            if (orden.isEmpty()) {
                orden = "nombre_pagina ASC;";
            }
            mySql = "SELECT  cod_numero_contra , nombre_pagina  , url  , nombre_usuario , contrasena   FROM contrasenasGuardadas WHERE cod_usuario IN (SELECT cod_usuario FROM accesos WHERE correo_acceso LIKE '" + correo + "' AND clave_acceso LIKE'" + clave + "' ) ORDER BY " + orden;

            consulta = objConexion.prepareStatement(mySql);

            rs = consulta.executeQuery();
            while (rs.next()) {
                ContrasenasGuardadas miObjetitoContrasenaGuard = new ContrasenasGuardadas();

                miObjetitoContrasenaGuard.setCodContraGuard(Integer.parseInt(rs.getObject(1).toString()));
                miObjetitoContrasenaGuard.setNombrePagina(rs.getObject(2).toString());
                miObjetitoContrasenaGuard.setUrl(rs.getObject(3).toString());
                miObjetitoContrasenaGuard.setNombreUsuario(rs.getObject(4).toString());
                miObjetitoContrasenaGuard.setContrasenasGuardadas(rs.getObject(5).toString());
                arreglocontasinas.add(miObjetitoContrasenaGuard);

            }

            objConexion.close();
            return arreglocontasinas;

        } catch (NumberFormatException | SQLException miErrorcito) {
            Logger.getLogger(ContrasenasGuardadasDAO.class
                    .getName()).log(Level.SEVERE, null, miErrorcito);
            return null;
        }

    }

    public List<ContrasenasGuardadas> listadito2(String orden, String palabra, String correo, String clave) {

        try {
            ResultSet rs;
            List<ContrasenasGuardadas> arreglocontasinas = new ArrayList<>();
            if (orden.isEmpty()) {
                orden = "nombre_pagina ASC;";
            }
            mySql = "SELECT cod_numero_contra, nombre_pagina , url , nombre_usuario  , contrasena   FROM contrasenasGuardadas WHERE cod_usuario IN (SELECT cod_usuario FROM accesos WHERE correo_acceso LIKE '" + correo + "' AND clave_acceso LIKE '" + clave + "') AND  nombre_pagina LIKE  '%" + palabra + "%' ORDER BY " + orden;
            consulta = objConexion.prepareStatement(mySql);

            rs = consulta.executeQuery();
            while (rs.next()) {
                ContrasenasGuardadas miObjetitoContrasenaGuard = new ContrasenasGuardadas();

                miObjetitoContrasenaGuard.setCodContraGuard(Integer.parseInt(rs.getObject(1).toString()));
                miObjetitoContrasenaGuard.setNombrePagina(rs.getObject(2).toString());
                miObjetitoContrasenaGuard.setUrl(rs.getObject(3).toString());
                miObjetitoContrasenaGuard.setNombreUsuario(rs.getObject(4).toString());
                miObjetitoContrasenaGuard.setContrasenasGuardadas(rs.getObject(5).toString());
                arreglocontasinas.add(miObjetitoContrasenaGuard);
            }
            objConexion.close();
            return arreglocontasinas;

        } catch (NumberFormatException | SQLException miErrorcito) {
            Logger.getLogger(ContrasenasGuardadasDAO.class
                    .getName()).log(Level.SEVERE, null, miErrorcito);
            return null;
        }

    }

}
