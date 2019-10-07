package love.moon.entity;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String userName;
    private String password;
    private String email;
    private String nickName;
    private String regTime;
}
