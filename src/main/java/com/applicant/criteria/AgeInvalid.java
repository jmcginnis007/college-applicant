package com.applicant.criteria;

import com.applicant.domain.Applicant;
import com.applicant.domain.CriteriaType;
import com.applicant.exception.CriteriaException;

public class AgeInvalid implements Criteria {

	@Override
	public boolean evaluateCriteria(Applicant applicant) throws CriteriaException {		
		return (applicant.getAge() > 0);
	}

	@Override
	public CriteriaType getCriteriaType() {
		return CriteriaType.INSTANT_REJECT;
	}

	@Override
	public String getRejectMessage() {
		return "Invalid age.  Must not be less than zero.";
	}

}
