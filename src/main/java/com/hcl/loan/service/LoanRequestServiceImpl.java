package com.hcl.loan.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.loan.dao.LoanRESTRepository;
import com.hcl.loan.dao.LoanRequestDAO;
import com.hcl.loan.model.Loan;
import com.hcl.loan.model.User;


@Service ("loanRequestService")
public class LoanRequestServiceImpl implements LoanRequestService {
	
	@Autowired
	private LoanRequestDAO loanRequestDAO;
	@Autowired
	private LoanRESTRepository loanRESTRepository;
	

	@Transactional
	@Override
	public Long createLoanRequest(User user, Loan loan) {
		Long referenceId = 0L;
		com.hcl.loan.entity.Loan loanEntity = new com.hcl.loan.entity.Loan();
		Double emiAmount = getEMI(loan);
		loan.setMonthlyEMI(emiAmount);
		
		Boolean isEligible = getCustomerEligibility(loan);		
		loan.setEligible(isEligible);
		loan.setUserId(user.getUserId());
		
		if(isEligible) {
			BeanUtils.copyProperties(loan, loanEntity);
			loanRequestDAO.persistNewLoanRequest(loanEntity);
			loanRESTRepository.sendApprovalRequest(user, loan);
		}
		
		return referenceId;
	}

	private Boolean getCustomerEligibility(Loan loan) {
		// TODO Auto-generated method stub
		return null;
	}

	private Double getEMI(final Loan loan) {
		
		return loanRESTRepository.fetchCalculatedEMI(loan);
	}	

}
