package love.moon.service;

import love.moon.dao.UserRepository;
import love.moon.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUser() {
        User user= userRepository.findByUserName("nan2");
        return user;
    }
}
