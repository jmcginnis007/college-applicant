package com.applicant.collegeapplicant;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.applicant.criteria.Felonies;
import com.applicant.criteria.Name;
import com.applicant.domain.Applicant;
import com.applicant.exception.CriteriaException;

@RunWith(SpringRunner.class)
public class CollegeApplicantApplicationTests {

	@Test
	public void testNameCriteria() {
		try {
			assertTrue("name should be fine", evaluateNameCriteria("Jim", "Mcginnis"));
			assertFalse("name should be invalid, too many caps", evaluateNameCriteria("Jim", "McGinnis"));
			assertFalse("name should be invalid, no caps", evaluateNameCriteria("jim", "mcginnis"));
			assertFalse("name should be invalid, all caps", evaluateNameCriteria("JIM", "MCGINNIS"));
		} catch (CriteriaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private boolean evaluateNameCriteria(String firstName, String lastName) throws CriteriaException
	{
		Applicant applicant = new Applicant(firstName, lastName, 25, "MA", 91.0, 1900, 28, 0);
		
		Name nameCriteria = new Name();
		return nameCriteria.evaluateCriteria(applicant);
		
	}
	
	@Test
	public void testFelonies() {
		try {
			assertTrue("zero felonies should pass", evaluateFeloniesCriteria(0));
			assertFalse("one felony should fail", evaluateFeloniesCriteria(1));
			assertFalse("five felonies should fail", evaluateFeloniesCriteria(5));
		}
		catch (CriteriaException e) {
			e.printStackTrace();
		}
	}
	
	private boolean evaluateFeloniesCriteria(int felonies) throws CriteriaException
	{
		Applicant applicant = new Applicant("Jim", "McGinnis", 25, "MA", 91.0, 1900, 28, felonies);
		
		Felonies feloniesCriteria = new Felonies();
		return feloniesCriteria.evaluateCriteria(applicant);
		
	}

}
