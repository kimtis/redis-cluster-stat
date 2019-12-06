package com.kimtis.rcs.app.api;

import java.util.List;
import java.util.Optional;

public interface RedisClusterRepository {

    List<RedisCluster> getRedisClusters(int from, int size);

    Optional<RedisCluster> getRedisCluster(String name);

    void createRedisCluster(String name, List<RedisHost> initialHosts);
}
