
package app.controllers;

import org.javalite.activeweb.AppController;

public class HomeController extends AppController{
    
    // Metodo para cargar la pagina de inicio y configurar las variables de sesion
    public void index(){
        
        String usuario = getHttpServletRequest().getRemoteUser();
        Boolean ver = getHttpServletRequest().isUserInRole("ver");
        Boolean abm = getHttpServletRequest().isUserInRole("abm");
        
        session("rolver", ver);
        session("rolabm",abm);
        session("usuario", usuario);
    }
    
    // Metodo para cerrar la sesion del usuario
    public void cerrarSesion(){
        session().invalidate();
        redirect(HomeController.class, "index");
    }
    
}
