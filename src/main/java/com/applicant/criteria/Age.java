package com.applicant.criteria;

import com.applicant.domain.Applicant;
import com.applicant.domain.CriteriaType;
import com.applicant.exception.CriteriaException;

public class Age implements Criteria {

	@Override
	public boolean evaluateCriteria(Applicant applicant) throws CriteriaException {
		int age = applicant.getAge();
		String state = applicant.getState();
		
		if (state == null || state.equals("")) throw new CriteriaException("invalid state");
		
		return ((state.equals("CA") && age >= 17 && age < 26) || age > 80);
	}

	@Override
	public CriteriaType getCriteriaType() {
		return CriteriaType.INSTANT_ACCEPT;
	}

	@Override
	public String getRejectMessage() {
		return "Age must be 17 or older and younger than 26 for California, or over 80";
	}

}
