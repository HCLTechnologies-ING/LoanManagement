package com.hcl.loan.dao;

import com.hcl.loan.model.Loan;
import com.hcl.loan.model.User;

public interface LoanRequestDAO {

	public void persistNewLoanRequest(User user, Loan loan);

}
