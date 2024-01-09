package com.project.utilidades;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Seguridad {

    public static String obtenerHash(String clavePlanita, String pizcalDeSal) {

        String claveCifrada;

        try {
            MessageDigest objClave = MessageDigest.getInstance("SHA-512");
            objClave.update(pizcalDeSal.getBytes(StandardCharsets.UTF_8));
            byte[] bytes = objClave.digest(clavePlanita.getBytes(StandardCharsets.UTF_8));
            StringBuilder arregloString = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                arregloString.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            claveCifrada = arregloString.toString();

        } catch (NoSuchAlgorithmException e) {
            claveCifrada = null;
        }
        return claveCifrada;
    }

}
