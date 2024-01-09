
package com.project.modelos;

/**
 *
 * @author santi
 */
public class ContrasenasGuardadas {
    private Integer codContraGuard;
     private Acceso codUsuario;
    private String nombrePagina;
    private String url;
    private String nombreUsuario;
    private String contrasenasGuardadas;
    
    public ContrasenasGuardadas() {
    }

    public ContrasenasGuardadas(Integer codContraGuard, Acceso codUsuario, String nombrePagina, String url, String nombreUsuario, String contrasenasGuardadas) {
        this.codContraGuard = codContraGuard;
        this.codUsuario = codUsuario;
        this.nombrePagina = nombrePagina;
        this.url = url;
        this.nombreUsuario = nombreUsuario;
        this.contrasenasGuardadas = contrasenasGuardadas;
    }

    public Integer getCodContraGuard() {
        return codContraGuard;
    }

    public void setCodContraGuard(Integer codContraGuard) {
        this.codContraGuard = codContraGuard;
    }

    public Acceso getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(Acceso codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getNombrePagina() {
        return nombrePagina;
    }

    public void setNombrePagina(String nombrePagina) {
        this.nombrePagina = nombrePagina;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenasGuardadas() {
        return contrasenasGuardadas;
    }

    public void setContrasenasGuardadas(String contrasenasGuardadas) {
        this.contrasenasGuardadas = contrasenasGuardadas;
    }

    @Override
    public String toString() {
        return "ContrasenasGuardadas{" + "codContraGuard=" + codContraGuard + ", codUsuario=" + codUsuario + ", nombrePagina=" + nombrePagina + ", url=" + url + ", nombreUsuario=" + nombreUsuario + ", contrasenasGuardadas=" + contrasenasGuardadas + '}';
    }

 


}
