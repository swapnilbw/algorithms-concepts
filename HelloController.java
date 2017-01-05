package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloController {

	@RequestMapping("/")
	public String sayHello(){
		
		//return "Hello World";
		System.out.println("INSide controller");
		return "redirect:index.html";
	}
	
	
}
