package com.credify.document-services-DserviceIdUpper=Document-services;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Import;

import com.credify.core.server.annotation.CredifyServer;
import com.credify.document-services-DserviceIdUpper=Document-services.config.LeadServiceConfig;

/**
 * @author psingh
 * @since 28/09/16.
 */
@CredifyServer
@Import({LeadServiceConfig.class})
public class CfApplication {

    public void addedToFixCheckStyle() {

    }

    public static void main(String[] args) {
        SpringApplication.run(CfApplication.class, args);
    }

}
