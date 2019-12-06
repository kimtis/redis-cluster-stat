package com.kimtis.rcs.app.api;

import java.util.Date;
import java.util.List;

public class RedisCluster {

    private String name;

    private List<RedisHost> initialHosts;

    private Date createdAt;

    public RedisCluster() {
    }

    public RedisCluster(RedisCluster redisCluster) {
        this(redisCluster.name, redisCluster.initialHosts, redisCluster.createdAt);
    }

    public RedisCluster(String name, List<RedisHost> initialHosts, Date createdAt) {
        this.name = name;
        this.initialHosts = initialHosts;
        this.createdAt = createdAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RedisHost> getInitialHosts() {
        return initialHosts;
    }

    public void setInitialHosts(List<RedisHost> initialHosts) {
        this.initialHosts = initialHosts;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
