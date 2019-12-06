package com.kimtis.rcs.app.controller;

import com.kimtis.rcs.app.api.StatefulRedisCluster;
import com.kimtis.rcs.app.service.cluster.RedisClusterService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/redis-clusters")
public class RedisClusterController {
    private final RedisClusterService service;

    public RedisClusterController(RedisClusterService service) {
        this.service = service;
    }

    @GetMapping
    public GenericResponse<List<StatefulRedisCluster>> getRedisClusters(@RequestParam @Min(0) Integer page,
                                                                        @RequestParam @Min(1) Integer size) {
        return GenericResponse.ok(service.statefulRedisClusters(page, size));
    }

    @PostMapping
    public GenericResponse<Void> postRedisCluster(@RequestBody @Valid CreateRedisClusterRequest request) {
        service.createRedisCluster(request.getName(), request.getRedisHosts());
        return GenericResponse.ok(null);
    }

    @GetMapping("/{name}")
    public GenericResponse<StatefulRedisCluster> getRedisCluster(@PathVariable String name) {
        return GenericResponse.ok(service.statefulRedisCluster(name));
    }
}
