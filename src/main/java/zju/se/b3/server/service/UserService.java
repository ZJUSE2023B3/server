package zju.se.b3.server.service;

import zju.se.b3.server.entity.Friend;
import zju.se.b3.server.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<Friend> findall()
    {
        return userMapper.findall();
    }
    public List<Friend> Select(Integer user_id)
    {
        return userMapper.Select(user_id);
    }
    public Integer Add(Friend user)
    {
        return userMapper.Add(user);
    }
    public Integer Delete(Friend user)
    {
        return userMapper.Delete(user);
    }
}
