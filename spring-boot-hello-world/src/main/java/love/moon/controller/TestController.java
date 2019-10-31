package love.moon.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther dongnan
 * @date 2019/10/31 14:56
 * @describe
 */
@RestController
public class TestController {

    @RequestMapping("/hello")
    public String hello() {
        return "hi";
    }

}
