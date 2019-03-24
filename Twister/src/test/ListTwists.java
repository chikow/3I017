package test;

import org.json.JSONObject;

import service.twist.AddTwistS;

public class ListTwists {
	public static void main(String[ ] args) throws InstantiationException, IllegalAccessException {
	JSONObject obj = AddTwistS.listTwists("4NH2Ut3ruiVrU1LZNKrAOT6pcXgXDKKY", "true", "4");

	System.out.println(obj);
	}
}