package com.applicant.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.applicant.criteria.Criteria;
import com.applicant.criteria.suite.CriteriaSuite;
import com.applicant.domain.Applicant;
import com.applicant.domain.ApplicantStatus;
import com.applicant.domain.Results;
import com.applicant.exception.CriteriaException;

@Service
public class CriteriaService {
	
	public Results processCriteriaSuiteForApplicant(final CriteriaSuite suite, final Applicant applicant) throws CriteriaException {
		
		Set<String> rejectionReasons = new HashSet<>();
		boolean instantAccept = true;
		
		List<Criteria> criteriaList = suite.getCriteria();
		
		if (criteriaList == null || criteriaList.size() == 0) throw new CriteriaException("invalid criteria suite -- no criteria found.");
		
		for (Criteria criteria : criteriaList) {
			boolean passes = criteria.evaluateCriteria(applicant);
			if (!passes) {
				switch (criteria.getCriteriaType()) {
				case INSTANT_REJECT:
					rejectionReasons.add(criteria.getRejectMessage());
					break;
				case INSTANT_ACCEPT:
					instantAccept = false;
					break;
				}					
			}
		}
		
		if (rejectionReasons.size() > 0) 
			return new Results(ApplicantStatus.REJECTED, rejectionReasons);		
		if (instantAccept) 
			return new Results(ApplicantStatus.ACCEPTED);
		

		return new Results(ApplicantStatus.FURTHER_REVIEW_NEEDED);
	}
}
