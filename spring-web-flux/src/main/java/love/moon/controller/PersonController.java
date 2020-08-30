package love.moon.controller;
//

import love.moon.pojo.DemoObj;
import love.moon.pojo.Message;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/person")
public class PersonController {


    @GetMapping("/flux")
    public Flux<Message> allMessages(){
        return Flux.just(
                Message.builder().body("hello Spring 5").build(),
                new Message("test")
        );
    }

    /**
     * GET请求
     */
    @GetMapping(value = "/getById", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Mono<DemoObj> getById() {
        //测试处理header
        return  Mono.just(new DemoObj(1, " Ret"));
    }

//
//    private final PersonRepository repository;
//
//    public PersonController(PersonRepository repository) {
//        this.repository = repository;
//    }
//
//    @PostMapping("/person")
//    Mono<Void> create(@RequestBody Publisher<Person> personStream) {
//        return this.repository.save(personStream).then();
//    }
//
//    @GetMapping("/person")
//    Flux<Person> list() {
//        return this.repository.findAll();
//    }
//
//    @GetMapping("/person/{id}")
//    Mono<Person> findById(@PathVariable String id) {
//        return this.repository.findOne(id);
//    }
}