package com.kimtis.rcs.app.api;

import java.util.List;

public class StatefulRedisCluster extends RedisCluster {

    private List<RedisClusterNode> nodes;

    public StatefulRedisCluster(RedisCluster redisCluster, List<RedisClusterNode> nodes) {
        super(redisCluster);
        this.nodes = nodes;
    }

    public List<RedisClusterNode> getNodes() {
        return nodes;
    }

    public void setNodes(List<RedisClusterNode> nodes) {
        this.nodes = nodes;
    }
}
