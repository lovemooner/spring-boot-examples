package love.moon.controller;

import love.moon.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dongnan
 * @date 2020/5/20 15:04
 */
@RestController
public class TestController {

    @Autowired
    @Qualifier("testServiceImpl1")
    private TestService testService;

    @RequestMapping("/testAutowide")
    public void testAutowide(){
        testService.testAutowide();
    }

}
