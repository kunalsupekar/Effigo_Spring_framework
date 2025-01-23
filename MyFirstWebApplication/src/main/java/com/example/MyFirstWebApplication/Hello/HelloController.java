package com.example.MyFirstWebApplication.Hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloController {

	@RequestMapping("/say-hello")
	@ResponseBody
	public String sayHello() {
		return "Hello ,what are you Learning Today";
	}
	
	@RequestMapping("/say-hello-jsp")
	public String sayHelloJsp() {
		return "sayHello";
	}
	
	
	@RequestMapping("/say-hello-html")
	@ResponseBody
	public String sayHelloHtml() {
		StringBuffer sBuffer=new StringBuffer();
		sBuffer.append("<html>");
		sBuffer.append("<head>");
		sBuffer.append("<title> My first HTML Page </title>");
		sBuffer.append("</head>");
		sBuffer.append("</body>");
		sBuffer.append(" HEllo Kunal Welcome to Bangalore !");
		sBuffer.append("</body>");
		sBuffer.append("</html>");
		return sBuffer.toString();
	}
	
	
	
	
}
