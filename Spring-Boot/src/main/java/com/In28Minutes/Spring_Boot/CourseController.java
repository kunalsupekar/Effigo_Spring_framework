package com.In28Minutes.Spring_Boot;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
		
	@RequestMapping("/courses")
	public List<Course> retreiveAllCourses() {
		
		return Arrays.asList(
				new Course(2, "think like monk", "Jay Shetty"),
				new Course(1, "ferrari world", "Robin sharma"),
				new Course(1, "ferrari world", "Robin sharma"),
				new Course(1, "ferrari world", "Robin sharma"),
				new Course(1, "ferrari world", "Robin sharma"),
				new Course(1, "ferrari world", "Robin sharma"),
				new Course(1, "Earth world", "Kapil sharma")
				);
	}
}
