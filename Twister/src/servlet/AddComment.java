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

import service.AddCommentS;

/**
 * @author LAOUER Walid
 *
 */
public class AddComment {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			
			
				String key = request.getParameter("key");
				String id_message =  request.getParameter("id_message");
				String text = request.getParameter("text");
				
				response.setContentType("text/plain");
				PrintWriter out = response.getWriter();
				
				out.println(AddCommentS.postComment(key, Integer.parseInt(id_message), text).toString());
			}
	

}
