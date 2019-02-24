package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import service.LoginS;

/**
 * @author LAOUER Walid
 *
 */
public class Login extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String login =  request.getParameter("login");
		String mdp = request.getParameter("mdp");
		
		JSONObject json = LoginS.login(login, mdp);
		response.setContentType("json");
		PrintWriter out = response.getWriter();
		
		out.println(json.toString());
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}
}


