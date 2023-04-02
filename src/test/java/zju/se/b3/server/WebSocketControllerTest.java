package zju.se.b3.server;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import zju.se.b3.server.controller.WebSocketController;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class WebSocketControllerTest {

    @Test
    public void testBroadcastMessage() throws Exception {
        // 创建模拟的WebSocketSession对象
        WebSocketSession session1 = mock(WebSocketSession.class);
        WebSocketSession session2 = mock(WebSocketSession.class);

        when(session1.isOpen()).thenReturn(true);
        when(session2.isOpen()).thenReturn(true);

        // 创建MyHandler实例并添加模拟的WebSocketSession对象
        WebSocketController webSocketController = new WebSocketController();
        webSocketController.afterConnectionEstablished(session1);
        webSocketController.afterConnectionEstablished(session2);

        // 广播消息
        String broadcastMessage = "这是一条广播消息";
        webSocketController.broadcastMessage(broadcastMessage);

        // 由于广播是异步的，因此我们需要等待一段时间以确保任务完成
        Thread.sleep(1000);

        // 验证每个客户端是否收到了广播消息
        verify(session1).sendMessage(new TextMessage(broadcastMessage));
        verify(session2).sendMessage(new TextMessage(broadcastMessage));


        // 创建ArgumentCaptor以捕获传递给sendMessage方法的TextMessage对象
        ArgumentCaptor<TextMessage> messageCaptor = ArgumentCaptor.forClass(TextMessage.class);

        // 验证sendMessage方法是否被正确调用，并捕获传递的TextMessage对象
        verify(session1).sendMessage(messageCaptor.capture());
        verify(session2).sendMessage(messageCaptor.capture());

        // 获取捕获到的TextMessage对象的列表
        List<TextMessage> capturedMessages = messageCaptor.getAllValues();

        // 使用assertEquals方法验证消息内容
        assertEquals(broadcastMessage, capturedMessages.get(0).getPayload());
        assertEquals(broadcastMessage, capturedMessages.get(1).getPayload());

    }
}
