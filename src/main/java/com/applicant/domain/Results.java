package com.applicant.domain;

import java.util.Set;

public class Results {
	
	private ApplicantStatus status;
	private Set<String> declineMessages;
	
	
	public Results(ApplicantStatus status) {
		super();
		this.status = status;
	}

	public Results(ApplicantStatus status, Set<String> declineMessages) {
		super();
		this.status = status;
		this.declineMessages = declineMessages;
	}

	public ApplicantStatus getStatus() {
		return status;
	}

	public Set<String> getDeclineMessages() {
		return declineMessages;
	}

	@Override
	public String toString() {
		return "Results [status=" + status + ", declineMessages=" + declineMessages + "]";
	}	

}
