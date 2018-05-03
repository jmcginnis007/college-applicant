package com.applicant.domain;

public class Applicant {
	
	private String firstName;
	private String lastName;
	private int age;
	private String state;
	private double gpaPercentage;
	private int satScore;
	private int actScore;
	private int felonies;
	
	
	public Applicant() {
	}

	public Applicant(String firstName, String lastName, int age, String state, double gpaPercentage, int satScore,
			int actScore, int felonies) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.state = state;
		this.gpaPercentage = gpaPercentage;
		this.satScore = satScore;
		this.actScore = actScore;
		this.felonies = felonies;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	public String getState() {
		return state;
	}

	public double getGpaPercentage() {
		return gpaPercentage;
	}

	public int getSatScore() {
		return satScore;
	}

	public int getActScore() {
		return actScore;
	}

	public int getFelonies() {
		return felonies;
	}

	@Override
	public String toString() {
		return "Applicant [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", state=" + state
				+ ", gpaPercentage=" + gpaPercentage + ", satScore=" + satScore + ", actScore=" + actScore
				+ ", felonies=" + felonies + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + actScore;
		result = prime * result + age;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + satScore;
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Applicant other = (Applicant) obj;
		if (actScore != other.actScore)
			return false;
		if (age != other.age)
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (satScore != other.satScore)
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}
}
