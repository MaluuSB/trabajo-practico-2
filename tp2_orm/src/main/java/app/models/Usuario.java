package app.models;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.BelongsTo;
import org.javalite.activejdbc.annotations.IdName;
import org.javalite.activejdbc.annotations.Table;

// Esta anotacion indica que la clase representa una tabla llamada "usuario" en la base de datos
@Table("usuario")
// Indica que el campo que sirve como clave primaria se llama "id_usuario"
@IdName("id_usuario")
// Indica que esta clase tiene una relacion de pertenencia con la clase TipoUsuario por el campo "id_tipo_usuario"
@BelongsTo(foreignKeyName = "id_tipo_usuario", parent = TipoUsuario.class)
public class Usuario extends Model {

    // Metodo para obtener una lista de usuarios ordenados por "fecha_alta"
    public static List<Usuario> obtenerUsuarios() {

        return Usuario.findAll().orderBy("fecha_alta");
    }

    // Metodo para crear un nuevo usuario a partir de un mapa de parametros
    public static void nuevoUsuario(Map<String, String> parametros) {
        
        Usuario nuevo = new Usuario();
        
        // Configura los atributos del nuevo usuario con los valores del mapa "parametros"
        nuevo.set("nombre", parametros.get("nombre"));
        nuevo.set("apellido", parametros.get("apellido"));
        nuevo.set("alias", parametros.get("alias"));
        nuevo.set("contrasenia", parametros.get("contrasenia"));
        nuevo.set("email_principal", parametros.get("email_principal"));
        nuevo.set("email_secundario", parametros.get("email_secundario"));
        nuevo.set("numero_celular", parametros.get("numero_celular"));
        nuevo.set("id_tipo_usuario", Integer.valueOf(parametros.get("tipo_usuario")));
        
        // Obtiene la fecha actual y la asigna como valor para "fecha_alta"
        Date fecha = new Date();
        nuevo.setTimestamp("fecha_alta", fecha.getTime());
        
        // Guarda el nuevo usuario en la base de datos
        nuevo.saveIt();
    }

    // Metodo para buscar un usuario por su ID
    public static Usuario buscarUsuario(int usuarioId) {
        
        return Usuario.findById(usuarioId);
    }

    // Metodo para eliminar un usuario por su ID
    public static void borrarUsuario(int idUsuario) {

        Usuario.delete("id_usuario = ?", idUsuario);
    }

     // Metodo para editar un usuario a partir de un mapa de parametros
    public static void editarUsuario(Map<String, String> parametros) {

        // Busca el usuario que se va a editar por su ID
        Usuario editado = Usuario.findById(Integer.valueOf(parametros.get("id")));

        // Actualiza los atributos del usuario editado con los valores del mapa "parametros"
        editado.set("nombre", parametros.get("nombre")).saveIt();
        editado.set("apellido", parametros.get("apellido")).saveIt();
        editado.set("alias", parametros.get("alias")).saveIt();
        editado.set("contrasenia", parametros.get("contrasenia")).saveIt();
        editado.set("email_principal", parametros.get("email_principal")).saveIt();
        editado.set("email_secundario", parametros.get("email_secundario")).saveIt();
        editado.set("numero_celular", parametros.get("numero_celular")).saveIt();
        editado.set("id_tipo_usuario", Integer.valueOf(parametros.get("tipo_usuario"))).saveIt(); 
    }
    
    // Metodo para validar los datos del usuario y devuelve una lista de errores si los datos no son validos
    public static LinkedList<String> validar(Map<String, String> valores, Integer idUsuario){
        LinkedList<String> errores = new LinkedList<>();
        List<Usuario> usuarios;
        
        if(idUsuario != null)
            // Si se proporciona un ID de usuario, obtiene todos los usuarios excepto el que tiene ese ID
            usuarios = Usuario.where("id_usuario <> ? ", idUsuario);
        else
             // Si no se proporciona un ID de usuario, obtiene todos los usuarios
            usuarios = Usuario.findAll();
        
        // Expresiones regulares para validar diferentes campos
        String regexNombreApellido = "^[A-ZÑa-zñ ]{3,}$";
        String regexAlias = "^[A-Za-z0-9_-]{3,}$";
        String regexEmail = "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$";
        String regexContrasenia = "^[A-Za-z0-9_-]{7,16}$";
        String regexCelular = "^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{3,6}$";
        
        // Validaciones de los campos agregando mjs de error a la lista si los datos no cumplen con las reglas
        if( valores.get("nombre") == null  || !valores.get("nombre").matches(regexNombreApellido))
            errores.add("Nombre debe tener al menos 3 caracteres y contener solo letras");
        
        if( valores.get("apellido") == null  || !valores.get("apellido").matches(regexNombreApellido))
            errores.add("Apellido debe tener al menos 3 caracteres y contener solo letras");
        
        if( valores.get("alias") == null  || !valores.get("alias").matches(regexAlias))
            errores.add("Alias debe tener al menos 3 caracteres y puede contener letras, numeros, guiones bajos y guiones");
        
        if(valores.get("email_principal") == null  || !valores.get("email_principal").matches(regexEmail))
            errores.add("El formato del correo electronico principal es incorrecto");
        
        for(Usuario usuarioBuscando : usuarios){
            if(usuarioBuscando.get("alias").equals(valores.get("alias")))
                errores.add("El alias ya esta en uso por otro usuario");
            
            if(usuarioBuscando.get("email_principal").equals(valores.get("email_principal")))
                errores.add("El correo electronico principal ya esta en uso por otro usuario");
        }
        
        if(valores.get("email_secundario") == null  || !valores.get("email_secundario").matches(regexEmail))
            errores.add("El formato del correo electronico secundario es incorrecto");
        
        if(valores.get("email_secundario").equals(valores.get("email_principal")))
            errores.add("El correo electronico secundario no puede ser igual al correo electronico principal");
        
        if(valores.get("contrasenia") == null  || !valores.get("contrasenia").matches(regexContrasenia))
            errores.add("Contraseña debe tener entre 7 y 16 caracteres, puede contener letras, numeros, guiones y guiones bajos");
        
        if(valores.get("numero_celular") == null  || !valores.get("numero_celular").matches(regexCelular))
            errores.add("Numero de celular debe tener entre 9 y 12 digitos y seguir un formato valido");
        
        if(valores.get("tipo_usuario") == null  || (!valores.get("tipo_usuario").equals("1") && !valores.get("tipo_usuario").equals("2")))
            errores.add("Tipo de usuario debe ser 'Sistema' o 'Administracion'");
        
        return errores;
    }

}
