package com.applicant.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.applicant.criteria.suite.AllCriteria;
import com.applicant.criteria.suite.CriteriaSuite;
import com.applicant.domain.Applicant;
import com.applicant.domain.Results;
import com.applicant.exception.CriteriaException;
import com.applicant.service.CriteriaService;

@RestController
@RequestMapping("/applicant")
public class ApplicantController {
	
	@Autowired
	CriteriaService service;
	
	@RequestMapping(value = "/evaluate", method = RequestMethod.GET)
	public Results evaluateApplicant(@RequestParam(value="firstName") String firstName, 
			@RequestParam(value="lastName") String lastName,
			@RequestParam(value="age") int age,
			@RequestParam(value="state") String state,
			@RequestParam(value="gpaPercentage") double gpaPercentage,
			@RequestParam(value="satScore") int satScore,
			@RequestParam(value="actScore") int actScore,
			@RequestParam(value="felonies") int felonies) throws CriteriaException {
		
		Results status;
		CriteriaSuite suite = new AllCriteria();
		Applicant applicant = new Applicant(firstName, lastName, age, state, gpaPercentage, satScore, actScore, felonies);
		
		try {
			status = service.processCriteriaSuiteForApplicant(suite, applicant);
			return status;
		} catch (CriteriaException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@RequestMapping(value = "/evaluate", method = RequestMethod.POST)
	public Results evaluateApplicant(@RequestBody Applicant applicant) throws CriteriaException {
		Results status;
		CriteriaSuite suite = new AllCriteria();
		
		try {
			status = service.processCriteriaSuiteForApplicant(suite, applicant);
			return status;
		} catch (CriteriaException e) {
			e.printStackTrace();
			throw e;
		}
	}

}
