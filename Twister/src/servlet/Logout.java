/**
 * 
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.LogoutS;

/**
 * @author LAOUER Walid
 *
 */
public class Logout {
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
			String key = request.getParameter("key");
			
			response.setContentType("json");
			PrintWriter out = response.getWriter();
			out.println(LogoutS.logout(key));
		}
	

}