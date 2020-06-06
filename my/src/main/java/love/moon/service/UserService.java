package love.moon.service;

import love.moon.domain.User;

/**
 * @author dongnan
 * @date 2020/5/21 19:11
 */
public interface UserService {

    User getUser();

    void saveUser(User user);

}
