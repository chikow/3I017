package test;



import org.json.JSONObject;

import service.CreatUserS;
import tools.UserTools;



/**
 * @author LAOUER Walid
 *
 */
public class testDB {


public static void main(String[] args) {
	
	//JSONObject obj = CreatUserS.createUser("chikow","Walid", "Laouer", "walid@live.fr", "mdp");
	//System.out.println(obj.toString());
	System.out.println(UserTools.checkPassword("chikow", "mdp"));
	
}

}