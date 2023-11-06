<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${context_path}/css/estilos_lista.css">
    <title>Lista de Usuarios</title>
    <script>
        function confirmarEliminacion(id) {
            if (confirm('¿Está seguro de que desea eliminar este empleado?')) {
                // Si el usuario hace clic en "Aceptar", redirige a la URL de eliminación
                window.location.href = "${context_path}/usuario/borrarUsuario/" + id;
            }
        }
    </script>
</head>
<body>
    <h1>Lista de Usuarios</h1>
    <table class="tabla">
        <thead>
            <th>ID</th>
            <th>Nombre</th>
            <th>Apellido</th>
            <#if session.rolabm == true>
                <th>Operaciones</th>
            </#if>
        </thead>
    
        <tbody>
            <#list listaUsuarios as usuario>
                <tr>
                    <td>${usuario.id_usuario}</td>
                    <td>${usuario.nombre}</td>
                    <td>${usuario.apellido}</td>
                    <#if session.rolabm == true>
                        <td>
                            <a href="${context_path}/usuario/verMas/${usuario.id_usuario}"><button class="button">Ver Mas</button></a>
                            <a href="${context_path}/usuario/editar/${usuario.id_usuario}"><button class="button">Editar</button></a>
                            <a href="#" onclick="confirmarEliminacion(${usuario.id_usuario})"> <button class="button">Borrar</button> </a>
                        </td>
                    </#if>
                </tr>
            </#list>
        </tbody>
    </table>
    <#if session.rolabm == true>
        <a href="${context_path}/usuario/alta"><button class="button">Agregar Usuario</button></a>
    </#if>
</body>
</html>
