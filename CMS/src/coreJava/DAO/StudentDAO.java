package coreJava.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import coreJava.Models.Student;
import coreJava.SystemsInterfaces.StudentDAOI;

public class StudentDAO extends OracleConnection implements StudentDAOI{
	PreparedStatement ps = null;
	ResultSet rs = null;
	String password;
	@SuppressWarnings("finally")
	@Override
	public Student getStudentByGmail(String email) {
		// TODO Auto-generated method stub
		Student student = new Student();
		
		try {
			Connection conn = super.getConnection();
			ps = conn.prepareStatement("SELECT * FROM student WHERE email = ?");
			ps.setString(1, email);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				student.setStudent_id(rs.getInt(1));
				student.setName(rs.getString(2));
				student.setEmail(rs.getString(3));
				student.setGpa(rs.getDouble(4));
				student.setPass(rs.getString(5));
				student.setStudent_role(rs.getInt(6));
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
		}finally {
			password = student.getPass();
			return student;
		}
	}
	
	public boolean validateUser(String passToValidate, String comparablePass) {
		boolean flag = false;
		comparablePass = password;
		if(passToValidate.length() == comparablePass.length()) {
			for(int i = 0; i < passToValidate.length(); i++) {
				if(passToValidate.charAt(i) == comparablePass.charAt(i)) {
					flag = true;
				}else {
					flag = false;
				}
			}
		}
		return flag;
	}
	
	
	
}
