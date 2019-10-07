package love.moon.mapper;

import love.moon.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author : dongnan
 * date: 2019/4/21 13:48
 * description: annotation mapper
 */

@Mapper
public interface UserAnnotationMapper {

    @Select("select * from t_user")
    List<User> list();


    @SelectProvider(type = UserSqlProvider.class, method = "listByUsername")
    List<User> listByUsername(String username);


    //Results 相当于xml中的resultMap
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "userName", column = "user_name"),
    })
    @Select("select * from t_user")
    List<User> listSample();

    /**
     * 延伸：无论什么方式,如果涉及多个参数,则必须加上@Param注解。
     */
    @Select("select * from t_user where username like #{username} and password like #{password}")
    User getByMutiParams(@Param("username") String username, @Param("password") String password);

    @SelectProvider(type = UserSqlProvider.class, method = "getBadUser")
    User getBySelectProvider(@Param("username") String username, @Param("password") String password);


    @Insert(" insert into `user` (create_time,status,product_id) "
            	           + " values ( #{createTime},#{status},#{productId})")
   int save(User user);


}