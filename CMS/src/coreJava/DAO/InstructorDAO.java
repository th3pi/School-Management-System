package coreJava.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import coreJava.Models.Instructor;
import coreJava.Models.Student;
import coreJava.SystemsInterfaces.InstructorDAOI;

public class InstructorDAO extends OracleConnection implements InstructorDAOI {
	PreparedStatement ps = null;
	ResultSet rs = null;
	String password;
	@Override
	public List<Instructor> getAllInstructors(){
		List<Instructor> instructors = new ArrayList<Instructor>();
		try {
			Connection conn = super.getConnection();
			ps = conn.prepareStatement("SELECT * FROM INSTRUCTOR");
			rs = ps.executeQuery();
			while(rs.next()) {
				Instructor instructor = new Instructor();
				instructor.setInstructor_id(rs.getInt(1));
				instructor.setFull_name(rs.getString(2));
				instructor.setEmail(rs.getString(3));
				instructor.setSpeciality(rs.getString(4));
				instructor.setAdmin_role(rs.getInt(5));
				instructor.setPass(rs.getString(6));
				instructors.add(instructor);
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
		// TODO Auto-generated method stub
		finally {
			return instructors;
		}
	}

	@Override
	public Instructor getInstructorByGmail(String email) {
		Instructor instructor = new Instructor();
		
		try {
			Connection conn = super.getConnection();
			ps = conn.prepareStatement("SELECT * FROM instructor WHERE email = ?");
			ps.setString(1, email);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				instructor.setInstructor_id(rs.getInt(1));
				instructor.setFull_name(rs.getString(2));
				instructor.setEmail(rs.getString(3));
				instructor.setSpeciality(rs.getString(4));
				instructor.setAdmin_role(rs.getInt(5));
				instructor.setPass(rs.getString(6));
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
			password = instructor.getPass();
			return instructor;
		}
	}
	
	public String validateUser(Instructor ins, String comparablePas) {
		boolean flag = false;
		if(ins.getPass().length() == comparablePas.length()) {
			for(int i = 0; i < comparablePas.length(); i++) {
				if(ins.getPass().charAt(i) == comparablePas.charAt(i)) {
					flag = true;
				}else {
					flag = false;
				}
			}
		}
		if(flag) {
			if(ins.getAdmin_role() == 0) {
				return "Instructor";
			}
			else {
				return "Admin";
			}
		}else {
			return "Wrong credentials";
		}
	}
	
}
