package com.hcl.loan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

public class LoanDisbursementController {

	  
	@Controller
	@RequestMapping("/loandisb")
	public class LoanController {

		@RequestMapping(method=RequestMethod.GET)
		public ModelAndView helloworld()
		{
			return new ModelAndView();
		}
	}
}
