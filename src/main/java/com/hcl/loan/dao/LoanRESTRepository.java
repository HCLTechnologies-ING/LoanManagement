package com.hcl.loan.dao;

import com.hcl.loan.model.Loan;

public interface LoanRESTRepository {
	
	public Double fetchCalculatedEMI(final Loan loan);

}
