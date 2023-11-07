
package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;

// Anotacion que indica que esta clase representa una tabla llamada "tipo_usuario" en la base de datos
@Table("tipo_usuario")
public class TipoUsuario extends Model{
    
    // Definicion de constantes para tipos de usuario
    public static final String SISTEMA = "Sistema";
    public static final String ADMINISTRACION = "Administracion";
    
}
