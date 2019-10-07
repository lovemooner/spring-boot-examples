package love.moon.dto;

import lombok.Data;

/**
 * @auther dongnan
 * @date 2019/6/17 9:45
 * @describe
 */
@Data
public class PushResultDTO {

    private Integer result;
    private String desc;
    private String messageId;
}
