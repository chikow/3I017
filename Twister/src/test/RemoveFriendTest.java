package test;

import java.sql.Connection;
import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;

import com.sun.corba.se.impl.ior.FreezableList;

import db.Database;
import service.AddFriendS;
import service.RemoveFriendS;
import tools.FriendTools;
import tools.UserTools;

public class RemoveFriendTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JSONObject o = RemoveFriendS.Unfollow("HTtpisS8qHDUtpQOhhLNKyIaGrAsINFL", 10);
		System.out.println(o);

	}
}