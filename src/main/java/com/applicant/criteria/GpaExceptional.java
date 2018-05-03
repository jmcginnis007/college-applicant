package com.applicant.criteria;

import com.applicant.domain.Applicant;
import com.applicant.domain.CriteriaType;
import com.applicant.exception.CriteriaException;

public class GpaExceptional implements Criteria {

	@Override
	public boolean evaluateCriteria(Applicant applicant) throws CriteriaException {
		return (applicant.getGpaPercentage() >= 90);
	}

	@Override
	public CriteriaType getCriteriaType() {
		return CriteriaType.INSTANT_ACCEPT;
	}

	@Override
	public String getRejectMessage() {
		return "High school GPA percentage must be 90% or higher";
	}

}
