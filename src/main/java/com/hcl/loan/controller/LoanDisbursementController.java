package com.hcl.loan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hcl.loan.entity.User;
import com.hcl.loan.model.Loan;
import com.hcl.loan.model.LoanDisbursment;
import com.hcl.loan.service.LoanDisbursmentService;

public class LoanDisbursementController {

	@Autowired
    LoanDisbursmentService loanDisbursmentService;


    /**
     * This method will list all existing users.
     */
    @RequestMapping(value = { "/retrieveLoan" }, method = RequestMethod.GET)
    public ResponseEntity<List<Loan>> retrieveLoan(ModelMap model) {

    	List<Loan> loanDetails = loanDisbursmentService.findAllApprovedLoans();
    	return new ResponseEntity<List<Loan>>(loanDetails, HttpStatus.CREATED);
    }
    /**
     * This method will update the disbursement details of a loan
     */
    @RequestMapping(value = { "/updateLoanDisb" }, method = RequestMethod.GET)
    public boolean updateLoanDisbDetails(@RequestBody LoanDisbursment loanDisb) {

        loanDisbursmentService.updateLoanDisbursmentDetails(loanDisb);
        return true;
    }
    
    
    
  
    

}
