package com.hcl.loan.dao;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.hcl.loan.model.Loan;
import com.hcl.loan.model.User;
/**
 * Rest repository service .
 * @author vikash.km
 *
 */

@Repository
public class LoanRESTRepositoryImpl implements LoanRESTRepository{
	
	private static final Logger LOGGER = Logger.getLogger(LoanRESTRepositoryImpl.class);
	private RestTemplate restTemplate;
	private HttpHeaders header;
	@Value("${emi.calculator.url}")
	private String emiCalculatorUrl;
	
	public LoanRESTRepositoryImpl(final RestTemplate restTemplate, final HttpHeaders header) {
		this.restTemplate = restTemplate;
		this.header = header;
	}
	/**
	 * Method consumes EMI Calculator REST service based on requested parameter.
	 * First it generates URL which will send through GET method with the help
	 * of RestTemplate.
	 * @param appliedLoanAmount
	 * @param loanDuration
	 * @param rateOfInterest
	 * @return EMI.
	 */
	@Override
	public Double fetchCalculatedEMI(final Loan loan) {

		header.setContentType(MediaType.APPLICATION_JSON_UTF8);

		HttpEntity<String> requestEntity = new HttpEntity<>(header);

		ResponseEntity<Loan> responseEntity = null;
		String requestURL = generateRequestURL(loan);
		Loan loanEMIRsponse = new Loan();
		try {

			responseEntity = restTemplate.exchange(requestURL, HttpMethod.GET, requestEntity, Loan.class);
			if (responseEntity != null) {
				loanEMIRsponse = responseEntity.getBody();
			}

		} catch (RestClientException exception) {
			LOGGER.error("There are issues with emi calculator:", exception);
		}
		return loanEMIRsponse.getMonthlyEMI();
	}
	
	private String generateRequestURL(final Loan loan){
		StringBuilder urlBuilder = new StringBuilder(emiCalculatorUrl);
		return urlBuilder.append("?").append("appliedLoanAmount="+loan.getAppliedLoanAmount()).append("&")
		.append("loanDuration="+loan.getTenure()).append("&").append("rateOfInterest="+loan.getMonthlyInterest()).toString();
	}
	/**
	 * Send request for loan approval.
	 * @param user
	 * @param loan
	 */
	@Override
	public void sendApprovalRequest(final User user, final Loan loan) {

		header.setContentType(MediaType.APPLICATION_JSON_UTF8);

		HttpEntity<User> requestEntity = new HttpEntity<>(user);

		ResponseEntity<String> responseEntity = null;
		String requestURL = "http://localhost:8090/lms/";
		try {

			responseEntity = restTemplate.exchange(requestURL, HttpMethod.POST, requestEntity, String.class);
			if (responseEntity != null) {
				String approvalRequest = responseEntity.getBody();
			}

		} catch (RestClientException exception) {
			LOGGER.error("There are issues while sending :", exception);
		}
	}
	

}
