package love.moon.web.reactive.samples;

import org.springframework.http.HttpMethod;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.ipc.netty.http.server.HttpServer;

import static org.springframework.http.MediaType.APPLICATION_JSON;

/**
 * @author
 */
public class ReactorServer {

    public static final String HOST = "localhost";

    public static final int PORT = 8080;

    public static void main(String[] args) throws Exception {
        ReactorServer server = new ReactorServer();
        server.startReactorServer();

        System.out.println("Press ENTER to exit.");
        System.in.read();
    }

    public void startReactorServer()  {
        RouterFunction<ServerResponse> route = routingFunction();
        HttpHandler httpHandler = RouterFunctions.toHttpHandler(route);

        ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(httpHandler);
        HttpServer server = HttpServer.create(HOST, PORT);
        server.newHandler(adapter).block();
    }

    public RouterFunction<ServerResponse> routingFunction() {
        PersonRepository repository = new PersonRepository();
        PersonHandler handler = new PersonHandler(repository);

        return RouterFunctions.nest(RequestPredicates.path("/person"),
                RouterFunctions.nest(RequestPredicates.accept(APPLICATION_JSON),
                        RouterFunctions.route(RequestPredicates.GET("/{id}"), handler::getPerson)
                                .andRoute(RequestPredicates.method(HttpMethod.GET), handler::listPeople)
                ).andRoute(RequestPredicates.POST("/").and(RequestPredicates.contentType(APPLICATION_JSON)), handler::createPerson));
    }
}
