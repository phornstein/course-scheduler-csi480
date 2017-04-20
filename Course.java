
package course_scheduler;

public class Course {
	private String courseID;
	private String bldg;
	private String rm;
	private String day;
	private String time;
	
	public Course(String courseID, String bldg,
			String rm, String day, String time) {
		this.courseID = courseID;
		this.bldg = bldg;
		this.rm = rm;
		this.day = day;
		this.time = time;
	}
	
	public Course() {
		
	}
	
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	
	public void setBldg(String bldg) {
		this.bldg = bldg;
	}
	
	public void setRm(String rm) {
		this.rm = rm;
	}
	
	public void setDay(String day) {
		this.day = day;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
	public String getCourseID() {
		return courseID;
	}
	
	public String getBldg() {
		return bldg;
	}
	
	public String getRm() {
		return rm;
	}
	
	public String getDay() {
		return day;
	}
	
	public String getTime() {
		return time;
	}
	
	public String getAll() {
		String all = courseID + " " + bldg + " " 
				+ rm + " " + day + " " + time;
		
		return all;
		
	}

}

