package com.stpl.javar.repository;

import com.stpl.javar.domain.HelperTable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data MongoDB repository for the HelperTable entity.
 */
@SuppressWarnings("unused")
@Repository
public interface HelperTableRepository extends MongoRepository<HelperTable, String> {

}
