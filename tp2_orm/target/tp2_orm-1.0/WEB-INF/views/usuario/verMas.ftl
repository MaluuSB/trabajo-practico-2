<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${context_path}/css/estilos_vermas.css">
    <title>Datos Usuario</title>
</head>
<body>
    <h1>Datos Usuario</h1>
    <div class="contenedor_vermas">
        <div class="left-data">
            <div class="data-box">ID</div>
            <div class="data-box">NOMBRE</div>
            <div class="data-box">APELLIDO</div>
            <div class="data-box">ALIAS</div>
            <div class="data-box">CONTRASEÑA</div>
            <div class="data-box">E-MAIL PRINCIPAL</div>
            <div class="data-box">E-MAIL SECUNDARIO</div>
            <div class="data-box">NUMERO CELULAR</div>
            <div class="data-box">TIPO USUARIO</div>
            <div class="data-box">FECHA ALTA</div>
            <div class="data-box">FECHA BAJA</div>
        </div>
        <div class="right-data">
            <div class="data-box">${usuarioBuscado.id_usuario}</div>
            <div class="data-box">${usuarioBuscado.nombre}</div>
            <div class="data-box">${usuarioBuscado.apellido}</div>
            <div class="data-box">${usuarioBuscado.alias}</div>
            <div class="data-box">${usuarioBuscado.contrasenia}</div>
            <div class="data-box">${usuarioBuscado.email_principal}</div>
            <div class="data-box">${usuarioBuscado.email_secundario}</div>
            <div class="data-box">${usuarioBuscado.numero_celular}</div>

            <div class="data-box">
                <#if usuarioBuscado.id_tipo_usuario == 1>
                    Sistema
                <#else>
                    Administracion
                </#if> 
                
            </div>

            <div class="data-box">${usuarioBuscado.fecha_alta}</div>
            <div class="data-box"> <#if usuarioBuscado.fecha_baja?exists>
                                    ${usuarioBuscado.fecha_baja}
                                    <#else>
                                        ---
                                    </#if> </div>
        </div>
    </div>
    <div class="button-container_vermas">
        <a href="${context_path}/usuario/listaUsuarios">Volver</a>
    </div>
</body>
</html>
