package ru.bank.cosmo.repository;

import org.springframework.data.cassandra.core.mapping.MapId;
import org.springframework.data.cassandra.repository.CassandraRepository;
import ru.bank.cosmo.model.FeedRow;

import java.util.List;

public interface FeedRepository extends CassandraRepository<FeedRow, MapId> {

    // Последние N постов конкретного пользователя
    List<FeedRow> findTopTenByUserIdOrderByCreatedAtDesc(String userId);
}