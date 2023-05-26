package zju.se.b3.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zju.se.b3.server.mapper.ServerLogMapper;
import zju.se.b3.server.mapper.UserMapper;

@Service
public class ServerLogService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ServerLogMapper serverLogMapper;

    public int insert(String user_name, String log){
        int user_id = userMapper.select_id_by_username(user_name);
        String id = Integer.toString(user_id);
        return serverLogMapper.insert(id+" "+log);
    }
    public int insert(int user_id,String log){
        String id = Integer.toString(user_id);
        return serverLogMapper.insert(id+" "+log);
    }


}
