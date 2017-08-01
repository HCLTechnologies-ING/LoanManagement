package com.hcl.loan.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.loan.model.Loan;
import com.hcl.loan.model.User;
import com.hcl.loan.service.LoanRequestService;

@RestController
public class LoanController {
	
	Logger logger = Logger.getLogger(LoanController.class);
	
	@Autowired
	private LoanRequestService loanRequestService;
	
	@RequestMapping(value="/newloan", method= RequestMethod.POST,
			produces=MediaType.APPLICATION_JSON_UTF8_VALUE, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Long> initiateNewLoan(@RequestBody User user, @RequestBody Loan loan){
		
		boolean isValidated = validateLoanRequest(loan);
		
		Long referenceId = 0L;
		
		if(isValidated) {
			referenceId = loanRequestService.createLoanRequest(user, loan);
		} else {
			logger.info("Invalid Loan request deatils");
		}
		
		return new ResponseEntity<Long>(referenceId, HttpStatus.CREATED);
	}

	private boolean validateLoanRequest(Loan loan) {
		// TODO Auto-generated method stub
		return false;
	}

}
