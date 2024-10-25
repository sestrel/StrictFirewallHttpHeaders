package app;


import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;

import reactor.core.publisher.Mono;

@Component
public class SetHttpHeaderWebFilter implements WebFilter
{

	@Override
	public Mono<Void> filter(final ServerWebExchange exchange, final WebFilterChain chain)
	{
		ServerHttpRequest request = exchange.getRequest()
			.mutate()
			.header("mycustomhttpheader", "somevalue")
			.build();
			
		return chain.filter(exchange.mutate().request(request).build());
	}
	
}