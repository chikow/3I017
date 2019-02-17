package test;



import org.json.JSONObject;

import service.CreatUserS;



/**
 * @author LAOUER Walid
 *
 */
public class testDB {


public static void main(String[] args) {
	
	JSONObject obj = CreatUserS.createUser("chikow","Walid", "Laouer", "walid@live.fr", "mdp");
	
	//JSONObject obj = CreatUserS.createUser(login, nom, prenom, mail, mdp)
	System.out.println(obj.toString());
	
}
}