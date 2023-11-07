<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">  
        <title>500 - error del servidor</title>
    </head>
    <body>
        <h1>ERROR AL INGRESAR DATOS</h1>
        <p>Ha ocurrido un error de sistema al procesar datos ingresados</p>
        <h2>Detalles:</h2>
        <ul>
            <#list errores as error>
                    <li>${error}</li>
            </#list>
        </ul>
        <div class="button-container">
            <a class="button" href="${context_path}/usuario/listaUsuarios">Volver</a>
        </div>
    </body>
</html>



