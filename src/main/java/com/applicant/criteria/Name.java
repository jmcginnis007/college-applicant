package com.applicant.criteria;

import com.applicant.domain.Applicant;
import com.applicant.domain.CriteriaType;
import com.applicant.exception.CriteriaException;

public class Name implements Criteria {

	@Override
	public boolean evaluateCriteria(Applicant applicant) throws CriteriaException {
		return (applicant.getFirstName().matches("[A-Z][a-z]+") && 
				 applicant.getLastName().matches("[A-Z][a-z]+"));
	}

	@Override
	public CriteriaType getCriteriaType() {
		return CriteriaType.INSTANT_REJECT;
	}

	@Override
	public String getRejectMessage() {
		return "Name is not properly cased";
	}

}
