package coreJava.Models;

public class Teaching {
	private String course_name;
	private double minimum_gpa;
	private String full_name;
	private String email;
	
	public Teaching() {
		course_name = "";
		minimum_gpa = 0;
		full_name = "";
		email = "";
	}
	public Teaching(String course_name, double minimum_gpa, String full_name, String email) {
		this.course_name = course_name;
		this.minimum_gpa = minimum_gpa;
		this.full_name = full_name;
		this.email = email;
	}
	/**
	 * @return the course_name
	 */
	public String getCourse_name() {
		return course_name;
	}
	/**
	 * @param course_name the course_name to set
	 */
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	/**
	 * @return the full_name
	 */
	public String getFull_name() {
		return full_name;
	}
	/**
	 * @param full_name the full_name to set
	 */
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	public double getMinimum_gpa() {
		return minimum_gpa;
	}
	public void setMinimum_gpa(double minimum_gpa) {
		this.minimum_gpa = minimum_gpa;
	}
}
