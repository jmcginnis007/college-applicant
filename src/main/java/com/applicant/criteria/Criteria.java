package com.applicant.criteria;

import com.applicant.domain.Applicant;
import com.applicant.domain.CriteriaType;
import com.applicant.exception.CriteriaException;

public interface Criteria {
	
	boolean evaluateCriteria(Applicant applicant) throws CriteriaException;
	CriteriaType getCriteriaType();
	String getRejectMessage();

}
