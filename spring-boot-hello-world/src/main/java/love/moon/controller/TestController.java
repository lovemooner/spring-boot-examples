package love.moon.controller;

import love.moon.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther lovemooner
 * @date 2019/10/31 14:56
 * @describe
 */
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("/")
    public String hello() {
        return testService.hello();
    }

}
