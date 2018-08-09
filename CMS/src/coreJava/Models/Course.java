package coreJava.Models;


/**
 * @author th3pi
 *
 */
public class Course {
	private int course_id;
	private String course_name;
	private double minimum_gpa;
	
	public Course() {
		course_id = 0;
		course_name = "";
		minimum_gpa = 0;
	}
	public Course(int courseId, String courseName, double minimum_gpa) {
		this.course_id = courseId;
		this.course_name = courseName;
		this.minimum_gpa = minimum_gpa;
	}
	/**
	 * @return the courseId
	 */
	public int getCourseId() {
		return course_id;
	}
	/**
	 * @param courseId the courseId to set
	 */
	public void setCourseId(int courseId) {
		this.course_id = courseId;
	}
	/**
	 * @return the courseName
	 */
	public String getCourseName() {
		return course_name;
	}
	/**
	 * @param courseName the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.course_name = courseName;
	}
	/**
	 * @return the instructorName
	 */
	public double getMinimumGpa() {
		return minimum_gpa;
	}
	/**
	 * @param instructorName the instructorName to set
	 */
	public void setMinimumGpa(double minimum_gpa) {
		this.minimum_gpa = minimum_gpa;
	}
}
