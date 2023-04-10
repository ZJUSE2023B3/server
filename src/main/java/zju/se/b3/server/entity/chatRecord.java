package zju.se.b3.server.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "charRecord")
public class chatRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long user_id;
    @Column(name = "friend_id")
    private Long friend_id;

    @Column(name = "message")
    private String message;

    @Column(name = "created_at")
    private String created_at;

    public String to_String(){
        String s = "id:"+id.toString()+" user_id:"+user_id.toString()+ " friend_id:"+friend_id.toString()
                +" message:"+message.toString()+" time:"+created_at.toString();
        return s;
    }

    public chatRecord(Long Id, Long User_Id, Long Friend_Id, String Message, String time){
        id = Id;
        user_id = User_Id;
        friend_id = Friend_Id;
        message = Message;
        created_at = time;
    }
}
