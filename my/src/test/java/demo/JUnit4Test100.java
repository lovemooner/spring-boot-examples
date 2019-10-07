package demo;

import love.moon.dao.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @auther dongnan
 * @date 2019/6/19 14:32
 * @describe
 */
@RunWith(JUnit4.class)
public class JUnit4Test100 {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test(){
        System.out.println("test");
    }
}
