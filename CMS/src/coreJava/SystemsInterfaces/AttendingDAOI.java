package coreJava.SystemsInterfaces;

import java.util.List;

import coreJava.Models.Attending;
import coreJava.Models.Course;
import coreJava.Models.Student;

public interface AttendingDAOI {
	public int registeredStudentToCourse(Student student, Course course);
	public List<Attending> getStudentCourse(int student_id);
}
