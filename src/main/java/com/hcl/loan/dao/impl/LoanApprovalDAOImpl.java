package com.hcl.loan.dao.impl;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.hcl.loan.dao.LoanApprovalDAO;
import com.hcl.loan.model.Loan;

public class LoanApprovalDAOImpl implements LoanApprovalDAO {
	@Autowired
	Environment env;
	

	private JdbcTemplate jdbcTemplate;
	
	public LoanApprovalDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Loan approvalDecision(Loan loan) {
		String updateLoanQuery=env.getProperty("update.loan.query")+loan.getLoanId();
		
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
	
	public Loan updateLoan(Loan loan){
		//String updateLoanQuery = "UPDATE LOAN SET LOAN_STATUS='"+loan.getLoanStatus()+"', APPROVED_LOAN_AMOUNT='"+loan.getApprovedLoanAmount()+"', REMARKS='"+loan.getRemarks()+"' WHERE LOAN_ID="+loan.getLoanId();
		String updateLoanQuery = "UPDATE LOAN SET LOAN_STATUS=?, APPROVED_LOAN_AMOUNT=?, REMARKS=? WHERE LOAN_ID=?";
		Object[] params = new Object[] {loan.getLoanStatus(), loan.getApprovedLoanAmount(), loan.getRemarks(), loan.getLoanId()};
		jdbcTemplate.update(updateLoanQuery, params);
		return loan;
	}
	
	public List<Loan> getPendingLoans() {
		String fetchLoanQuery = env.getProperty("fetch.loan.query");
		List<Loan> loanList = jdbcTemplate.query(fetchLoanQuery, new BeanPropertyRowMapper(Loan.class));
		return loanList;
	}
	
	public void updateAuditLog(Loan loan) {
		String updateLoanQuery = env.getProperty("update.audit.loan.query");
		Object[] params = new Object[] { loan.getLoanId(), loan.getLoanStatus(), loan.getPendingWith(), loan.getRemarks(), "1", new Date(), "1", new Date() };
	
		jdbcTemplate.update(updateLoanQuery, params);
	}
	
	public Integer getHNI(Integer userId) {
		String fetchHNIQuery = env.getProperty("fetch.hni.query");
		return jdbcTemplate.queryForObject(fetchHNIQuery, new Object[] { userId }, Integer.class);
	}
	

}
