package com.credify.document-services-DserviceIdUpper=Document-services.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Lead Service Request Payload.
 * 
 * @author psingh
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class LeadRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private String document-services-DserviceIdUpper=Document-servicesName;

}