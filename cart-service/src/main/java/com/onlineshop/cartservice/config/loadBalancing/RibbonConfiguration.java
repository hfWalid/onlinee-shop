package com.onlineshop.cartservice.config.loadBalancing;

import com.netflix.loadbalancer.BestAvailableRule;
import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RibbonConfiguration {

    @Bean
    public IRule customRule() {
        //TODO: should Define a custom load balancing strategy: eg randomRule, bestAvailableRule..
        // return new CustomLoadBalancingRule();
        return new BestAvailableRule();
    }
}
