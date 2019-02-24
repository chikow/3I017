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

import service.AddFriendS;



/**
 * @author LAOUER Walid
 *
 */
public class AddFriend {
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	
			String key = request.getParameter("id_user");
			String id_friend =  request.getParameter("id_friend");
			
			response.setContentType("json");
			PrintWriter out = response.getWriter();
			
			out.println(AddFriendS.addFriend(key, Integer.parseInt(id_friend)));
		}
	

}
