package love.moon.controller;

import love.moon.domain.User;
import love.moon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author dongnan
 * @date 2020/5/21 19:12
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user")
    public User getUser() {
        User user = userService.getUser();
        return user;
    }

    @PostMapping("/user")
    public User saveUser(@RequestBody User user) {
        userService.saveUser(user);
        return user;
    }

}
