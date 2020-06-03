package com.candidatemanagement.model;

public class Candidate {
	
	private long id;
	private String name;
	private String email;
	private String institute;
	private long contact;
	private String description;
	private String location;
	private String skills;
	private String joiningDate;
	private String feedback;
	
	
	public Candidate() {}

	public Candidate(String name, String email, String institute, long contact, String description,
			String location, String skills, String joiningDate) {
		super();
		this.name = name;
		this.email = email;
		this.institute = institute;
		this.contact = contact;
		this.description = description;
		this.location = location;
		this.skills = skills;
		this.joiningDate = joiningDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInstitute() {
		return institute;
	}

	public void setInstitute(String institute) {
		this.institute = institute;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	@Override
	public String toString() {
		return "Candidate [id=" + id + ", name=" + name + ", email=" + email + ", institute=" + institute + ", contact="
				+ contact + ", description=" + description + ", location=" + location + ", skills=" + skills
				+ ", joiningDate=" + joiningDate + ", feedback=" + feedback + "]";
	}
	
	
}
