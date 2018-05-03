import spock.lang.Specification
import spock.lang.Unroll

import com.applicant.criteria.Felonies
import com.applicant.domain.Applicant

class FeloniesCriteriaSpec extends Specification {
	
	@Unroll("Running applicant #applicant with result #validName")
	def "Felonies is valid"() {
		given: "a Felonies criteria evaluator"
			Felonies feloniesCriteria = new Felonies();
		
		expect: "that only felony counts of zero are accepted"
			feloniesCriteria.evaluateCriteria(applicant) == validFelonies
		
		where: "sample felonies are"
			applicant                                               || validFelonies
			new Applicant("Jim", "Mcginnis", 0, null, 0.0, 0, 0, 0) || true
			new Applicant("Jim", "Mcginnis", 0, null, 0.0, 0, 0, 1) || false
			new Applicant("Jim", "Mcginnis", 0, null, 0.0, 0, 0, 2) || false
			new Applicant("Jim", "Mcginnis", 0, null, 0.0, 0, 0, 5) || false
	}
}