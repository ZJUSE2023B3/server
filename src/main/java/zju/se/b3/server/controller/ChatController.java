package zju.se.b3.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zju.se.b3.server.mapper.ChatMapper;
import zju.se.b3.server.service.ChatService;
import zju.se.b3.server.entity.chatRecord;

import java.util.*;

@RestController
@RequestMapping("/chatRecord")
public class ChatController {
    @Autowired
    private ChatService chatService;
    @GetMapping("/search")
    public List<chatRecord> search(@RequestParam Long user_id, @RequestParam Long friend_id){
        return chatService.SearchRecord(user_id,friend_id);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam Long id){
        chatService.DeleteRecord(id);
    }

    @PostMapping("/newchat")
    public void newchat(@RequestBody chatRecord onerecord){
        chatService.InsertRecord(onerecord);
    }
}
