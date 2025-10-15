package ru.bank.cosmo.repository;

import org.springframework.data.cassandra.core.mapping.MapId;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import ru.bank.cosmo.model.FeedRow;

@Repository
public interface FeedRepository extends CassandraRepository<FeedRow, MapId> {

}