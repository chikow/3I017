/**
 * 
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AddTwistS;

/**
 * @author LAOUER Walid
 *
 */
public class AddComment extends HttpServlet{
<<<<<<< HEAD
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

=======
>>>>>>> branch 'master' of https://github.com/chikow/3I017.git
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			
			
				String key = request.getParameter("key");
				//String id_message =  request.getParameter("id_message");
				String text = request.getParameter("text");
				
				response.setContentType("text/plain");
				PrintWriter out = response.getWriter();
				
				out.println(AddTwistS.AddTwist(key, text).toString());
			}
	

}
