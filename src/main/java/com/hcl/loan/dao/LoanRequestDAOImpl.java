package com.hcl.loan.dao;

import org.springframework.stereotype.Repository;

import com.hcl.loan.model.Loan;
import com.hcl.loan.model.User;

@Repository("loanRequestDAO")
public class LoanRequestDAOImpl implements LoanRequestDAO {

	@Override
	public void persistNewLoanRequest(User user, Loan loan) {
		// TODO Auto-generated method stub
		
	}

}
