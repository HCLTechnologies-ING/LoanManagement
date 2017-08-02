package com.hcl.loan.dao;

import com.hcl.loan.model.Loan;

public interface LoanRequestDAO {

	public void persistNewLoanRequest(Loan loan);

}
