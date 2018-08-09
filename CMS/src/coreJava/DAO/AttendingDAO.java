package coreJava.DAO;
import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import coreJava.CustomExceptions.*;
import coreJava.Models.Attending;
import coreJava.Models.Course;
import coreJava.Models.Student;
import coreJava.SystemsInterfaces.*;
public class AttendingDAO extends OracleConnection implements AttendingDAOI {
	PreparedStatement ps = null;
	PreparedStatement ps1 = null;
	ResultSet rs = null;
	@Override
	public int registeredStudentToCourse(Student student, Course course) {
		// TODO Auto-generated method stub
		int key = 0;
		if(student.getGpa() < course.getMinimumGpa()) {
			try {
				throw new StudentRegistrationException("Did not meet GPA requirements");
			} catch (StudentRegistrationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			try {
				Connection conn = super.getConnection();
				ps = conn.prepareStatement("INSERT INTO ATTENDING(course_id, student_id) VALUES(?,?)");
				ps.setInt(1, course.getCourseId());
				ps.setInt(2, student.getStudent_id());
				ps.executeUpdate();
				rs = ps.getGeneratedKeys();
				if(rs.next()) {
					key = rs.getInt(1);
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
		}
		return key;
	}
	@Override
	public List<Attending> getStudentCourse(int student_id) {
		// TODO Auto-generated method stub
		Attending attending;
		List<Attending> attendees = new ArrayList<Attending>();
		try {
			Connection conn = super.getConnection();
			ps = conn.prepareStatement("SELECT C.COURSE_ID, C.COURSE_NAME, C.MINIMUN_GPA\r\n" + 
					"FROM ATTENDING A\r\n" + 
					"INNER JOIN COURSE C ON C.COURSE_ID=A.COURSE_ID\r\n" + 
					"INNER JOIN STUDENT S ON S.STUDENT_ID=A.STUDENT_ID\r\n" + 
					"WHERE S.STUDENT_ID = ?");
			ps.setInt(1, student_id);
			rs = ps.executeQuery();
			while(rs.next()) {
				attending = new Attending();
				attending.setCourse_name(rs.getString(1));
				attending.setFull_name(rs.getString(2));
				attending.setEmail(rs.getString(3));
				attendees.add(attending);
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
		
		return attendees;
	}
	
}
