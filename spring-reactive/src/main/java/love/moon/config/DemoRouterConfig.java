package love.moon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.ResponseEntity.ok;

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

