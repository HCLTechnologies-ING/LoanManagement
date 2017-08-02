package com.hcl.loan.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.loan.dao.LoanRESTRepository;
import com.hcl.loan.dao.LoanRequestDAO;
import com.hcl.loan.dao.LoanRequestDAOImpl;
import com.hcl.loan.model.Loan;
import com.hcl.loan.model.User;


@Service ("loanRequestService")
public class LoanRequestServiceImpl implements LoanRequestService {
	Logger logger = Logger.getLogger(LoanRequestServiceImpl.class);
	
	@Autowired
	private LoanRequestDAO loanRequestDAO;
	@Autowired
	private LoanRESTRepository loanRESTRepository;
	

	@Override
	public Loan createLoanRequest(User user, Loan loan) {
		Double emiAmount = loanRESTRepository.fetchCalculatedEMI(loan);
		loan.setMonthlyEMI(emiAmount);
		
		Boolean isEligible = getCustomerEligibility(loan);		
		loan.setEligible(isEligible);
		loan.setUserId(user.getUserId());
		logger.info("Dateformate: "+loan.getStartDate());
		if(isEligible) {			
			loan.setStartDate(new Date());
			loan.setEndDate(DateUtils.addMonths(new Date(), loan.getTenure()));
			loanRequestDAO.persistNewLoanRequest(loan);
			loanRESTRepository.sendApprovalRequest(user, loan);
		}		
		return loan;
	}

	private Boolean getCustomerEligibility(Loan loan) {
		// TODO Auto-generated method stub
		return true;
	}
	
	/*public void convertDate(Loan loan){
		
		DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
		try {
			logger.info("Dateformate in farmator: "+String.valueOf(loan.getEndDate()));
			logger.info("Dateformate in Afterfarmator: "+dateFormat.parse(String.valueOf(loan.getEndDate())));
			loan.setEndDate(dateFormat.parse(String.valueOf(loan.getEndDate())));
			loan.setStartDate(dateFormat.parse(String.valueOf(loan.getStartDate())));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
		}
	}*/
	
	

}
