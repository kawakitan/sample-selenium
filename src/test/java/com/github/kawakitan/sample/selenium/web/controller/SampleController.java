package com.github.kawakitan.sample.selenium.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.kawakitan.sample.selenium.web.entity.SampleEntity;

@Controller
@RequestMapping("/test")
public class SampleController {

	@RequestMapping(method = RequestMethod.GET)
	public String test(Model model) {
		SampleEntity cntr = new SampleEntity();
		cntr.setId(1);
		cntr.setTitle("title");
		cntr.setCount(0);
		model.addAttribute("db", cntr);
		return "test";
	}
}
