package com.hcl.loan.service;

import org.springframework.stereotype.Service;

import com.hcl.loan.model.Loan;

@Service
public interface LoanApprovalService {
	
	public Loan approvalDecision(Loan loan);
	
	

}
