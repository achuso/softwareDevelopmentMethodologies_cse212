import java.util.Hashtable;


// LOGIN NEEDS WORK!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

public class LoginSystem {

	private Hashtable <String,String> loginMgr;
	
	LoginSystem() {
		loginMgr = new Hashtable<>();
	}
	
	public boolean addUser( String username, String password ) {
		if (username.length() < 4 || loginMgr.containsKey(username)) return false;
		System.out.println(username);

		loginMgr.put(username, password);
		return true;
	}
	
	public boolean getUserLogin( String username, String password ) {
		return loginMgr.containsKey(username) && loginMgr.get(username).compareTo(password) == 0;
	}

	public boolean userExists( String username) {
		return loginMgr.containsKey(username);
	}

}
