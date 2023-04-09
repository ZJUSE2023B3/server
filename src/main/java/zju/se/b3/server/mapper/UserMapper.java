package zju.se.b3.server.mapper;
import zju.se.b3.server.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface UserMapper {
    public List<User> FindbyId(Integer user_id);
    public Integer ChangePassword(User user);
    public Integer Update(User user);
}