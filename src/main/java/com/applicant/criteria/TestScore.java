package com.applicant.criteria;

import com.applicant.domain.Applicant;
import com.applicant.domain.CriteriaType;
import com.applicant.exception.CriteriaException;

public class TestScore implements Criteria {
	
	private static final int MIN_SAT_SCORE = 1920;
	private static final int MIN_ACT_SCORE = 27;

	@Override
	public boolean evaluateCriteria(Applicant applicant) throws CriteriaException {
		return (applicant.getSatScore() >= MIN_SAT_SCORE || applicant.getActScore() >= MIN_ACT_SCORE);
	}

	@Override
	public CriteriaType getCriteriaType() {
		return CriteriaType.INSTANT_ACCEPT;
	}

	@Override
	public String getRejectMessage() {
		return "SAT score must be greater than " + MIN_SAT_SCORE + " or ACT score greater than " + MIN_ACT_SCORE;
	}

}
