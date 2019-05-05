package test;

import love.moon.controller.MessageController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootConfiguration
@RunWith(SpringRunner.class)
@WebFluxTest(controllers = MessageController.class)
public class DemoApplicationTests {
    @Autowired
    WebTestClient client;

    @Test
    public void getAllMessagesShouldBeOk() {
        client.get().uri("/flux").exchange().expectStatus().isOk();
    }
}
