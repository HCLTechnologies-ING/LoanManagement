package com.hcl.loan.dao;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hcl.loan.entity.Loan;

@Repository("loanRequestDAO")
public class LoanRequestDAOImpl implements LoanRequestDAO {

	Logger logger = Logger.getLogger(LoanRequestDAOImpl.class);

	private static String NEW_LOAN_REQUEST = "INSERT INTO LOAN (userId, loanTypeId, appliedLoanAmount, approvedLoanAmount, "
			+ "commencementDate, completionDate, interestRate, loanStatus, pendingWith, remarks, tenure, totalRepaidAmount)"
			+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";;

	@Autowired
	JdbcTemplate jdbcTemplate;

	public LoanRequestDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void persistNewLoanRequest(Loan loan) {
		if (jdbcTemplate == null) {
			logger.error("");
		}
		jdbcTemplate.update(NEW_LOAN_REQUEST, loan.getLoanTypeId(), loan.getAppliedLoanAmount(),
				loan.getApprovedLoanAmount(), loan.getCommencementDate(), loan.getCompletionDate(),
				loan.getInterestRate(), loan.getLoanStatus(), loan.getPendingWith(), loan.getRemarks(),
				loan.getTenure(), loan.getTotalRepaidAmount());
		
	}

}
