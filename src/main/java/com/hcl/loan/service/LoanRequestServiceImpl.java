package com.hcl.loan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.loan.dao.LoanRequestDAO;
import com.hcl.loan.model.Loan;
import com.hcl.loan.model.User;


@Service ("loanRequestService")
public class LoanRequestServiceImpl implements LoanRequestService {
	
	@Autowired
	private LoanRequestDAO loanRequestDAO;

	@Override
	public Long createLoanRequest(User user, Loan loan) {
		Long referenceId = 0L;
		
		Double emiAmount = getEMI(loan.getAppliedLoanAmount(), loan.getMonthlyInterest(), loan.getTenure());
		loan.setMonthlyEMI(emiAmount);
		
		Boolean isEligible = getCustomerEligibility(loan);		
		loan.setEligible(isEligible);
		
		if(isEligible) {
			loanRequestDAO.persistNewLoanRequest(user, loan);
		}
		
		return referenceId;
	}

	private Boolean getCustomerEligibility(Loan loan) {
		// TODO Auto-generated method stub
		return null;
	}

	private Double getEMI(Double appliedLoanAmount, Double monthlyInterest, Integer tenure) {
		// TODO Auto-generated method stub
		return null;
	}	

}
