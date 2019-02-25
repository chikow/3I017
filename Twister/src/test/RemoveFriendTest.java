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

public class RemoveFriendTest {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub

		JSONObject o = RemoveFriendS.Unfollow("HTtpisS8qHDUtpQOhhLNKyIaGrAsINFL", 10);
		System.out.println(o);

	}
}