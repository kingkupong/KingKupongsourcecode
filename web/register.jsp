<%-- 
    Document   : registro
    Created on : 01-abr-2014, 14:47:55
    Author     : Axel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css">
        <title>Registro de Usuario</title>
    </head>
    <body>

        <form method="post" action="RegisterServlet" name="registro">
            Email <input name="email"><br>
            User: <input name="user"><br>
            Password: <input  type="password" name="password"><br>
            Password confirm: <input type="password" name="password2"><br>
            Country <input name="country"><br>
            State or Province: <input name="st"><br>
            <button>Enviar</button>
        </form>

    </body>
</html>
