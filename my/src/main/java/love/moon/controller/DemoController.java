package love.moon.controller;

import love.moon.ExampleService;
import love.moon.domain.User;
import love.moon.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private ExampleService exampleService;

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/getUser")
    public User getUser() {
        User user= userService.getUser();
        return user;
    }

    @RequestMapping("/myStarter")
    public String myStarter() {
        return exampleService.wrap("test");
    }

    @RequestMapping("/hello1")
    public String hello() {
        return "hello";
    }

}
