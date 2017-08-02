package com.hcl.loan.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.loan.model.Loan;
import com.hcl.loan.model.User;
import com.hcl.loan.service.LoanRequestService;
import com.hcl.loan.validator.LoanUserValidator;
@CrossOrigin
@RestController
public class LoanController {
	
	Logger logger = Logger.getLogger(LoanController.class);
	
	@Autowired
	private LoanRequestService loanRequestService;
	@Autowired
	private LoanUserValidator loanUserValidator;
	
	@RequestMapping(value="/newloan", method= RequestMethod.POST,
			produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Loan> initiateNewLoan(@RequestBody User user) {
		
		boolean isValidated = validateLoanRequest(user);
		Loan loan = user.getLoans().get(0);
				
		if(isValidated) {
			loan = loanRequestService.createLoanRequest(user, loan);
		} else {
			logger.info("Invalid Loan request deatils");
		}
		
		return new ResponseEntity<Loan>(loan, HttpStatus.CREATED);
	}

	private boolean validateLoanRequest(User user) {
		loanUserValidator.validateEligibility(user);
		return true;
	}

}
