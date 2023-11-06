package app.controllers;


import app.models.Usuario;
import java.util.List;
import java.util.Map;
import org.javalite.activeweb.AppController;
import org.javalite.activeweb.annotations.POST;
import org.javalite.common.JsonHelper;

public class UsuarioController extends AppController {

    public void listaUsuarios() {
        List<Usuario> usuarios = Usuario.obtenerUsuarios();
        view("listaUsuarios", usuarios);
    }

    public void verMas() {
        Integer idUsuario = Integer.valueOf(getId());
        Usuario buscado = Usuario.buscarUsuario(idUsuario);

        view("usuarioBuscado", buscado);
    }
    
    public void buscarUsuario() {
        int usuarioId = Integer.valueOf(getId());
        Usuario buscado = Usuario.buscarUsuario(usuarioId);
        respond(JsonHelper.toJsonString(buscado)).contentType("application/json");
    }

    public void alta() {

    }

    @POST
    public void altaUsuario() {
        Map parametros = params1st();
        List<String> errores = Usuario.validar(parametros,null);

        if(errores.isEmpty()){ 
            Usuario.nuevoUsuario(parametros);
            redirect(UsuarioController.class, "listaUsuarios");
        }else{
            view("errores",errores);
            render("/usuario/error").noLayout();
        }
    }

    public void editar() {
        Integer idUsuario = Integer.valueOf(getId());
        Usuario buscado = Usuario.buscarUsuario(idUsuario);

        view("usuarioBuscado", buscado);
    }

    @POST
    public void editarUsuario() {
        Map parametros = params1st();
        List<String> errores = Usuario.validar(parametros,null);

        if(errores.isEmpty()){ 
            Usuario.editarUsuario(parametros);
            redirect(UsuarioController.class, "listaUsuarios");
        }else{
            view("errores",errores);
            render("/usuario/error").noLayout();
        } 
    }
    
    public void borrarUsuario() {

        Usuario.borrarUsuario(Integer.valueOf(getId()));
        redirect(UsuarioController.class, "listaUsuarios");
    }

    public void error() {

    }

}
