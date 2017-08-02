package com.hcl.loan.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.loan.model.Loan;
import com.hcl.loan.service.LoanApprovalService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class LoanApprovalController {
	private Logger logger = Logger.getLogger(LoanApprovalController.class.getName());

	@Autowired
	LoanApprovalService loanApprovalService;

	@RequestMapping(value = "/approval", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Loan> getAutoApproval(@RequestBody Loan loan) {
		Loan loanInsert = loanApprovalService.getAutoApproval(loan);
		return new ResponseEntity<>(loanInsert, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/manual", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Void> getManualApproval(@RequestBody Loan loan) {
		loanApprovalService.getManualApproval(loan);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value = "/pendingloans/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Loan>> getAllPendingLoans(@PathVariable String userId) {
		ResponseEntity<List<Loan>> response = null;
		try {
			List<Loan> loanList = loanApprovalService.getAllPendingLoans(userId);
			if (loanList != null) {
				response = new ResponseEntity<>(loanList, HttpStatus.OK);
			} else {

				response = new ResponseEntity<>(loanList, HttpStatus.NOT_FOUND);
			}
		} catch (DataAccessException daeException) {
			logger.error("Error in LoanApprovalController " + daeException.getMessage());
		}
		logger.info("LoanApprovalController - getAllPendingLoans Successfully fetch Loan details");
		return response;

	}
}
