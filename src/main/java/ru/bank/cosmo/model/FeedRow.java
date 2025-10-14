package ru.bank.cosmo.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Getter
@Setter
@Table("feed_by_user")
public class FeedRow {

    @PrimaryKeyColumn(name = "user_id", type = PrimaryKeyType.PARTITIONED)
    private String userId;

    @PrimaryKeyColumn(name = "created_at", type = PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING)
    private UUID createdAt; // timeuuid — можно генерировать через Uuids.timeBased()

    @PrimaryKeyColumn(name = "post_id", type = PrimaryKeyType.CLUSTERED, ordering = Ordering.ASCENDING)
    private UUID postId;
}