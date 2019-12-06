package com.kimtis.rcs.app.controller;

import com.kimtis.rcs.app.api.RedisHost;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class CreateRedisClusterRequest {

    @NotNull
    @Size(min = 4)
    private String name;

    @NotNull
    @Size(min = 1)
    private List<RedisHost> redisHosts;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RedisHost> getRedisHosts() {
        return redisHosts;
    }

    public void setRedisHosts(List<RedisHost> redisHosts) {
        this.redisHosts = redisHosts;
    }
}
