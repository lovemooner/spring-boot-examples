package love.moon.controller;

import love.moon.entity.User;
import love.moon.mapper.UserAnnotationMapper;
import love.moon.mapper.UserMapper;
import love.moon.pojo.QueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;
    @SuppressWarnings("all")
    @Autowired
   private UserAnnotationMapper annotationMapper;


    /**    下面是Annotation的映射形式 */

    @GetMapping("/list")
    public List<User> list() {
        return annotationMapper.listSample();
    }



    @GetMapping("get/{username}/{password}")
    public User getByMutiParams(@PathVariable("username") String username, @PathVariable("password") String password) {
        return annotationMapper.getByMutiParams(username, password);
    }

    @GetMapping("get/bad/{username}/{password}")
    public User getBySelectProvider(@PathVariable("username") String username, @PathVariable("password") String password) {
        return annotationMapper.getBySelectProvider(username, password);
    }


    /**    下面是XML的映射形式 */

    @GetMapping("/user/{userName}")
    public User findUserByName(@PathVariable("userName") String userName) {
        return userMapper.findUserByName(userName);
    }


    @GetMapping("/user")
    public User findUser(QueryParam param) {
        return userMapper.findUser(param);
    }



}