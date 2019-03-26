package love.moon.mapper;

import love.moon.entity.User;
import love.moon.pojo.QueryParam;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserXmlMapper {

    User findUserByName(String userName);

    User findUser(QueryParam param);
}
