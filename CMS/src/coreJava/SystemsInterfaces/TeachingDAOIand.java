package coreJava.SystemsInterfaces;

import java.util.List;

import coreJava.Models.Course;
import coreJava.Models.Teaching;

public interface TeachingDAOIand {
	public int assignInstructorToCourse(int course_id, int instructor_id);
	public List<Teaching> getInstructorCourses();
}
