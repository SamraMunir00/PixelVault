package classPackage;

public class userExtended extends user{

	
	String file_name;
	String image_name;
	String tags;
	String desc;
	
	public userExtended(String n, String p,String f,String m,String t,String d) {
		
		super(n, p);
		
		file_name=f;
		image_name=m;
		tags=t;
		desc=d;
		
		
		
	}
	
	public void setiName(String n ) {
		image_name=n;
		
	}
	public void setTags(String n ) {
		tags=n;
		
	}
	public void setDesc(String n ) {
		desc=n;
		
	}
	public void setFilename(String n ) {
		file_name=n;
		
	}
	
	
	public String getiName() {
		return image_name;
	}
	public String getFilename() {
		return file_name;
	}
	public String getDesc() {
		return desc;
	}
	public String getTags() {
		return tags;
	}
	

}
