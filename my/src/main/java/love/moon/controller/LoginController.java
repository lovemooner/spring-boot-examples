package love.moon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/login")
    public String login() {
        return "login"; //跳转到页面login
    }

    @PostMapping("/login")
    public Object login(@RequestParam String username) {
        return "ok";
    }


}
