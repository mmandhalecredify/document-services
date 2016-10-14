package com.credify.document-services-DserviceIdUpper=Document-services.client;

import com.credify.document-services-DserviceIdUpper=Document-services.model.LeadRequest;
import com.credify.document-services-DserviceIdUpper=Document-services.model.LeadResponse;


/**
 * A proxy to represent the APIs defined in server's controller class.
 * 
 * @author psingh
 *
 */
public interface LeadServiceClientGateway extends LeadServiceProxy {

    LeadResponse createLead(LeadRequest document-services-DserviceIdUpper=Document-services);

    LeadResponse getLead(Long document-services-DserviceIdUpper=Document-servicesId);

}