package zju.se.b3.server.controller;


import org.springframework.beans.factory.annotation.Autowired;
import zju.se.b3.server.service.UserService;
import org.springframework.web.bind.annotation.*;
import zju.se.b3.server.entity.Friend;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * URL service
     * @param user_name a string from QueryParams
     * @param user_passwd a string from QueryParams
     *             A sample url: host/login?user_name=user1&user_passwd=password1
     * @return an integer num:
     *              0 for login success
     *              1 for "no user names {#user_name}" error
     *              2 for "invalid passwd" error
     *         A sample return: 0
     */
    @GetMapping("/login")
    public int login(@RequestParam String user_name,
                     @RequestParam String user_passwd){
        return userService.login(user_name,user_passwd);
    }
    /**
     * URL service
     * @param user_name a string from QueryParams
     * @param user_passwd a string from QueryParams
     * @param email a string from QueryParams
     *             A sample url: host/logup?user_name=user1&user_passwd=password1&email=user1@example.com
     * @return an integer num:
     *              0 for server error
     *              1 for logup success
     *              2 for "user_name already exist" error
     *         A sample return: 0
     */
    @PostMapping ("/logup")
    public int logup(@RequestParam String user_name,
                     @RequestParam String user_passwd,
                     @RequestParam String email){
        return userService.logup(user_name,user_passwd,email);
    }
    @GetMapping("/friend/")
    public List<Friend> findall()
    {
        return userService.findall();
    }
    @GetMapping("/friend/{user_id}")
    public List<Friend> Select(@PathVariable Integer user_id)
    {
        return userService.Select(user_id);
    }
    @PostMapping("/friend/add")
    public Integer Add(@RequestBody Friend user)
    {
        return userService.Add(user);
    }
    @PostMapping("/friend/delete")
    public Integer Delete(@RequestBody Friend user)
    {
        return userService.Delete(user);
    }

}
