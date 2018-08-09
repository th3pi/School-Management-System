package coreJava.SystemsInterfaces;

import java.util.List;

import coreJava.Models.Course;

public interface CourseDAOI {
	public List<Course> getAllCourses();
	public List<Course> getCourseByInstructor(int instructor_id);
}
