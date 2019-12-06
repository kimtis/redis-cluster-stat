package com.kimtis.rcs.app.service.cluster;

import com.kimtis.rcs.app.api.RedisCluster;
import com.kimtis.rcs.app.api.RedisClusterNode;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class RedisClusterStateResolver {

    public List<RedisClusterNode> lookupClusterNodes(RedisCluster redisCluster) {
        return Collections.emptyList(); // TODO
    }
}
