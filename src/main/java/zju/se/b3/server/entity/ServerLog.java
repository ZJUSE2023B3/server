package zju.se.b3.server.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ServerLog")
@Data
public class ServerLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "log")
    private String log;

    @Column(name = "create_at")
    private String create_at;

}
