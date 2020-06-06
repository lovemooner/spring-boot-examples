package love.moon.controller;

import love.moon.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private ExampleService exampleService;

    @RequestMapping("/myStarter")
    public String myStarter() {
        return exampleService.wrap("test");
    }

    @RequestMapping("/hello1")
    public String hello() {
        return "hello";
    }

}
