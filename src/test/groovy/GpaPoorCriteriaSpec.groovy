import spock.lang.Specification
import spock.lang.Unroll

import com.applicant.criteria.GpaPoor
import com.applicant.domain.Applicant

class GpaPoorCriteriaSpec extends Specification {
	
	@Unroll("Running applicant #applicant with result #validName")
	def "GpaPoor is valid"() {
		given: "a GpaPoor criteria evaluator"
			GpaPoor gpaPoorCriteria = new GpaPoor();
		
		expect: "that GPA percentages less than 70 are rejected"
			gpaPoorCriteria.evaluateCriteria(applicant) == validGpa
		
		where: "sample GPA percentages are"
			applicant                                                || validGpa
			new Applicant("Jim", "Mcginnis", 0, null, 70.0, 0, 0, 0) || true
			new Applicant("Jim", "Mcginnis", 0, null, 71.0, 0, 0, 0) || true
			new Applicant("Jim", "Mcginnis", 0, null, 99.0, 0, 0, 0) || true
			new Applicant("Jim", "Mcginnis", 0, null, 69.9, 0, 0, 0) || false
			new Applicant("Jim", "Mcginnis", 0, null, 50.0, 0, 0, 0) || false
	}
}