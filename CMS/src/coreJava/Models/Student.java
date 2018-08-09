package coreJava.Models;

public class Student {
	private String email;
	private String full_name;
	private String pass;
	private int student_id;
	private double gpa;
	private int student_role;
	
	public Student() {
		email = "";
		full_name = "";
		pass = "";
		student_id = 0;
		student_role = 0;
		gpa = 0;
	}
	
	public Student(int student_id, String full_name, String email, double gpa, String pass, int student_role) {
		this.student_id = student_id;
		this.email = email;
		this.full_name = full_name;
		this.gpa = gpa;
		this.pass = pass;
		this.student_role = student_role;
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

	/**
	 * @return the name
	 */
	public String getName() {
		return full_name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.full_name = name;
	}

	/**
	 * @return the pass
	 */
	public String getPass() {
		return pass;
	}

	/**
	 * @param pass the pass to set
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}

	/**
	 * @return the student_id
	 */
	public int getStudent_id() {
		return student_id;
	}

	/**
	 * @param student_id the student_id to set
	 */
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	/**
	 * @return the gpa
	 */
	public double getGpa() {
		return gpa;
	}

	/**
	 * @param gpa the gpa to set
	 */
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	/**
	 * @return the student_role
	 */
	public int getStudent_role() {
		return student_role;
	}

	/**
	 * @param student_role the student_role to set
	 */
	public void setStudent_role(int student_role) {
		this.student_role = student_role;
	}
}
