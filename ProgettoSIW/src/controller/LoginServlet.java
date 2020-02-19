package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(value = "/LoginServlet")
public class LoginServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		            
        String name=req.getParameter("username");  
        String password=req.getParameter("password");  
          
        resp.sendRedirect("ottieniIndex");
        
        if(password.equals("admin123"))
        {   
	        HttpSession session=req.getSession();  
	        session.setAttribute("name",name);
	        
	        System.out.println("Login");
        }
        else
        {
        	System.out.println("NO login");
        }
		
	}
}