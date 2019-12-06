package com.kimtis.rcs.app.service.cluster;

import com.kimtis.rcs.app.api.RedisCluster;
import com.kimtis.rcs.app.api.RedisClusterRepository;
import com.kimtis.rcs.app.api.RedisHost;
import com.kimtis.rcs.app.exception.ResourceAlreadyExistException;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class InMemoryRedisClusterRepository implements RedisClusterRepository {
    private final List<RedisCluster> redisClusters;

    public InMemoryRedisClusterRepository() {
        this.redisClusters = new ArrayList<>();
        initializeForTesting();
    }

    private void initializeForTesting() {
        redisClusters.add(
            new RedisCluster("test", Collections.singletonList(new RedisHost("localhost")), new Date()));
    }

    @Override
    public List<RedisCluster> getRedisClusters(int from, int size) {
        List<RedisCluster> subRedisClusters = new ArrayList<>(size);
        for (int i = from; i < from + size && i < redisClusters.size(); i++) {
            subRedisClusters.add(redisClusters.get(i));
        }
        return subRedisClusters;
    }

    @Override
    public Optional<RedisCluster> getRedisCluster(String name) {
        for (RedisCluster redisCluster : redisClusters) {
            if (name != null && name.equals(redisCluster.getName())) {
                return Optional.of(redisCluster);
            }
        }
        return Optional.empty();
    }

    @Override
    public void createRedisCluster(String name, List<RedisHost> initialHosts) {
        Optional<RedisCluster> oldRedisCluster = getRedisCluster(name);
        if (oldRedisCluster.isPresent()) {
            throw new ResourceAlreadyExistException("The cluster name of '" + name + "' is already exist.");
        }
        RedisCluster redisCluster = new RedisCluster(name, initialHosts, new Date(System.currentTimeMillis()));
        redisClusters.add(redisCluster);
    }
}
