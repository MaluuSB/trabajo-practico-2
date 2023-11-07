package app.controllers;


import app.models.Usuario;
import java.util.List;
import java.util.Map;
import org.javalite.activeweb.AppController;
import org.javalite.activeweb.annotations.POST;
import org.javalite.common.JsonHelper;

public class UsuarioController extends AppController {

    // Metodo para listar los usuarios
    public void listaUsuarios() {
        List<Usuario> usuarios = Usuario.obtenerUsuarios();
        view("listaUsuarios", usuarios);
    }

    // Metodo para ver la informacion detallada de un usuario en especifico
    public void verMas() {
        Integer idUsuario = Integer.valueOf(getId());
        Usuario buscado = Usuario.buscarUsuario(idUsuario);

        view("usuarioBuscado", buscado);
    }
    
    // Metodo para buscar un usuario por ID y devolver sus datos en formato JSON
    public void buscarUsuario() {
        int usuarioId = Integer.valueOf(getId());
        Usuario buscado = Usuario.buscarUsuario(usuarioId);
        respond(JsonHelper.toJsonString(buscado)).contentType("application/json");
    }
    
    // Metodo para mostrar el formulario de alta de usuario
    public void alta() {

    }

    // Metodo para agregar un nuevo usuario a la base de datos
    @POST
    public void altaUsuario() {
        Map parametros = params1st();
        List<String> errores = Usuario.validar(parametros,null); 

        if(errores.isEmpty()){ 
            Usuario.nuevoUsuario(parametros);
            redirect(UsuarioController.class, "listaUsuarios"); 
        }else{
            view("errores",errores);
            render("/system/error-datos").noLayout();
        }
    }

    // Metodo para mostrar el formulario de edicion de usuario
    public void editar() {
        Integer idUsuario = Integer.valueOf(getId());
        Usuario buscado = Usuario.buscarUsuario(idUsuario);

        view("usuarioBuscado", buscado);
    }

    // Metodo para editar la informacion de un usuario existente
    @POST
    public void editarUsuario() {
        Map parametros = params1st();
        List<String> errores = Usuario.validar(parametros,null);

        if(errores.isEmpty()){ 
            Usuario.editarUsuario(parametros);
            redirect(UsuarioController.class, "listaUsuarios");
        }else{
            view("errores",errores);
            render("/system/error-datos").noLayout();
        } 
    }
    
    // Metodo para eliminar un usuario de la base de datos
    public void borrarUsuario() {

        Usuario.borrarUsuario(Integer.valueOf(getId()));
        redirect(UsuarioController.class, "listaUsuarios");
    }

}
