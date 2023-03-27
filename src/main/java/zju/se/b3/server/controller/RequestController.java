package zju.se.b3.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {
    /**
     * URL service
     * @param key1 a string from url
     * @param key2 a string from url
     *             A sample url: host/template?key1=xxx&key2=222
     * @return A string after process
     *             A sample return: xxx222
     */
    @GetMapping("template")
    public String template(@RequestParam(value = "key1") String key1, @RequestParam(value = "key2") String key2) {
        return key1 + key2;
    }

}
