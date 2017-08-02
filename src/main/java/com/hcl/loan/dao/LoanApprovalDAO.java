package com.hcl.loan.dao;

import java.util.List;

import com.hcl.loan.model.Loan;

public interface LoanApprovalDAO {
	public Loan approvalDecision(Loan loan);
	
	public Loan updateLoan(Loan loan);
	
	public List<Loan> getPendingLoans(); 
	
	public void updateAuditLog(Loan loan);
	
	public Integer getHNI(Integer userId);
}
