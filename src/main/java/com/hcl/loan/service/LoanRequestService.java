package com.hcl.loan.service;

import com.hcl.loan.model.Loan;
import com.hcl.loan.model.User;


public interface LoanRequestService {
	
	public Long createLoanRequest(User user, Loan loan);	

}
