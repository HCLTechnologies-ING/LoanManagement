package com.hcl.loan.dao;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hcl.loan.model.Loan;

@Repository("loanRequestDAO")
public class LoanRequestDAOImpl implements LoanRequestDAO {

	Logger logger = Logger.getLogger(LoanRequestDAOImpl.class);

	private static String NEW_LOAN_REQUEST = "INSERT INTO lms.LOAN (USER_ID, TOTAL_REPAID_AMOUNT, TENURE, "
			+ "REMARKS, PENDING_WITH, LOAN_TYPE_ID, LOAN_STATUS, INTEREST_RATE, "
			+ "COMPLETION_DATE, COMMENCEMENT_DATE, APPROVED_LOAN_AMOUNT,APPLIED_LOAN_AMOUNT) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
			
	
	JdbcTemplate jdbcTemplate;

	public LoanRequestDAOImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void persistNewLoanRequest(Loan loan) {
		if (jdbcTemplate == null) {
			logger.error("");
		}
		jdbcTemplate.update(NEW_LOAN_REQUEST, loan.getUserId(), loan.getTotalRepaidAmount(),
				loan.getTenure(), loan.getRemarks(), loan.getPendingWith(), loan.getLoanTypeId(), loan.getLoanStatus(), 
				loan.getMonthlyInterest(), loan.getEndDate(),loan.getStartDate(), loan.getApprovedLoanAmount(), loan.getAppliedLoanAmount());
				
					
	}

	

}
