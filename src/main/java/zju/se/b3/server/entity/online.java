package zju.se.b3.server.entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "online")
@Data
public class online {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "user_id")
    private int user_id;

    @Column(name = "login_time")
    private String login_time;

    @Column(name = "user_status")
    private String user_status;

}
