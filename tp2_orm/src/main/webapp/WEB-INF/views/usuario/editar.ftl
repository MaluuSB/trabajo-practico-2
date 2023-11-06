<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${context_path}/css/estilos_formulario.css">
    <title>Editar Usuario</title>

</head>
<body>
    <h1>Editar Usuario</h1>
    <form method="POST" action="${context_path}/usuario/editarUsuario/${usuarioBuscado.id_usuario}" onsubmit="return validarDatosUsuario()">
        
        <input type="text" class="" name="nombre" id="nombre" placeholder="Nombre" value="${usuarioBuscado.nombre}" required>
        <span style="color: green; font-size: 18px; display: none;" class="mensaje-exito" id="mensaje-nombre">Nombre Bien!</span>
        

        <input type="text" name="apellido" id="apellido" placeholder="Apellido" value="${usuarioBuscado.apellido}" required>
        <span style="color: green; font-size: 18px; display: none;" class="mensaje-exito" id="mensaje-apellido">Apellido Bien!</span>

    
        <input type="text" name="alias" id="alias" placeholder="Alias" value="${usuarioBuscado.alias}" required>
        <span style="color: green; font-size: 18px; display: none;" class="mensaje-exito" id="mensaje-alias">Alias Bien!</span>


        <input type="password" name="contrasenia" id="contrasenia" placeholder="Contraseña" value="${usuarioBuscado.contrasenia}" required>
        <span style="color: green; font-size: 18px; display: none;" class="mensaje-exito" id="mensaje-contrasenia">Contrasenia Bien!</span>


        <input type="text" name="email_principal" id="email_principal" placeholder="E-mail Principal"  value="${usuarioBuscado.email_principal}" required>
        <span style="color: green; font-size: 18px; display: none;" class="mensaje-exito" id="mensaje-email1">Email Principal Bien!</span>
        

        <input type="text" name="email_secundario" id="email_secundario" placeholder="E-mail Secundario" value="${usuarioBuscado.email_secundario}" required>
        <span style="color: green; font-size: 18px; display: none;" class="mensaje-exito" id="mensaje-email2">Email Secundario Bien!</span>


        <input type="text" name="numero_celular" id="numero_celular" placeholder="Numero Celular" value="${usuarioBuscado.numero_celular}" required>
        <span style="color: green; font-size: 18px; display: none;" class="mensaje-exito" id="mensaje-celular">Celular Bien!</span>


        <select name="tipo_usuario" id="tipo_usuario" value="${usuarioBuscado.id_usuario}" required>
            <option value="1" <#if "1" == "${usuarioBuscado.id_tipo_usuario}"> selected </#if> >Sistema</option>
            <option value="2" <#if "2" == "${usuarioBuscado.id_tipo_usuario}"> selected </#if> >Administracion</option>
        </select>
        <span style="color: green; font-size: 18px; display: none;" class="mensaje-exito" id="mensaje-tipo">Tipo Usuario Bien!</span>


        <input type="submit" value="Editar">
        <div class="button-container">
            <a class="button" href="${context_path}/usuario/listaUsuarios">Volver</a>
        </div>
    </form>
    
    
    <script src="${context_path}/js/validacionUsuario.js"></script>
</body>
</html>
