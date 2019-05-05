//package love.moon;
//
//import org.springframework.web.bind.annotation.*;
//import reactor.core.publisher.Mono;
//
//@RestController
//public class PersonController {
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
//}