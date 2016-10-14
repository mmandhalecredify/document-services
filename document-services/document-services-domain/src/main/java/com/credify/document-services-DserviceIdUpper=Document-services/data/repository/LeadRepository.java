package com.credify.document-services-DserviceIdUpper=Document-services.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.credify.document-services-DserviceIdUpper=Document-services.data.domain.Lead;

/**
 * Lead Repository.
 * 
 * @author psingh
 */

@Repository
public interface LeadRepository extends JpaRepository<Lead, Long> {

}
