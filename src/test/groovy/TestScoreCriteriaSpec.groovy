import spock.lang.Specification
import spock.lang.Unroll

import com.applicant.criteria.TestScore
import com.applicant.domain.Applicant

class TestScoreCriteriaSpec extends Specification {
	
	@Unroll("Running applicant #applicant with result #validName")
	def "Test Score is valid"() {
		given: "a TestScore criteria evaluator"
			TestScore testScoreCriteria = new TestScore();
		
		expect: "that only SAT scores greater than 1919 or ACT scores greater than 26 are accepted"
			testScoreCriteria.evaluateCriteria(applicant) == validTestScore
		
		where: "sample test scores are"
			applicant                                                  || validTestScore
			new Applicant("Jim", "Mcginnis", 0, null, 0.0, 1920, 0, 0) || true
			new Applicant("Jim", "Mcginnis", 0, null, 0.0, 2000, 0, 0) || true
			new Applicant("Jim", "Mcginnis", 0, null, 0.0, 1919, 0, 0) || false
			new Applicant("Jim", "Mcginnis", 0, null, 0.0, 1900, 0, 0) || false
			new Applicant("Jim", "Mcginnis", 0, null, 0.0, 1000, 0, 0) || false
			new Applicant("Jim", "Mcginnis", 0, null, 0.0, 0, 27, 0)   || true
			new Applicant("Jim", "Mcginnis", 0, null, 0.0, 0, 30, 0)   || true
			new Applicant("Jim", "Mcginnis", 0, null, 0.0, 0, 26, 0)   || false
			new Applicant("Jim", "Mcginnis", 0, null, 0.0, 0, 25, 0)   || false
			new Applicant("Jim", "Mcginnis", 0, null, 0.0, 0, 20, 0)   || false
			new Applicant("Jim", "Mcginnis", 0, null, 0.0, 1930, 30, 0)|| true
	}
}