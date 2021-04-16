package love.moon;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @auther dongnan
 * @date 2019/10/31 14:31
 * @describe
 */
@SpringBootApplication
@NacosPropertySource(dataId = "example", autoRefreshed = true)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
