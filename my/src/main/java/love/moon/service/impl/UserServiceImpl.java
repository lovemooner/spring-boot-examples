package love.moon.service.impl;

import love.moon.dao.UserRepository;
import love.moon.domain.User;
import love.moon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author dongnan
 * @date 2020/5/21 19:10
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUser() {
        User user = userRepository.findByUserName("1");
        return user;
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }
}
