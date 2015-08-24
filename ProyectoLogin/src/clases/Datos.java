package clases;

/**
 * Created by walter on 24/08/15.
 */
public class Datos {

    public boolean validarUsuario(String usuario, String clave){
        if(usuario.equalsIgnoreCase("walter")&& clave.equals("123"))
            return true;
        else
            return false;

    }
}
