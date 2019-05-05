package love.moon.controller;

import love.moon.pojo.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping
public class MessageController {

    @GetMapping("/flux")
    public Flux<Message> allMessages(){
        return Flux.just(
                Message.builder().body("hello Spring 5").build(),
                new Message("test")
        );
    }
}

