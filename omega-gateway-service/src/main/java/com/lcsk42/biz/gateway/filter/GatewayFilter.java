package com.lcsk42.biz.gateway.filter;

import com.lcsk42.frameworks.starter.core.constant.HttpHeaderConstant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


@Order
@Component
public class GatewayFilter implements GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String requestId = request.getHeaders()
                .getFirst(HttpHeaderConstant.REQUEST_ID);

        if (StringUtils.isBlank(requestId)) {
            requestId = HttpHeaderConstant.getGatewayRequestId();
            request = request.mutate()
                    .header(HttpHeaderConstant.REQUEST_ID, requestId)
                    .build();
            exchange = exchange.mutate().request(request).build();
        }

        return chain.filter(exchange);
    }
}
