package com.hcl.loan.dao;

import com.hcl.loan.model.Loan;
import com.hcl.loan.model.User;
/**
 * Loan REST Repository Service.
 * @author vikash.km
 *
 */
public interface LoanRESTRepository {
	
	public Double fetchCalculatedEMI(final Loan loan);
	public void sendApprovalRequest(final User user, final Loan loan);

}
