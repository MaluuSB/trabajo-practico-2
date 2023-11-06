<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">  
        <title>Error</title>
    </head>
    <body>
        <h1>ERROR</h1>
        <p>ERRORES detectados</p>
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



