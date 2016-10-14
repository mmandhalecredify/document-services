package com.credify.document-services-DserviceIdUpper=Document-services.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.credify.document-services-DserviceIdUpper=Document-services.model.LeadRequest;
import com.credify.document-services-DserviceIdUpper=Document-services.model.LeadResponse;
import com.credify.document-services-DserviceIdUpper=Document-services.service.LeadService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;


/**
 * controller to expose APIs.
 * 
 * @author psingh
 * @since 28/09/16.
 */
@RestController
@ActiveProfiles({ "junit", "local", "dev", "stage", "demo" })
public class LeadController {

    @Autowired
    private LeadService document-services-DserviceIdUpper=Document-servicesService;

    /**
     * processes the request.
     * 
     * @param document-services-DserviceIdUpper=Document-servicesId
     *            document-services-DserviceIdUpper=Document-services id.
     * @return response.
     */
    @RequestMapping(value = "/document-services-DserviceIdUpper=Document-servicess/{document-services-DserviceIdUpper=Document-servicesId}", method = RequestMethod.GET)
    //@formatter:off
    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-CF-CORR-ID", value = "Correlation Id", 
                    dataType = "string", paramType = "header") })
    //@formatter:on
    public ResponseEntity<LeadResponse> getLeadId(@PathVariable("document-services-DserviceIdUpper=Document-servicesId") Long document-services-DserviceIdUpper=Document-servicesId) {

        return new ResponseEntity<LeadResponse>(document-services-DserviceIdUpper=Document-servicesService.getLeadId(document-services-DserviceIdUpper=Document-servicesId), HttpStatus.OK);
    }

    @RequestMapping(value = "/document-services-DserviceIdUpper=Document-servicess/", method = RequestMethod.POST)
    //@formatter:off
    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-CF-CORR-ID", value = "Correlation Id", 
                    dataType = "string", paramType = "header") })
    //@formatter:on
    public ResponseEntity<LeadResponse> createLeadId(@RequestBody LeadRequest document-services-DserviceIdUpper=Document-servicesRequest) {

        return new ResponseEntity<LeadResponse>(document-services-DserviceIdUpper=Document-servicesService.createLeadId(document-services-DserviceIdUpper=Document-servicesRequest), HttpStatus.OK);
    }
}
