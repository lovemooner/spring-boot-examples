import love.moon.Application;
import love.moon.pojo.Constants;
import love.moon.pojo.NeoProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=Application.class)
public class Test1 {

    @Autowired
    private NeoProperties properties;

    @Test
    public void test() throws Exception {
        System.out.println(properties.getDescription());
    }
}
