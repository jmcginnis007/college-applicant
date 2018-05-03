import spock.lang.Specification
import spock.lang.Unroll

import com.applicant.criteria.Name
import com.applicant.domain.Applicant

class NameCriteriaSpec extends Specification {
	
	@Unroll("Running applicant #applicant with result #validName")
	def "Name is valid"() {
		given: "a name criteria evaluator"
			Name nameCriteria = new Name();
		
		expect: "that only names with just the first letter capitalized are accepted"
			nameCriteria.evaluateCriteria(applicant) == validName
		
		where: "sample names are"
			applicant                                               || validName
			new Applicant("Jim", "Mcginnis", 0, null, 0.0, 0, 0, 0) || true
			new Applicant("Jim", "McGinnis", 0, null, 0.0, 0, 0, 0) || false
			new Applicant("jim", "mcginnis", 0, null, 0.0, 0, 0, 0) || false
			new Applicant("JIM", "MCGINNIS", 0, null, 0.0, 0, 0, 0) || false
			new Applicant("jIm", "mCginnis", 0, null, 0.0, 0, 0, 0) || false
		
	}
}