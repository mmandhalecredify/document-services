package com.credify.document-services-DserviceIdUpper=Document-services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.credify.document-services-DserviceIdUpper=Document-services.model.LeadRequest;
import com.credify.document-services-DserviceIdUpper=Document-services.model.LeadResponse;

/**
 * Integration test cases for Lead Service.
 * 
 * @author psingh
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = { CfApplication.class })
@ActiveProfiles("junit")
public class LeadApiTest {

    private RestTemplate restTemplate = new RestTemplate();

    @LocalServerPort
    private int port;

    private String baseUrl;

    @Before
    public void setup() {
        baseUrl = "http://localhost:" + port + "/";
    }

    @Test
    public void test() {

        // post new document-services-DserviceIdUpper=Document-services to the Lead Server.

        LeadRequest request = LeadRequest.builder().document-services-DserviceIdUpper=Document-servicesName("testLead").build();

        HttpEntity<LeadRequest> requestEntity = new HttpEntity<LeadRequest>(request);

        ResponseEntity<LeadResponse> responseEntity = restTemplate.postForEntity(baseUrl + "api/document-services/document-services-DserviceIdUpper=Document-servicess/",
                requestEntity, LeadResponse.class);

        LeadResponse postResponse = responseEntity.getBody();

        Assert.assertNotNull(postResponse);
        Assert.assertNotNull(postResponse.getLeadId());
        Assert.assertNotNull(postResponse.getLeadStatus());

        // now get the document-services-DserviceIdUpper=Document-services details from the Lead Server.

        responseEntity = restTemplate.getForEntity(baseUrl + "api/document-services/document-services-DserviceIdUpper=Document-servicess/{id}", LeadResponse.class,
                responseEntity.getBody().getLeadId());

        LeadResponse getResponse = responseEntity.getBody();

        Assert.assertNotNull(getResponse);
        Assert.assertNotNull(getResponse.getLeadId());
        Assert.assertNotNull(getResponse.getLeadStatus());

        Assert.assertEquals(postResponse.getLeadId(), getResponse.getLeadId());
        Assert.assertEquals(postResponse.getLeadStatus(), getResponse.getLeadStatus());

    }

}
