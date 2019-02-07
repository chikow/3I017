package servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CreatUserS;;

/**
 * @author LAOUER Walid
 *
 */
public class CreatUser extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String nom = request.getParameter("nom");
			String prenom =  request.getParameter("prenom");
			String mail = request.getParameter("mail");
			String login =  request.getParameter("login");
			String mdp = request.getParameter("mdp");
			
			response.setContentType("json");
			PrintWriter out = response.getWriter();
			
			out.println(CreatUserS.createUser(nom, prenom, mail, login, mdp));
		}
	}
	

