package com.datacollector.demo.repository;

import com.google.cloud.spring.data.datastore.repository.DatastoreRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GCPStorageRepository extends DatastoreRepository {
}
