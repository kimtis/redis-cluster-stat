package com.kimtis.rcs.app.api;

public class RedisHost {

    private static final int REDIS_DEFAULT_PORT = 6379;

    private String host;

    private Integer port;

    public RedisHost(String host) {
        this(host, REDIS_DEFAULT_PORT);
    }

    public RedisHost(String host, Integer port) {
        this.host = host;
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}
