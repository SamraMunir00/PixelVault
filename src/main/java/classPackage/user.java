package classPackage;

public class user {
	
	private String name;
	private String password;
	
	public user(String n, String p) {
		name=n;
		password=p;
		
	}
	
	public void setName(String n) {
		name=n;
	}
	public String getName() {
		return name;
	}

	public void setPassword(String n) {
		password=n;
	}
	public String getPassword() {
		return password;
	}

}
