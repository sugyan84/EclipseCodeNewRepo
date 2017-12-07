package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController
{

	// need a controller method to show the form page.
	@RequestMapping("/showForm")
	public String showForm()
	{
		return "helloworld-form";
	}

	// need a controller method to process the HTML page.
	@RequestMapping("/processForm")
	public String processForm()
	{
		return "helloworld";
	}

	// need a controller method to process form data and add data to Model.
	@RequestMapping("/processFormUpperCase")
	public String processFormToUpperCase(HttpServletRequest request, Model model)
	{
		String name = request.getParameter("studentName");

		name = name.toUpperCase();

		String result = "Yo! " + name;

		model.addAttribute("message", result);

		return "helloworld";
	}

	// need a controller method to process form data and add data to Model
	// (using @RequestParam)
	@RequestMapping("/processFormReqParam")
	public String processFormUsingRequestParam(@RequestParam("studentName") String aName, Model model)
	{
		//String name = request.getParameter("studentName");

		aName = aName.toUpperCase();

		String result = "RequestParam: - " + aName;

		model.addAttribute("message", result);

		return "helloworld";
	}
}
