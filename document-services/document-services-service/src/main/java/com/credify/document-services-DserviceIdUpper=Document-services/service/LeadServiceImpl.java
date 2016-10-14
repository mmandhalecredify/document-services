package com.credify.document-services-DserviceIdUpper=Document-services.service;

import java.sql.Date;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credify.document-services-DserviceIdUpper=Document-services.data.domain.Lead;
import com.credify.document-services-DserviceIdUpper=Document-services.data.repository.LeadRepository;
import com.credify.document-services-DserviceIdUpper=Document-services.model.LeadRequest;
import com.credify.document-services-DserviceIdUpper=Document-services.model.LeadResponse;
import com.credify.document-services-DserviceIdUpper=Document-services.model.LeadStatus;

/**
 * 
 * 
 * @author psingh
 */

@Service
public class LeadServiceImpl implements LeadService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private LeadRepository repo;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * find Lead entry.
     */
    @Override
    public LeadResponse getLeadId(Long document-services-DserviceIdUpper=Document-servicesId) {

        logger.info("Finding document-services-DserviceIdUpper=Document-services id {}", document-services-DserviceIdUpper=Document-servicesId);

        Lead document-services-DserviceIdUpper=Document-servicesEntity = repo.findOne(document-services-DserviceIdUpper=Document-servicesId);

        if (document-services-DserviceIdUpper=Document-servicesEntity != null) {

            logger.info("Found document-services-DserviceIdUpper=Document-services [{}] = {}", document-services-DserviceIdUpper=Document-servicesEntity.getId(), document-services-DserviceIdUpper=Document-servicesEntity.toString());

            return LeadResponse.builder().document-services-DserviceIdUpper=Document-servicesId(document-services-DserviceIdUpper=Document-servicesEntity.getId()).document-services-DserviceIdUpper=Document-servicesStatus(document-services-DserviceIdUpper=Document-servicesEntity.getStatus()).build();

        } else {

            logger.info("Lead Not Found for id = {}", document-services-DserviceIdUpper=Document-servicesId);

            return LeadResponse.builder().build();
        }
    }

    /**
     * create Lead entry.
     *
     */
    @Override
    public LeadResponse createLeadId(LeadRequest document-services-DserviceIdUpper=Document-servicesRequest) {

        Lead document-services-DserviceIdUpper=Document-servicesEntity = Lead.builder().document-services-DserviceIdUpper=Document-servicesName(document-services-DserviceIdUpper=Document-servicesRequest.getLeadName()).build();

        document-services-DserviceIdUpper=Document-servicesEntity.setStatus(LeadStatus.NEW);
        /**
         * These must go in Lead.java and updated via @PrePersist/@PreUpdate
         * annotation.
         */
        document-services-DserviceIdUpper=Document-servicesEntity.setCreateDate(new Date(System.currentTimeMillis()));
        document-services-DserviceIdUpper=Document-servicesEntity.setUpdateDate(document-services-DserviceIdUpper=Document-servicesEntity.getCreateDate());

        document-services-DserviceIdUpper=Document-servicesEntity = repo.save(document-services-DserviceIdUpper=Document-servicesEntity);

        logger.info("Created document-services-DserviceIdUpper=Document-services [{}] = {}", document-services-DserviceIdUpper=Document-servicesEntity.getId(), document-services-DserviceIdUpper=Document-servicesEntity.toString());

        return LeadResponse.builder().document-services-DserviceIdUpper=Document-servicesId(document-services-DserviceIdUpper=Document-servicesEntity.getId()).document-services-DserviceIdUpper=Document-servicesStatus(document-services-DserviceIdUpper=Document-servicesEntity.getStatus()).build();

    }

}
