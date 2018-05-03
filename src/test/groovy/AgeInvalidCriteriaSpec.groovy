import spock.lang.Specification
import spock.lang.Unroll

import com.applicant.criteria.AgeInvalid
import com.applicant.domain.Applicant

class AgeInvalidCriteriaSpec extends Specification {
	
	@Unroll("Running applicant #applicant with result #validName")
	def "Age is valid"() {
		given: "a AgeInvalid criteria evaluator"
			AgeInvalid ageInvalidCriteria = new AgeInvalid();
		
		expect: "that only ages greater than zero are accepted"
			ageInvalidCriteria.evaluateCriteria(applicant) == validAge
		
		where: "sample ages are"
			applicant                                                || validAge
			new Applicant("Jim", "Mcginnis", -1, null, 0.0, 0, 0, 0) || false
			new Applicant("Jim", "Mcginnis", 0, null, 0.0, 0, 0, 0)  || false
			new Applicant("Jim", "Mcginnis", 1, null, 0.0, 0, 0, 0)  || true		
			new Applicant("Jim", "Mcginnis", 21, null, 0.0, 0, 0, 0) || true
	}
}