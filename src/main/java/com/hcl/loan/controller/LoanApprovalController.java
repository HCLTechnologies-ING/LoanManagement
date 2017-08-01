package com.hcl.loan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hcl.loan.model.Loan;
import com.hcl.loan.service.LoanApprovalService;

@Controller
public class LoanApprovalController {

	@Autowired
	LoanApprovalService loanApprovalService;

	@RequestMapping(value = "/approval", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Loan> helloworld(@RequestBody Loan loan) {
		Loan loanInsert = loanApprovalService.approvalDecision(loan);
		return new ResponseEntity<>(loanInsert, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView helloworld() {
		return new ModelAndView();
	}
}
