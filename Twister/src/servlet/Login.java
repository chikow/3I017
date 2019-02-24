package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.LoginS;

/**
 * @author LAOUER Walid
 *
 */
public class Login extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String login =  request.getParameter("login");
		String mdp = request.getParameter("mdp");
		
		response.setContentType("json");
		PrintWriter out = response.getWriter();
		
		out.println(LoginS.login(login, mdp));
	}

}
