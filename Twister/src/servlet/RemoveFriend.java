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

import service.RemoveFriendS;

/**
 * @author LAOUER Walid
 *
 */
public class RemoveFriend {
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
			String id_user = request.getParameter("id_user");
			String id_friend =  request.getParameter("id_friend");
			
			response.setContentType("json");
			PrintWriter out = response.getWriter();
			
			out.println(RemoveFriendS.removeFriend(Integer.parseInt(id_user), Integer.parseInt(id_friend)));
		}
	

}
