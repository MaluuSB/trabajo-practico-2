
package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;

@Table("tipo_usuario")
public class TipoUsuario extends Model{
    
    public static final String SISTEMA = "Sistema";
    public static final String ADMINISTRACION = "Administracion";
    
}
