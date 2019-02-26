package test;

import org.json.JSONObject;

import service.AddTwistS;

public class ListTwists {
	public static void main(String[ ] args) throws InstantiationException, IllegalAccessException {
	JSONObject obj = AddTwistS.listTwists("476a16FcAmZVYSbBChc8DAKis2Pr4iaD", "true", "2");

	System.out.println(obj);
	}
}