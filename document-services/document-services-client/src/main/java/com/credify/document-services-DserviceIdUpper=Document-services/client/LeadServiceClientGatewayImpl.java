package com.credify.document-services-DserviceIdUpper=Document-services.client;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.credify.core.client.CredifyBaseUrlBuilder;
import com.credify.core.client.CredifyClient;
import com.credify.document-services-DserviceIdUpper=Document-services.model.LeadRequest;
import com.credify.document-services-DserviceIdUpper=Document-services.model.LeadResponse;
import com.credify.document-services-DserviceIdUpper=Document-services.model.LeadStatus;

/**
 * Sample client using FailSafe backed up by Feign.
 * 
 * @author psingh
 *
 */
@Component(LeadServiceProxy.DOCUMENT-SERVICES-DSERVICEIDUPPER=DOCUMENT-SERVICES_CLIENT_NAME)
public class LeadServiceClientGatewayImpl implements LeadServiceClientGateway {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private String baseUrl;

    @Value("${document-services-DserviceIdUpper=Document-services.server.host:localhost}")
    private String document-services-DserviceIdUpper=Document-servicesServerHostName;

    @Value("${document-services-DserviceIdUpper=Document-services.server.port:8080}")
    private Long document-services-DserviceIdUpper=Document-servicesServerPort;

    @Autowired
    private CredifyClient client;

    private LeadServiceProxy document-services-DserviceIdUpper=Document-servicesServiceProxy;

    public LeadServiceClientGatewayImpl() {

    }

    @PostConstruct
    public void initialize() {

        this.baseUrl = CredifyBaseUrlBuilder.instance().setHostName(this.document-services-DserviceIdUpper=Document-servicesServerHostName).setPort(document-services-DserviceIdUpper=Document-servicesServerPort)
                .setContextPath("/api/document-services").getBaseUrl();

        document-services-DserviceIdUpper=Document-servicesServiceProxy = client.proxy(LeadServiceProxy.class, this.baseUrl);
    }

    @Override
    public LeadResponse getLead(Long document-services-DserviceIdUpper=Document-servicesId) {

        LeadResponse document-services-DserviceIdUpper=Document-servicesDetail = client.resilientInvoker(() -> {
            return LeadResponse.builder().document-services-DserviceIdUpper=Document-servicesStatus(LeadStatus.NEW).document-services-DserviceIdUpper=Document-servicesId(-1L).build();
        }).get(() -> {
            return document-services-DserviceIdUpper=Document-servicesServiceProxy.getLead(document-services-DserviceIdUpper=Document-servicesId);
        });

        logger.info("Returning document-services-DserviceIdUpper=Document-services:{}", document-services-DserviceIdUpper=Document-servicesDetail.toString());

        return document-services-DserviceIdUpper=Document-servicesDetail;
    }

    @Override
    public LeadResponse createLead(LeadRequest document-services-DserviceIdUpper=Document-servicesRequest) {

        LeadResponse document-services-DserviceIdUpper=Document-servicesDetail = client.resilientInvoker(() -> {
            return LeadResponse.builder().document-services-DserviceIdUpper=Document-servicesStatus(LeadStatus.NEW).document-services-DserviceIdUpper=Document-servicesId(-1L).build();
        }).get(() -> {
            return document-services-DserviceIdUpper=Document-servicesServiceProxy.createLead(document-services-DserviceIdUpper=Document-servicesRequest);
        });

        logger.info("Returning document-services-DserviceIdUpper=Document-services:{}", document-services-DserviceIdUpper=Document-servicesDetail.toString());

        return document-services-DserviceIdUpper=Document-servicesDetail;
    }

}
