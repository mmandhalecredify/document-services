package com.credify.document-services-DserviceIdUpper=Document-services.client;

import com.credify.document-services-DserviceIdUpper=Document-services.model.LeadRequest;
import com.credify.document-services-DserviceIdUpper=Document-services.model.LeadResponse;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

/**
 * A proxy to represent the APIs defined in server's controller class.
 * 
 * @author psingh
 *
 */
public interface LeadServiceProxy {

    String DOCUMENT-SERVICES-DSERVICEIDUPPER=DOCUMENT-SERVICES_CLIENT_NAME = "LeadServiceClient";

    @RequestLine("POST /document-services-DserviceIdUpper=Document-servicess/")
    @Headers("Content-Type: application/json")
    LeadResponse createLead(LeadRequest document-services-DserviceIdUpper=Document-servicesRequest);

    @RequestLine("GET /document-services-DserviceIdUpper=Document-servicess/{document-services-DserviceIdUpper=Document-servicesId}")
    @Headers("Content-Type: application/json")
    LeadResponse getLead(@Param("document-services-DserviceIdUpper=Document-servicesId") Long document-services-DserviceIdUpper=Document-servicesId);

}