package zju.se.b3.server.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zju.se.b3.server.entity.chatRecord;
import zju.se.b3.server.mapper.ChatMapper;

@Service
public class ChatService {
    @Autowired
    private ChatMapper chatmapper;
    public void DeleteRecord(Long id){
        if (chatmapper.findByid(id) == null) {
            throw new RuntimeException("该条记录已删除");
        }
        chatmapper.delete(id);
    }

    public void InsertRecord(chatRecord chatrecord){
        chatmapper.insert(chatrecord);
    }

    public chatRecord[] SearchRecord(Long user_id){
        return chatmapper.findByUserid(user_id);
    }

}
