package zju.se.b3.server.controller;


import org.springframework.beans.factory.annotation.Autowired;
import zju.se.b3.server.service.UserService;
import org.springframework.web.bind.annotation.*;
import zju.se.b3.server.entity.Friend;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;





}
