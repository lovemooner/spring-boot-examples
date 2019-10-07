//package boot;
//
//import love.moon.MyApplication;
//import love.moon.dao.UserRepository;
//import love.moon.domain.User;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.text.DateFormat;
//import java.util.Date;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes= MyApplication.class)
//public class UserRepositoryTests {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Test
//    public void test() {
//        Date date = new Date();
//        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
//        String formattedDate = dateFormat.format(date);
//
//        userRepository.save(new User("aa1", "aa@126.com", "aa", "aa123456",formattedDate));
////        userRepository.save(new User("bb2", "bb@126.com", "bb", "bb123456",formattedDate));
////        userRepository.save(new User("cc3", "cc@126.com", "cc", "cc123456",formattedDate));
//
////        Assert.assertEquals(1, userRepository.findAll().size());
////        Assert.assertEquals("bb", userRepository.findByUserNameOrEmail("bb", "cc@126.com").getNickName());
////        userRepository.delete(userRepository.findByUserName("aa1"));
//        User user= userRepository.findByUserName("nan2");
////        User user2= userRepository.findOne(1000l);
//        if(user!=null)
//        System.out.println(user.getUserName());
//    }
//
//}