package com.credify.document-services-DserviceIdUpper=Document-services.client.driver;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.credify.document-services-DserviceIdUpper=Document-services.client.LeadServiceClientGateway;
import com.credify.document-services-DserviceIdUpper=Document-services.client.config.LeadClientConfig;
import com.credify.document-services-DserviceIdUpper=Document-services.model.LeadRequest;
import com.credify.document-services-DserviceIdUpper=Document-services.model.LeadResponse;

/**
 * Testing Lead Service Client.
 * 
 * @author psingh
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@formatter:off
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, 
classes = LeadClientDriver.ContextConfiguration.class)
//@formatter:on
public class LeadClientDriver {

    private static final Logger LOGGER = LoggerFactory.getLogger(LeadClientDriver.class);

    /**
     * main config for the client.
     * 
     * @author psingh
     *
     */
    @Configuration
    @Import({ LeadClientConfig.class })
    static class ContextConfiguration {

    }

    @Autowired
    private LeadServiceClientGateway document-services-DserviceIdUpper=Document-servicesClient;

    @Test
    public void testFlow() {
        LeadResponse document-services-DserviceIdUpper=Document-servicesDetail = testLeadCreate();

        Assert.assertNotNull(document-services-DserviceIdUpper=Document-servicesDetail);
        // server is down and hence we received fallback/default values.
        Assert.assertEquals(-1L, document-services-DserviceIdUpper=Document-servicesDetail.getLeadId().longValue());

        LeadResponse document-services-DserviceIdUpper=Document-servicesDetail2 = testLeadGet(document-services-DserviceIdUpper=Document-servicesDetail.getLeadId());

        Assert.assertEquals(document-services-DserviceIdUpper=Document-servicesDetail.getLeadId(), document-services-DserviceIdUpper=Document-servicesDetail2.getLeadId());
        Assert.assertEquals(document-services-DserviceIdUpper=Document-servicesDetail.getLeadStatus(), document-services-DserviceIdUpper=Document-servicesDetail2.getLeadStatus());
    }

    /**
     * create document-services-DserviceIdUpper=Document-services.
     * 
     */
    private LeadResponse testLeadCreate() {

        LeadRequest document-services-DserviceIdUpper=Document-services = LeadRequest.builder().document-services-DserviceIdUpper=Document-servicesName("myTestLead").build();

        LeadResponse document-services-DserviceIdUpper=Document-servicesDetail = document-services-DserviceIdUpper=Document-servicesClient.createLead(document-services-DserviceIdUpper=Document-services);

        LOGGER.info("Lead:{}", document-services-DserviceIdUpper=Document-servicesDetail.toString());

        return document-services-DserviceIdUpper=Document-servicesDetail;

    }

    /**
     * fetch Lead details.
     * 
     */
    public LeadResponse testLeadGet(Long document-services-DserviceIdUpper=Document-servicesId) {

        LeadResponse document-services-DserviceIdUpper=Document-servicesDetail = document-services-DserviceIdUpper=Document-servicesClient.getLead(document-services-DserviceIdUpper=Document-servicesId);

        LOGGER.info("Lead:{}", document-services-DserviceIdUpper=Document-servicesDetail.toString());

        return document-services-DserviceIdUpper=Document-servicesDetail;
    }

}
