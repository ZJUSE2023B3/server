package zju.se.b3.server;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.socket.*;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.net.URI;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WebSocketControllerSocketTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testWebSocketController() throws Exception {
        WebSocketClient webSocketClient = new StandardWebSocketClient();
        LinkedBlockingQueue<TextMessage> receivedMessages = new LinkedBlockingQueue<>();

        TestWebSocketHandler clientHandler1 = new TestWebSocketHandler(receivedMessages);
        TestWebSocketHandler clientHandler2 = new TestWebSocketHandler(receivedMessages);

        WebSocketSession clientSession1 = webSocketClient.doHandshake(clientHandler1, new WebSocketHttpHeaders(), URI.create("ws://localhost:" + port + "/websocket")).get(5, TimeUnit.SECONDS);
        WebSocketSession clientSession2 = webSocketClient.doHandshake(clientHandler2, new WebSocketHttpHeaders(), URI.create("ws://localhost:" + port + "/websocket")).get(5, TimeUnit.SECONDS);

        // Construct the message with ID and password
        String id = "12345";
        String password = "myPassword";
        String combinedMessage = "ID: " + id + ", Password: " + password;

        // Send the combined message from client 1
        clientSession1.sendMessage(new TextMessage(combinedMessage));

        // Wait for client 2 to receive the message
        TextMessage receivedMessage = receivedMessages.poll(5, TimeUnit.SECONDS);
        assertEquals(combinedMessage, receivedMessage.getPayload());

        clientSession1.close();
        clientSession2.close();
    }

    private static class TestWebSocketHandler extends TextWebSocketHandler {

        private final LinkedBlockingQueue<TextMessage> receivedMessages;

        public TestWebSocketHandler(LinkedBlockingQueue<TextMessage> receivedMessages) {
            this.receivedMessages = receivedMessages;
        }

        @Override
        public void handleTextMessage(WebSocketSession session, TextMessage message) {
            receivedMessages.offer(message);
        }
    }
}
