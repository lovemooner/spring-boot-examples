package love.moon.dto;

import lombok.Data;

/**
 * @auther dongnan
 * @date 2019/6/17 9:31
 * @describe
 */
@Data
public class PushMessageDTO {

    private String registration_tokens;
    private String dimension; //1 用户 2.设备
    private String title; //通知标题
    private String content; //简介
    private String originalSourceIP;
    private String originalSourceName;
    private String type; //1 异步消息
    private PushMessageDataEntry data;
}
