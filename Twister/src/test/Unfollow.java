package test;

import java.sql.Connection;
import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;
import db.Database;
import service.AddFriendS;
import service.RemoveFriendS;
import tools.FriendTools;
import tools.UserTools;

public class Unfollow {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub

		JSONObject o = RemoveFriendS.Unfollow("IrqtChL3yiN4O0PAB6ZPs7clplfTfZAf", 9);
		System.out.println(o);

	}
}