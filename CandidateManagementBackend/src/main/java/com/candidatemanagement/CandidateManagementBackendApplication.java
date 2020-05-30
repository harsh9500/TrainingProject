package com.candidatemanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.candidatemanagement.model.Candidate;
import com.candidatemanagement.repository.CandidateRepository;

@SpringBootApplication
public class CandidateManagementBackendApplication implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CandidateRepository candidateRepository = new CandidateRepository();
 
    @Override
    public void run(String... args) throws Exception {

//        logger.info("Inserting -> {}", candidateRepository.insert(new Candidate(101L, "ABC", "abc@gmail.com")));
//        logger.info("Inserting -> {}", candidateRepository.insert(new Candidate(102L, "PQR","pqr@gmail.com")));
//        logger.info("Inserting -> {}", candidateRepository.insert(new Candidate(103L, "XYZ","xyz@gmail.com")));
//  
//        logger.info("Employee id 101 -> {}", candidateRepository.findById(101L));
//
//        logger.info("Update 101 -> {}", candidateRepository.update(new Candidate(101L, "IJK", "ijk@gmail.com")));
//
//        candidateRepository.deleteById(103L);
//
//        logger.info("All users -> {}", candidateRepository.findAll());
    }
	
	public static void main(String[] args) {
		SpringApplication.run(CandidateManagementBackendApplication.class, args);
	}

}
