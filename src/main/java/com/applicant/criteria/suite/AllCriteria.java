package com.applicant.criteria.suite;

import java.util.ArrayList;
import java.util.List;

import com.applicant.criteria.Age;
import com.applicant.criteria.AgeInvalid;
import com.applicant.criteria.Criteria;
import com.applicant.criteria.Felonies;
import com.applicant.criteria.GpaExceptional;
import com.applicant.criteria.GpaPoor;
import com.applicant.criteria.Name;
import com.applicant.criteria.TestScore;

public class AllCriteria implements CriteriaSuite {

	@Override
	public List<Criteria> getCriteria() {
		
		ArrayList<Criteria> criteriaList = new ArrayList<Criteria>(7);
		criteriaList.add(new Age());
		criteriaList.add(new AgeInvalid());
		criteriaList.add(new Felonies());
		criteriaList.add(new GpaExceptional());
		criteriaList.add(new GpaPoor());
		criteriaList.add(new Name());
		criteriaList.add(new TestScore());
		
		return criteriaList;
	}

}
