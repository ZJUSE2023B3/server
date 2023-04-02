package zju.se.b3.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zju.se.b3.server.mapper.UserMapper;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public int login(String user_name, String user_passwd){
        if(userMapper.select_by_username(user_name)==0)return 1;
        if(userMapper.select_by_username_and_passwd(user_name,user_passwd)==0)return 2;
        return 0;
    }
    public int logup(String user_name, String user_passwd, String email){
        if(userMapper.select_by_username(user_name)>0)return 2;
        return userMapper.insert(user_name,user_passwd,email);
    }
}
