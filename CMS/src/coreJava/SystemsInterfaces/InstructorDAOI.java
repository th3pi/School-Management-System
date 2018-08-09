package coreJava.SystemsInterfaces;

import java.util.List;

import coreJava.Models.Instructor;

public interface InstructorDAOI {
	public List<Instructor> getAllInstructors();
	public Instructor getInstructorByGmail(String email);
}
