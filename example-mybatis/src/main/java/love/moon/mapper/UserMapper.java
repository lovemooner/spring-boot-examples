package love.moon.mapper;

import love.moon.entity.User;
import love.moon.pojo.QueryParam;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author : dongnan
 * date: 2019/4/21 13:48
 * description: xml mapper
 */

@Mapper
public interface UserMapper {

    User findUserByName(String userName);

    User findUser(QueryParam param);
}
