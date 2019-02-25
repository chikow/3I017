package test;

import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;

import service.AddCommentS;
import service.AddTwistS;
import service.LoginS;
import servlet.AddComment;
import tools.UserTools;

public class TestComment {

	public static void main(String[] args) throws SQLException, JSONException, InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
//		JSONObject obj = AddTwistS.AddTwistS("7uocJsq4SBLqnToWn38pwTYzvFdbibpe", UserTools.generatekey());
//		System.out.println( obj);
		
		JSONObject o = AddCommentS.postComment("beh09aiclV3gH8DE6Z8Xp4yfxAN0dGaO", "5c72611b13acf63d1ac10fe1", "I like this post");
		System.out.println(o);

		JSONObject ob = AddCommentS.postComment("p7OxPwaydulGINckYSBWI6naJW3rlSQ5", "5c72611b13acf63d1ac10fe1", "!(Tech web is amazing)");
		System.out.println(ob);
		
	}

}
