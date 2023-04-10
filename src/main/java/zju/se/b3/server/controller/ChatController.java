package zju.se.b3.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zju.se.b3.server.mapper.ChatMapper;
import zju.se.b3.server.service.ChatService;
import zju.se.b3.server.entity.chatRecord;

@RestController
@RequestMapping("/charRecord")
public class ChatController {
    @Autowired
    private ChatService chatService;
    @PostMapping("/search")
    public String[] search(@RequestParam Long user_id){
        chatRecord[] records = chatService.SearchRecord(user_id);
        String[] s = new String[records.length];
        for(int i = 0;i<records.length;i++)
        {
            s[i] = records[i].to_String();
        }
        return s;
    }

    @PostMapping("/delete")
    public void delete(@RequestParam Long id){
        chatService.DeleteRecord(id);
    }

    @PostMapping("/newchat")
    public void newchat(@RequestBody Long id, @RequestBody Long user_id, @RequestBody Long friend_id,
                        @RequestBody String message, @RequestBody String creat_at){
        chatRecord record = new chatRecord(id, user_id, friend_id, message, creat_at);
        chatService.InsertRecord(record);
    }
}
