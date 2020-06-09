package com.candidatemanagement.integrationtest;

import static org.junit.Assert.assertNotNull;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.candidatemanagement.dao.CandidateDao;
import com.candidatemanagement.model.Candidate;

import io.cucumber.java.en.When;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class StepDefinitions {
	
	@LocalServerPort
    private int port;
	
	private RestTemplate restTemplate = new RestTemplate();
	
	@MockBean
	private CandidateDao candidateDao;
	
	
    private String postUrl = "http://localhost";
    
    @When("I send a candidate to be created")
    public void i_send_a_candidate_to_be_created() {
    	String url = postUrl + ":" + port + "/candidates";
        Candidate newCandidate = new Candidate("Harsh","harsh@gmail.com","DJSCE",1234567890,"SDE","Mumbai","C++ Java","2020-05-11");
        ResponseEntity<?> response = restTemplate.postForEntity(url, newCandidate, ResponseEntity.class);
        assertThat(response.getStatusCodeValue()).isEqualTo(HttpStatus.CREATED.value());
    }

    @When("I wish to view all candidates")
    public void i_wish_to_view_all_candidates() {
    	String url = postUrl + ":" + port + "/candidates";
    	List<Candidate> list = restTemplate.getForObject(url, List.class);
    	assertNotNull(list);
    }

}
