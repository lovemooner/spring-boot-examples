package love.moon.dto;

import lombok.Data;

/**
 * @auther dongnan
 * @date 2019/6/17 20:00
 * @describe
 */
@Data
public class PushMessageDataEntry {
    private String type;
    private Object entry;
}
