package com.example.MyFirstWebApplication.Login;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.logging.LoggerGroup;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {

	private Logger logger=LoggerFactory.getLogger(getClass());
	
	@RequestMapping("login")
	public String gotoLoginPage(@RequestParam String name,ModelMap model) {
		logger.info("i want this printed at info level");
		logger.debug("Request param is {}",name);
		//System.out.println("Request Param is "+name);
		model.put("nameModel", name);
		return "login";
	}
}
