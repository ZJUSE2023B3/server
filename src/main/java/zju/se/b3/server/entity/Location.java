package zju.se.b3.server.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Location")
@Data
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "user_id")
    private int user_id;

    @Column(name = "x")
    private String x;
    @Column(name = "y")
    private String y;
    @Column(name = "z")
    private String z;

    @Column(name = "last_update")
    private String last_update;





}
