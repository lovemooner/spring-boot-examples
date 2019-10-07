import love.moon.MybatisApplication;
import love.moon.entity.User;
import love.moon.mapper.UserAnnotationMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MybatisApplication.class)
public class UserMapperTests {


    @Autowired
    private UserAnnotationMapper userMapper;

    @Test
    public void test1() {
        List<User> userList = userMapper.list();
        System.out.println(userList.size());
    }


}