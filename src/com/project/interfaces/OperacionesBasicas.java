
package com.project.interfaces;

import java.util.List;

public interface OperacionesBasicas<T> {
    
    public boolean agregar(T objetito);    
    
    public boolean borrar(T objetito);
    
    public boolean actualizar(T objetito , T objetito2);
    
    public List<T> listadito(String orden,String correo, String clave);
   
    
    
}
