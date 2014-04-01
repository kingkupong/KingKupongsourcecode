<%-- 
    Document   : login
    Created on : 01-abr-2014, 11:12:19
    Author     : Mushi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">	
	 <link rel="stylesheet" type="text/css" href="style.css">
	 <title>Login Page</title>
</head>
<body>
<center>
	 <div>
		 <form id="form" name="form" method="post" action="LoginServlet">
			 <h1>Login</h1>
			 <p>Por favor logueate 
				 <br/>¿Usuario Nuevo? <a href="register.jsp">¡Regístrate</a></p>
			 <label>
				 <span>Correo</span>
			 </label>
			 <input type="text" name="userId" placeholder="ejemplo1234@ex.com" id="userId" />
                         <br  />
			 <label>Password
				 
			 </label>
			 <input type="password" name="password" placeholder="*******" id="password" />
                         <br />
			 <button type="submit">Sign-in</button>
		 </form>
	 </div>
</center>
</body>
</html>
