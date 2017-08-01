package com.hcl.loan.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.loan.dao.LoanDisbursmentDao;
import com.hcl.loan.model.Loan;
import com.hcl.loan.model.LoanDisbursment;
import com.hcl.loan.model.User;

@Service("loanService")
@Transactional
public class LoanDisbursmentServiceImpl implements LoanDisbursmentService {

                @Autowired
                private LoanDisbursmentDao loanDisbursmentDao;

              
                /*
                *
                */
                public void updateLoanDisbursmentDetails(LoanDisbursment loanDisb) {
                	loanDisbursmentDao.save(loanDisb);
                }

                public List<Loan> findAllApprovedLoans() {
                	
                	List appLoan = new ArrayList<Loan>();
                	
                	appLoan =loanDisbursmentDao.findApprovedLoanDeatils();
                	               	
                	return appLoan;
                }

}

