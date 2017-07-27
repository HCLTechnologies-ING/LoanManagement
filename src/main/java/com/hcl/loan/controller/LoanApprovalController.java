package com.hcl.loan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/loandisb")
public class LoanApprovalController {

	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView helloworld()
	{
		return new ModelAndView();
	}
}
