package coreJava.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import coreJava.Models.Course;
import coreJava.SystemsInterfaces.CourseDAOI;

public class CourseDAO extends OracleConnection implements CourseDAOI {
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public List<Course> getAllCourses() {
		// TODO Auto-generated method stub
		Course course;
		List<Course> courses = new ArrayList<Course>();
		try {
			Connection conn = super.getConnection();
			ps = conn.prepareStatement("SELECT * FROM COURSE");
			rs = ps.executeQuery();
			while(rs.next()) {
				course = new Course();
				course.setCourseId(rs.getInt(1));
				course.setCourseName(rs.getString(2));
				course.setMinimumGpa(rs.getDouble(3));
				courses.add(course);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return courses;
	}

	@Override
	public List<Course> getCourseByInstructor(int instructor_id) {
		// TODO Auto-generated method stub
		List<Course> courses = new ArrayList<Course>();
		Course course;
		try {
			Connection conn = super.getConnection();
			ps = conn.prepareStatement("SELECT C.COURSE_ID, C.COURSE_NAME, C.minimun_gpa\r\n" + 
					"FROM TEACHING T\r\n" + 
					"INNER JOIN INSTRUCTOR I ON I.INSTRUCTOR_ID = T.INSTRUCTOR_ID\r\n" + 
					"INNER JOIN COURSE C ON C.COURSE_ID = T.COURSE_ID\r\n" + 
					"WHERE I.INSTRUCTOR_ID = ?");
			ps.setInt(1, instructor_id);
			rs = ps.executeQuery();
			while(rs.next()) {
				course = new Course();
				course.setCourseId(rs.getInt(1));
				course.setCourseName(rs.getString(2));
				course.setMinimumGpa(rs.getDouble(3));
				courses.add(course);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return courses;
	}
	
}
