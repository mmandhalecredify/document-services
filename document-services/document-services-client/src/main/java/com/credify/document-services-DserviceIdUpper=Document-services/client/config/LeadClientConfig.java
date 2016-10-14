package com.credify.document-services-DserviceIdUpper=Document-services.client.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.credify.core.client.annotation.CredifyClient;

/**
 * Lead client config.
 * 
 * @author psingh
 *
 */
@Configuration
@CredifyClient
@PropertySource("classpath:/document-services-DserviceIdUpper=Document-services.properties")
public class LeadClientConfig {

}
