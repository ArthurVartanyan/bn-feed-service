CREATE KEYSPACE IF NOT EXISTS feed_app
            WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1};

CREATE TABLE IF NOT EXISTS feed_app.feed_by_user
(
    user_id    bigint,
    created_at timeuuid,
    post_id    bigint,
    PRIMARY KEY ((user_id), created_at, post_id)
) WITH CLUSTERING ORDER BY (created_at DESC, post_id ASC);
