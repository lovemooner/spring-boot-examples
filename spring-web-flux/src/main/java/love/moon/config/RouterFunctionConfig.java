package love.moon.config;

import love.moon.pojo.Message;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;

import java.util.Arrays;

import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

@Configuration
public class RouterFunctionConfig {

    @Bean
    public RouterFunction<?> helloRouterFunction() {
        return RouterFunctions.route(RequestPredicates.GET("/rf1"), request -> ServerResponse.ok().body(Mono.just("Hello rf1!"), String.class))
                .andRoute(RequestPredicates.GET("/rf2"), request -> ServerResponse.ok().body(Mono.just("See rf2!"), String.class));
    }

}

