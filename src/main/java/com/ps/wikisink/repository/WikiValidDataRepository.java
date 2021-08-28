package com.ps.wikisink.repository;


import com.ps.wikisink.entity.WikiValidDataEntity;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WikiValidDataRepository extends ReactiveCassandraRepository<WikiValidDataEntity,String> {
}

