package com.stpl.javar.repository;

import com.stpl.javar.domain.CompanyMaster;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data MongoDB repository for the CompanyMaster entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CompanyMasterRepository extends MongoRepository<CompanyMaster, String> {

}
