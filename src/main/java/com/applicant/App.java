package com.applicant;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.applicant.criteria.suite.AllCriteria;
import com.applicant.criteria.suite.CriteriaSuite;
import com.applicant.domain.Applicant;
import com.applicant.domain.Results;
import com.applicant.exception.CriteriaException;
import com.applicant.service.CriteriaService;

@SpringBootApplication
public class App {
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Bean
	public CommandLineRunner demo(CriteriaService service) {
		return (args) -> {			
			CriteriaSuite suite = new AllCriteria();
			Applicant applicant = new Applicant("Jim", "McGinnis", -1, "CA", 91.0, 1990, 28, 1);
			
			try {
				Results status = service.processCriteriaSuiteForApplicant(suite, applicant);
				System.out.println(status);
			} catch (CriteriaException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		};
	}
}
