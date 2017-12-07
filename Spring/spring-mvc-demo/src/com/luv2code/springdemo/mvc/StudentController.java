package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springdemo.beans.Student;

@Controller
@RequestMapping("/student")
public class StudentController
{
	@RequestMapping("/showForm")
	public String showForm(Model m)
	{
		Student obj = new Student();
		
		m.addAttribute("student", obj);
		
		return "stud-form";
	}
	
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student s)
	{
		System.out.println("Submitted last name is: |"+s.getLastName()+"|");
		
		return "stud-conf";
	}
	
}
