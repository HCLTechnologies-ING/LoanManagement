package com.hcl.loan.dao.impl;

import javax.sql.DataSource;

import org.springframework.beans.BeanUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import com.hcl.loan.dao.LoanApprovalDAO;
import com.hcl.loan.model.Loan;

public class LoanApprovalDAOImpl implements LoanApprovalDAO {
	
	

	private JdbcTemplate jdbcTemplate;
	
	public LoanApprovalDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Loan approvalDecision(Loan loan) {
		String updateLoanQuery="UPDATE LOAN SET LOAN_STATUS='Rejected' WHERE LOAN_ID="+loan.getLoanId();
		int loanId = jdbcTemplate.update(updateLoanQuery);
		return populateLoanWithId(loan, loanId);
	}
	
	private Loan populateLoanWithId(Loan loan, long loanId)
	{
		Loan createdLoan=new Loan();
		BeanUtils.copyProperties(loan, createdLoan);
		createdLoan.setLoanId(loanId);
		return createdLoan;
	}
	

}
