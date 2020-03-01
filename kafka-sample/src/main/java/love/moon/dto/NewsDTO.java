package love.moon.dto;

import com.sun.istack.internal.NotNull;
import lombok.Data;

/**
 * @auther lovemooner
 * @date 2020/2/29 23:42
 * @describe
 */
@Data
public class NewsDTO {

    private String name;
    private String title;
    private String content;
    private String type;
}
