/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import BBDD.tables.Usuario;
import BBDD.utilities.UserManagement;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mushi
 */

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
protected void processRequest(HttpServletRequest request, HttpServletResponse response)
		 throws ServletException, IOException {	
	 String userId = request.getParameter("userId");	
	 String password = request.getParameter("password");
	 Usuario user = UserManagement.loginUsuario(userId, password);
         boolean result;
         if (user!=null){
             result=true;
         }else{
             result=false;
         }
	 if(result == true){
		 request.getSession().setAttribute("user", user);		
		 response.sendRedirect("index.jsp");
	 }
	 else{
		 response.sendRedirect("login.jsp");
	 }
}
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
		 throws ServletException, IOException {
	 processRequest(request, response);
}
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
		 throws ServletException, IOException {
	 processRequest(request, response);
}
@Override
public String getServletInfo() {
	 return "Short description";

    }// </editor-fold>
}
