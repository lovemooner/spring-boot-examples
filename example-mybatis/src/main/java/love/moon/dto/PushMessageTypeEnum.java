package love.moon.dto;

/**
 * @auther dongnan
 * @date 2019/6/14 15:06
 * @describe
 */
public enum PushMessageTypeEnum {

    CONTROL("管控"),
    APP_MESSAGE("APP消息"),
    DEVICE_MESSAGE("警务通消息"),
    ;


    private String desc;

    PushMessageTypeEnum(String desc){
        this.desc = desc;
    }

}
