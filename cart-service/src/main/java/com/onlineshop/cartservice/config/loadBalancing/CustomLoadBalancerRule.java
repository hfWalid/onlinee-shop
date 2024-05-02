package com.onlineshop.cartservice.config.loadBalancing;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;

public class CustomLoadBalancerRule implements IRule {

    private ILoadBalancer loadBalancer;

    @Override
    public Server choose(Object key) {
        //TODO:  should implement custom load balancing logic
        return null;
    }

    @Override
    public void setLoadBalancer(ILoadBalancer loadBalancer) {
        this.loadBalancer = loadBalancer;
    }

    @Override
    public ILoadBalancer getLoadBalancer() {
        return this.loadBalancer;
    }
}

