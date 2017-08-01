package com.hcl.loan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.loan.dao.LoanApprovalDAO;
import com.hcl.loan.model.Loan;
import com.hcl.loan.service.LoanApprovalService;

@Service
public class LoanApprovalServiceImpl implements LoanApprovalService{
	
	@Autowired
	LoanApprovalDAO loanApprovalDAO;
	@Transactional
	public Loan approvalDecision(Loan loan) {
		Loan approvalLoan = loanApprovalDAO.approvalDecision(loan);
		 return approvalLoan;
	}

}
