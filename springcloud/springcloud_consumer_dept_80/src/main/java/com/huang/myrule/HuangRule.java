package com.huang.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HuangRule {

    @Bean
    public IRule myIRule(){
        return new RandomRule();
    }

}
