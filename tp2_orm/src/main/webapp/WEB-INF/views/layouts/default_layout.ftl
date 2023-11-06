<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="${context_path}/css/estilos.css">
        <title>TP2</title>
    </head>
    
    <body>
        <header>
            <div class="usuario"> <p>${session.usuario}</p> </div>
            <a href="${context_path}/home/cerrarSesion" class="cerrar-sesion-btn">Cerrar Sesion</a>
        </header>
        <div class="contenido">
            ${page_content}
        </div>
    </body>
</html>