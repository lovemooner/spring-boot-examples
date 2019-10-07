package love.moon.config;

import love.moon.pojo.Message;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.util.Arrays;

import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class DemoRouterConfig {

    @Bean
    public RouterFunction<ServerResponse> routes() {
//        return route(GET("/"), (ServerRequest req)-> ok().body(
//                        BodyInserters.fromObject(
//                                Arrays.asList(
//                                        Message.builder().body("hello Spring 5").build(),
//                                        Message.builder().body("hello Spring Boot 2").build()
//                                )
//                        )
//                )
//        );
        return null;
    }
}

