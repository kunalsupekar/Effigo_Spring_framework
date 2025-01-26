package com.In28Minutes.Spring_Boot;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@Controller
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
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
		public String name() {
		return "login";
		
	}
	
	@RequestMapping(value = "/",method = RequestMethod.POST)
	public String loginPage(ModelMap model, @Valid LoginDTO loginDTO, BindingResult result) {
		
		if(result.hasErrors()) {
			 model.addAttribute("loginDTO", loginDTO); 
			return "login";
		}
		
		String username = (String)model.get("name");
	
		return "welcome";
	}
}
