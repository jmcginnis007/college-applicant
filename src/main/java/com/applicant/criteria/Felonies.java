package com.applicant.criteria;

import com.applicant.domain.Applicant;
import com.applicant.domain.CriteriaType;
import com.applicant.exception.CriteriaException;

public class Felonies implements Criteria {

	@Override
	public boolean evaluateCriteria(Applicant applicant) throws CriteriaException {
		return (applicant.getFelonies() == 0);
	}

	@Override
	public CriteriaType getCriteriaType() {
		return CriteriaType.INSTANT_REJECT;
	}

	@Override
	public String getRejectMessage() {
		return "Has 1 or more felonies in the past 5 years";
	}

}
