package zju.se.b3.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import zju.se.b3.server.mapper.onlineMapper;

@RestController
public class OnlineController {
    @Autowired
    private zju.se.b3.server.mapper.onlineMapper onlineMapper;

    @GetMapping("/in_island")
    public int in_island(@RequestParam int user_id){
        return onlineMapper.change_status(user_id,"in_island");
    }

    @GetMapping("/out_island")
    public int out_island(@RequestParam int user_id){
        return onlineMapper.change_status(user_id,"out_island");
    }

    @GetMapping("/offline")
    public int offline(@RequestParam int user_id){
        return onlineMapper.delete(user_id);
    }

}
