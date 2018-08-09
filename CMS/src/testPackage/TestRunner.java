package testPackage;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import coreJava.DAO.AttendingDAO;
import coreJava.DAO.CourseDAO;
import coreJava.DAO.InstructorDAO;
import coreJava.DAO.OracleConnection;
import coreJava.DAO.StudentDAO;
import coreJava.DAO.TeachingDAO;
import coreJava.Models.Course;
import coreJava.Models.Instructor;
import coreJava.Models.Student;
import coreJava.Models.Teaching;
public class TestRunner {

	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
		// TODO Auto-generated method stub
//		OracleConnection connection = new OracleConnection();
//		connection.getConnection();
//		StudentDAO s = new StudentDAO();
//		Student st = new Student();
//		st = s.getStudentByGmail("y@gmail.com");
//		System.out.println(st.getName());
//		System.out.println(s.validateUser("222", st.getPass()));
		
//		InstructorDAO i = new InstructorDAO();
//		Instructor in = new Instructor();
//		List<Instructor> il = new ArrayList<Instructor>(i.getAllInstructors());
//		for(Instructor ins : il) {
//			System.out.println(ins.getFull_name());
//		}
//		
//		in = i.getInstructorByGmail("luke@gmail.com");
//		System.out.println(in.getAdmin_role());
//		System.out.println(i.validateUser(in, "999"));
		
		
//		AttendingDAO a = new AttendingDAO();
//		List<Course> courses = new ArrayList<Course>(a.getStudentCourse(2));
//		for(Course c : courses) {
//			System.out.println(c.getCourseName());
//		}
		
//		Course c = new Course(1,"Computer",3.0);
//		Student s = new Student(1,"Hoke","h@gmail.com",3,"444",-1);
//		
//		AttendingDAO a = new AttendingDAO();
//		System.out.println(a.registeredStudentToCourse(s, c));
		
		
//		CourseDAO c = new CourseDAO();
//		List<Course> courses = new ArrayList<Course>(c.getCourseByInstructor(3));
//		for(Course co : courses) {
//			System.out.println(co.getCourseName() + co.getMinimumGpa());
//		}
		
		TeachingDAO teach = new TeachingDAO();
		Course course = new Course();
		Instructor instructor = new Instructor();
		List<Teaching> teaching = new ArrayList<Teaching>(teach.getInstructorCourses());
		for(Teaching tea : teaching) {
			System.out.println(tea.getCourse_name() + " " + tea.getFull_name());
		}
	}

}
