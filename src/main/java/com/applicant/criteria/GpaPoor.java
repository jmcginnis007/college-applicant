package com.applicant.criteria;

import com.applicant.domain.Applicant;
import com.applicant.domain.CriteriaType;
import com.applicant.exception.CriteriaException;

public class GpaPoor implements Criteria {

	@Override
	public boolean evaluateCriteria(Applicant applicant) throws CriteriaException {
		return (applicant.getGpaPercentage() >= 70);
	}

	@Override
	public CriteriaType getCriteriaType() {
		return CriteriaType.INSTANT_REJECT;
	}

	@Override
	public String getRejectMessage() {
		return "High school GPA percentage is below 70%";
	}

}
