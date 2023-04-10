package zju.se.b3.server.entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "User")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int user_id;

    @Column(name = "user_name")
    private String user_name;

    @Column(name = "user_passwd")
    private String user_passwd;

    @Column(name = "email")
    private String email;

}
