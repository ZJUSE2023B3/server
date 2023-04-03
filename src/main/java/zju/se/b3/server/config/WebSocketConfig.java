package zju.se.b3.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.*;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;
import zju.se.b3.server.controller.WebSocketController;

@Configuration
@EnableWebSocket
@CrossOrigin(origins = "*")
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(myHandler(), "/websocket");
    }

    @Bean
    public WebSocketHandler myHandler() {
        return new WebSocketController();
    }

}
