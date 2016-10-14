package com.credify.document-services-DserviceIdUpper=Document-services.service;


import com.credify.document-services-DserviceIdUpper=Document-services.model.LeadRequest;
import com.credify.document-services-DserviceIdUpper=Document-services.model.LeadResponse;

/**
 * Lead service interface.
 * 
 * @author psingh
 * 
 */

public interface LeadService {

    LeadResponse getLeadId(Long document-services-DserviceIdUpper=Document-servicesId);

    LeadResponse createLeadId(LeadRequest document-services-DserviceIdUpper=Document-servicesDto);
}