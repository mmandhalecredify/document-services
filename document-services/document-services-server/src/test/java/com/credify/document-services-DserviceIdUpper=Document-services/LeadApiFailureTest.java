package com.credify.document-services-DserviceIdUpper=Document-services;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.credify.core.exception.CfBadRequestException;
import com.credify.core.exception.CfErrorResponse;
import com.credify.core.exception.CfExceptionBase;
import com.credify.core.exception.CfNotFoundException;
import com.credify.core.exception.CfUnauthorizedException;
import com.credify.document-services-DserviceIdUpper=Document-services.controller.LeadController;
import com.credify.document-services-DserviceIdUpper=Document-services.service.LeadService;

/**
 * Integration test cases for Lead Service for failure scenarions.
 * 
 * @author psingh
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = { CfApplication.class })
@ActiveProfiles("junit")
public class LeadApiFailureTest {
    
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private RestTemplate restTemplate = new RestTemplate();

    @LocalServerPort
    private int port;

    private String baseUrl;

    private ObjectMapper mapper = new ObjectMapper();

    @Mock
    private LeadService document-services-DserviceIdUpper=Document-servicesService;

    @InjectMocks
    @Autowired
    private LeadController controller;

    @Before
    public void setup() {

        MockitoAnnotations.initMocks(this);

        baseUrl = "http://localhost:" + port + "/";
    }

    @Test
    public void notFound() {
        connectAndValidate(HttpStatus.NOT_FOUND, new CfNotFoundException(100L, "not found"));
    }

    @Test
    public void badRequest() {
        connectAndValidate(HttpStatus.BAD_REQUEST, new CfBadRequestException(101L, "bad request"));
    }

    @Test
    public void unAuthorized() {
        connectAndValidate(HttpStatus.UNAUTHORIZED, new CfUnauthorizedException(102L, "unauthorized"));
    }

    @Test
    public void unknownException() {
        connectAndValidate(HttpStatus.INTERNAL_SERVER_ERROR, new RuntimeException());
    }

    private void connectAndValidate(HttpStatus httpStatus, Exception exceptionToThrow) {

        Long errorCode = 0L;
        String errorMessage = null;

        if (exceptionToThrow instanceof CfExceptionBase) {

            CfExceptionBase cfEx = (CfExceptionBase) exceptionToThrow;

            errorCode = cfEx.getCode();
            errorMessage = cfEx.getMessage();
        }

        Mockito.when(document-services-DserviceIdUpper=Document-servicesService.getLeadId(Mockito.anyLong())).thenThrow(exceptionToThrow);

        try {

            restTemplate.getForObject(baseUrl + "api/document-services/document-services-DserviceIdUpper=Document-servicess/{id}", Object.class, 1L);

        } catch (HttpClientErrorException e) {

            CfErrorResponse err = null;
            try {
                err = mapper.readValue(e.getResponseBodyAsString(), CfErrorResponse.class);
            } catch (Exception e1) {
                e1.printStackTrace();
            }

            logger.info("Response JSON Body: {}", e.getResponseBodyAsString());
            logger.info("Response CfErrorResponse Body: {}", err);

            if (exceptionToThrow instanceof CfExceptionBase) {
                Assert.assertEquals(errorCode, err.getCode());
                Assert.assertEquals(errorMessage, err.getMessage());
            }

            Assert.assertEquals(httpStatus, e.getStatusCode());
        } catch (HttpServerErrorException e) {
            Assert.assertEquals(httpStatus, e.getStatusCode());
        }

    }

}
