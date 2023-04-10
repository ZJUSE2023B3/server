package zju.se.b3.server.controller;

import zju.se.b3.server.entity.User;
import zju.se.b3.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{user_id}")
    public List<User> FindbyId(@PathVariable Integer user_id)
    {
        return userService.FindbyId(user_id);
    }

    @PostMapping("/update/email")
    public Integer Update(@RequestBody User user)
    {
        return userService.ChangeEmail(user);
    }

    @PostMapping("/update/passwd")
    public Integer ChangePassword(@RequestBody User user)
    {
      return userService.ChangePassword(user);
    }
}
