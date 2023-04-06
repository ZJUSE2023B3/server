package zju.se.b3.server.mapper;
import zju.se.b3.server.entity.Friend;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface UserMapper {
    public List<Friend> findall();

    public List<Friend> Select(Integer user_id);

    public Integer Add(Friend user);
    public Integer Delete(Friend user);

}
