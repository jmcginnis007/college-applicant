import spock.lang.Specification
import spock.lang.Unroll

import com.applicant.criteria.Age
import com.applicant.domain.Applicant
import com.applicant.exception.CriteriaException

class AgeCriteriaSpec extends Specification {
	
	@Unroll("Running applicant #applicant with result #validAge")
	def "Age is valid"() {
		given: "an age criteria evaluator"
			Age ageCriteria = new Age();
		
		expect: "Age must be 17 or older and younger than 26 for California, or over 80"
			ageCriteria.evaluateCriteria(applicant) == validAge
		
		where: "sample ages and states are"
			applicant                                                || validAge
			new Applicant("Jim", "Mcginnis", 25, "CA", 0.0, 0, 0, 0) || true
			new Applicant("Jim", "Mcginnis", 17, "CA", 0.0, 0, 0, 0) || true
			new Applicant("Jim", "Mcginnis", 81, "CA", 0.0, 0, 0, 0) || true
			new Applicant("Jim", "Mcginnis", 81, "MA", 0.0, 0, 0, 0) || true
			new Applicant("Jim", "Mcginnis", 20, "MA", 0.0, 0, 0, 0) || false
			new Applicant("Jim", "Mcginnis", 26, "CA", 0.0, 0, 0, 0) || false
			new Applicant("Jim", "Mcginnis", 16, "CA", 0.0, 0, 0, 0) || false
			new Applicant("Jim", "Mcginnis", 25, "MA", 0.0, 0, 0, 0) || false
			new Applicant("Jim", "Mcginnis", 80, "CA", 0.0, 0, 0, 0) || false
			new Applicant("Jim", "Mcginnis", 80, "MA", 0.0, 0, 0, 0) || false		
	}
	
	def "State is invalid"() {
		given: "an age criteria evaluator"
			Age ageCriteria = new Age();
		
		when: "the state is not valid"
			ageCriteria.evaluateCriteria(new Applicant("Jim", "Mcginnis", 25, null, 0.0, 0, 0, 0));
		
		then: "an exception is thrown"
			thrown(CriteriaException)
	}
}