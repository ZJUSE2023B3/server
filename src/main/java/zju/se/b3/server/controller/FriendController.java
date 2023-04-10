package zju.se.b3.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zju.se.b3.server.entity.Friend;
import zju.se.b3.server.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/friend")
public class FriendController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<Friend> findall()
    {
        return userService.findall();
    }
    @GetMapping("/{user_id}")
    public List<Friend> Select(@PathVariable Integer user_id)
    {
        return userService.Select(user_id);
    }
    @PostMapping("/add")
    public Integer Add(@RequestBody Friend user)
    {
        return userService.Add(user);
    }
    @PostMapping("/delete")
    public Integer Delete(@RequestBody Friend user)
    {
        return userService.Delete(user);
    }
}
