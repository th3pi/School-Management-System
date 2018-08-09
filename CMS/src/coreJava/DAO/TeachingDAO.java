package coreJava.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import coreJava.Models.Course;
import coreJava.Models.Teaching;
import coreJava.SystemsInterfaces.TeachingDAOIand;

public class TeachingDAO extends OracleConnection implements TeachingDAOIand {
	PreparedStatement ps = null;
	ResultSet rs = null;
	@Override
	public int assignInstructorToCourse(int course_id, int instructor_id) {
		// TODO Auto-generated method stub
		try {
			Connection conn = super.getConnection();
			ps = conn.prepareStatement("INSERT INTO TEACHING(course_id,instructor_id) values(?,?)");
			ps.setInt(1, course_id);
			ps.setInt(2, instructor_id);
			ps.executeUpdate();
			
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
		return 0;
	}

	@Override
	public List<Teaching> getInstructorCourses() {
		Teaching teaching;
		List<Teaching> teachings = new ArrayList<Teaching>();
		// TODO Auto-generated method stub
		try {
			Connection conn = super.getConnection();
			ps = conn.prepareStatement("SELECT C.COURSE_NAME, C.MINIMUN_GPA, I.FULL_NAME,I.EMAIL\r\n" + 
					"FROM TEACHING T\r\n" + 
					"INNER JOIN INSTRUCTOR I ON I.INSTRUCTOR_ID = T.INSTRUCTOR_ID\r\n" + 
					"INNER JOIN COURSE C ON C.COURSE_ID = T.COURSE_ID");
			rs = ps.executeQuery();
			while(rs.next()) {
				teaching = new Teaching();
				teaching.setCourse_name(rs.getString(1));
				teaching.setMinimum_gpa(rs.getDouble(2));
				teaching.setFull_name(rs.getString(3));
				teaching.setEmail(rs.getString(4));
				teachings.add(teaching);
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
		
		return teachings;
	}

}
