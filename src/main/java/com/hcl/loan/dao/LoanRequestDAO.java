package com.hcl.loan.dao;

import com.hcl.loan.entity.Loan;

public interface LoanRequestDAO {

	public void persistNewLoanRequest(Loan loan);

}
