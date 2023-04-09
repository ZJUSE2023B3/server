package zju.se.b3.server.service;

import zju.se.b3.server.entity.User;
import zju.se.b3.server.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> FindbyId(Integer user_id)
    {
      return userMapper.FindbyId(user_id);
    }

    public Integer ChangePassword(User user)
    {
      return userMapper.ChangePassword(user);
    }

    public Integer Update(User user)
    {
      return userMapper.Update(user);
    }
}