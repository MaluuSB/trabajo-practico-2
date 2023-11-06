<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Iniciar Sesion</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos_login.css">
    </head>
    <body>
        <h1>Iniciar Sesion</h1>
        <form name="j_security_form" method="post" action="j_security_check">
            <label for="user">Usuario</label>
            <input type="text" name="j_username" id="user" placeholder="Usuario"/>
            <label for="Password">Contraseña</label>
            <input type="password" name="j_password" id="Password" placeholder="Contraseña"/>                
            <button type="submit">Continuar</button>
        </form>
    </body>
</html>