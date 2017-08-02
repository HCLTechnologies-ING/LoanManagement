package com.hcl.loan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.loan.model.Loan;

@Service
public interface LoanApprovalService {

	public Loan getAutoApproval(Loan loan);

	public void getManualApproval(Loan loan);

	public List<Loan> getAllPendingLoans(String userId);

}
