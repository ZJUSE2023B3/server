package zju.se.b3.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private WebSocketController webSocketController;

    @PostMapping("/broadcast")
    public ResponseEntity<Void> broadcastMessage(@RequestBody String message) {
        webSocketController.broadcastMessage(message);
        return ResponseEntity.ok().build();
    }
}
