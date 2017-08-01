package com.hcl.loan.dao;

import com.hcl.loan.model.Loan;

public interface LoanApprovalDAO {
	public Loan approvalDecision(Loan loan);

}
