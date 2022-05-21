package com.atguigu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Lenovo
 */

@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator customerRoueRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route",r -> r.path("/guonei").uri("https://news.baidu.com/guonei")).build();
        return routes.build();
    }
}
