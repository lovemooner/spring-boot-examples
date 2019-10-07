package love.moon.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @auther dongnan
 * @date 2019/6/18 13:56
 * @describe
 */
@Component
@Data
@ConfigurationProperties(prefix="ups.server")
public class UpsProps {
    private String url;
}
