package com.hcl.loan.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.loan.dao.LoanApprovalDAO;
import com.hcl.loan.model.Loan;
import com.hcl.loan.model.User;
import com.hcl.loan.service.LoanApprovalService;

@Service
public class LoanApprovalServiceImpl implements LoanApprovalService {

	@Autowired
	LoanApprovalDAO loanApprovalDAO;

	@Transactional
	public Loan approvalDecision(Loan loan) {
		Loan approvalLoan = loanApprovalDAO.approvalDecision(loan);
		return approvalLoan;
	}

	@Transactional
	public Loan getAutoApproval(Loan loan) {
		if (loan.isEligible() && getCredibilityScore() > 500) {
			if (loan.getAppliedLoanAmount() <= 1000000) {
				loan.setApprovedLoanAmount(loan.getAppliedLoanAmount());
				loan.setLoanStatus("Approved");
				loan.setRemarks("Auto-approved");
				loan.setPendingWith("None");
				loanApprovalDAO.updateLoan(loan);
				loanApprovalDAO.updateAuditLog(loan);
			} else {
				
				if ((loanApprovalDAO.getHNI(loan.getUserId()) == 1) && loan.getAppliedLoanAmount() <= 5000000) {
					loan.setApprovedLoanAmount(loan.getAppliedLoanAmount() * 0.9);
					loan.setLoanStatus("Approved");
					loan.setRemarks("Auto-approved");
					loan.setPendingWith("None");
					loanApprovalDAO.updateLoan(loan);
					loanApprovalDAO.updateAuditLog(loan);
				} else {
					loan.setApprovedLoanAmount(0.0);
					loan.setLoanStatus("Pending with Manager");
					loan.setRemarks("Loan11");
					loan.setPendingWith("Manager");
					loanApprovalDAO.updateLoan(loan);
					loanApprovalDAO.updateAuditLog(loan);
				}
			}
		} else {
			loan.setApprovedLoanAmount(0.0);
			loan.setLoanStatus("Rejected");
			loan.setRemarks("Customer11");
			loan.setPendingWith("None");
			loanApprovalDAO.updateLoan(loan);
			loanApprovalDAO.updateAuditLog(loan);
		}
		return loan;
	}

	public void getManualApproval(Loan loan) {
		if (loan.getStatus().equalsIgnoreCase("1")) {
			loan.setApprovedLoanAmount(loan.getAppliedLoanAmount());
			loan.setLoanStatus("Approved");
			loan.setRemarks("Manually Approved with full amount");
			loan.setPendingWith("None");
			loanApprovalDAO.updateLoan(loan);
			loanApprovalDAO.updateAuditLog(loan);
		} else {
			loan.setApprovedLoanAmount(0.0);
			loan.setLoanStatus("0");
			loan.setRemarks("Manually Rejected");
			loan.setPendingWith("None");
			loanApprovalDAO.updateLoan(loan);
			loanApprovalDAO.updateAuditLog(loan);
		}

	}

	public List<Loan> getAllPendingLoans(String userId) {
		List<Loan> loanList = new ArrayList<Loan>();
		loanList = loanApprovalDAO.getPendingLoans();
		return loanList;

	}

	private int getCredibilityScore() {
		Random random = new Random();
		return random.nextInt(1500);
	}

}
