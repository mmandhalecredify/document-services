package com.credify.document-services-DserviceIdUpper=Document-services.data.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.credify.document-services-DserviceIdUpper=Document-services.model.LeadStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Lead Entity.
 * 
 * @author psingh
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Lead implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String document-services-DserviceIdUpper=Document-servicesName;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private LeadStatus status;

    @Column(nullable = false)
    private Date createDate;

    @Column
    private Date updateDate;
}