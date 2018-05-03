import spock.lang.Specification
import spock.lang.Unroll

import com.applicant.criteria.GpaExceptional
import com.applicant.domain.Applicant

class GpaExceptionalCriteriaSpec extends Specification {
	
	@Unroll("Running applicant #applicant with result #validName")
	def "GpaExceptional is valid"() {
		given: "a GpaExceptional criteria evaluator"
			GpaExceptional gpaExceptionalCriteria = new GpaExceptional();
		
		expect: "that only GPA percentages greater than or equal to 90 are accepted"
			gpaExceptionalCriteria.evaluateCriteria(applicant) == validGpa
		
		where: "sample GPA percentages are"
			applicant                                                || validGpa
			new Applicant("Jim", "Mcginnis", 0, null, 90.0, 0, 0, 0) || true
			new Applicant("Jim", "Mcginnis", 0, null, 91.0, 0, 0, 0) || true
			new Applicant("Jim", "Mcginnis", 0, null, 99.0, 0, 0, 0) || true
			new Applicant("Jim", "Mcginnis", 0, null, 89.9, 0, 0, 0) || false
			new Applicant("Jim", "Mcginnis", 0, null, 50.0, 0, 0, 0) || false
	}
}