package zju.se.b3.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zju.se.b3.server.entity.online;
import zju.se.b3.server.mapper.UserMapper;
import zju.se.b3.server.mapper.onlineMapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class OnlineService {

    @Autowired
    private zju.se.b3.server.mapper.onlineMapper onlineMapper;

    @Autowired
    private UserMapper userMapper;

    public void insert(String user_name){

        int user_id = userMapper.select_id_by_username(user_name);
        online online1 = new online();
        online1.setUser_id(user_id);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String nowString = formatter.format(now);

        online1.setLogin_time(nowString);
        online1.setUser_status("out_island");

        onlineMapper.insert(online1);
        return;
    }
}
