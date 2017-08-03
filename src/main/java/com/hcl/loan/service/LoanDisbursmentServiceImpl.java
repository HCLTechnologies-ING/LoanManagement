 package com.hcl.loan.service;



import java.util.ArrayList;

import java.util.List;



import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;



import com.hcl.loan.dao.LoanDisbursmentDao;

import com.hcl.loan.dao.LoanDisbursmentDaoImpl;

import com.hcl.loan.model.Loan;

import com.hcl.loan.model.LoanDisbursment;

import com.hcl.loan.model.User;



@Service

public class LoanDisbursmentServiceImpl implements LoanDisbursmentService {



        

				

	

	private static final Logger logger = Logger.getLogger(LoanDisbursmentServiceImpl.class);



	

	

	@Autowired

    private LoanDisbursmentDao loanDisbursmentDao;



              

                /*

                *

                */

                public void updateLoanDisbursmentDetails(LoanDisbursment loanDisb) {

                	loanDisbursmentDao.save(loanDisb);

                }



                public List<Loan> findAllApprovedLoans() {

                	

                	List<Loan> appLoan = new ArrayList();

                	

                	appLoan =loanDisbursmentDao.findApprovedLoanDeatils();

                	               	

                	return appLoan;

                }



}

