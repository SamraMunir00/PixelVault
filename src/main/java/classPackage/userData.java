package classPackage;

public class userData {
	String file_name;
	String name;
	String tags;
	String desc;
	
	
	public userData(String f,String n,String t,String d){
		file_name=f;
		name=n;
		tags=t;
		desc=d;
		
	}
	
	public void setName(String n) {
		name=n;
	}
	public String getName() {
		return name;
	}
	public void settags(String n) {
		tags=n;
	}
	public String gettags() {
		return tags;
	}
	public void setdesc(String n) {
		desc=n;
	}
	public String getdesc() {
		return desc;
	}
	public void setfile(String n) {
		file_name=n;
	}
	public String getfile() {
		return file_name;
	}
	

}
