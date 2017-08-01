package com.hcl.loan.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.hcl.loan.model.Loan;
import com.hcl.loan.model.LoanDisbursment;



 
@PropertySource("classpath:scr/main/resources/sql.properties") 
@Repository("LoanDisbursment")
public class LoanDisbursmentDaoImpl implements LoanDisbursmentDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
     
    @Autowired
    Environment env;

    public LoanDisbursmentDaoImpl(DataSource aDataSource)
    {
    	jdbcTemplate =new JdbcTemplate(aDataSource);
    }
	
	public List<Loan> findApprovedLoanDeatils() {
       
		List<Loan> loanDtl = new ArrayList<Loan>();
    	
       
    	
		loanDtl  =  jdbcTemplate.query(env.getProperty("APPROVED_LOAN_QUERY"), new Object[] { },
    		   new RowMapper<Loan>()
    		   {
    	   			public Loan mapRow(ResultSet rs,int rownum) throws SQLException
    	   				{
    	   				Loan lnDtl = new Loan();
    	   				lnDtl.setLoanId(rs.getLong(0));
    	   				return lnDtl;
    	   				}
    		   });
       return loanDtl;
       
    }

    public boolean save(LoanDisbursment loanDisb) 
    {
    	jdbcTemplate.update(env.getProperty("LOAN_DISB_INSERT"),new Object[]{loanDisb.getDisbursmentDate(),loanDisb.getNumberOfChecks(),loanDisb.getDisbursmentMode(),loanDisb.getEmailNotification(),loanDisb.getAccountNumber()},
    			new Object[]{Types.DATE,Types.INTEGER,Types.VARCHAR,Types.CHAR,Types.LONGNVARCHAR});
    	    	
    	return true;
    }

     
 
}

