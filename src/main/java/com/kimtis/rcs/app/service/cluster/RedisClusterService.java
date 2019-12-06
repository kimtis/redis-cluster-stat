package com.kimtis.rcs.app.service.cluster;

import com.kimtis.rcs.app.api.*;
import com.kimtis.rcs.app.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RedisClusterService {
    private final RedisClusterRepository repository;
    private final RedisClusterStateResolver stateResolver;

    public RedisClusterService(RedisClusterRepository repository,
                               RedisClusterStateResolver stateResolver) {
        this.repository = repository;
        this.stateResolver = stateResolver;
    }

    public List<StatefulRedisCluster> statefulRedisClusters(int page, int size) {
        final int from = page * size;
        return repository.getRedisClusters(from, size)//
            .stream()//
            .map(this::lookupRedisClusterState)//
            .collect(Collectors.toList());
    }

    public StatefulRedisCluster statefulRedisCluster(String clusterName) {
        Optional<RedisCluster> optionalRedisCluster = repository.getRedisCluster(clusterName);
        if (!optionalRedisCluster.isPresent()) {
            throw new ResourceNotFoundException("The cluster of name '" + clusterName + "' is not found");
        }
        return lookupRedisClusterState(optionalRedisCluster.get());
    }

    public void createRedisCluster(String clusterName, List<RedisHost> redisHosts) {
        repository.createRedisCluster(clusterName, redisHosts);
    }

    private StatefulRedisCluster lookupRedisClusterState(RedisCluster redisCluster) {
        List<RedisClusterNode> redisClusterNodes = stateResolver.lookupClusterNodes(redisCluster);
        return new StatefulRedisCluster(redisCluster, redisClusterNodes);
    }
}
