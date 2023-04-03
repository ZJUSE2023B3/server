package zju.se.b3.server.controller;

import org.apache.ibatis.ognl.IntHashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import zju.se.b3.server.service.UserService;

import java.io.IOException;
import java.net.URI;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Controller
public class WebSocketController extends TextWebSocketHandler {

    @Autowired
    private UserService userService;

    private static final int NUM_THREADS = 4;
    private static final ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

    /*Spring Framework 中的缓存管理器，当作map来用*/
    @Autowired
    private CacheManager cacheManager;

    //private final ConcurrentHashMap<String, WebSocketSession> clientidSessionMap = new ConcurrentHashMap<>();



    private final Set<WebSocketSession> sessions = new CopyOnWriteArraySet<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception{
        // 获取客户端发送的 user_id
        URI uri = session.getUri();
        assert uri != null;
        int user_id = Integer.parseInt(uri.getQuery().split("=")[1]);
        session.getAttributes().put("user_id",user_id);

        Cache cache = cacheManager.getCache("userid_session_map");
        // 将 user_id 作为 client_id 存入 userid_session_map
        assert cache != null;
        cache.put(user_id,session);

        sessions.add(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        // 获取该 WebSocketSession 对应的 user_id
        Map<String, Object> attributes = session.getAttributes();
        int user_id = (int) attributes.get("user_id");
        // 将该user_id释放
        Cache cache = cacheManager.getCache("userid_session_map");
        assert cache != null;
        cache.evict(user_id);
        sessions.remove(session);
    }

    public void broadcastMessage(String message) {
        for (WebSocketSession session : sessions) {
            executorService.submit(() -> {
                try {
                    if (session.isOpen()) {
                        session.sendMessage(new TextMessage(message));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }
    public void sendMessage(String message,int user_id){
        Cache cache = cacheManager.getCache("userid_session_map");
        assert cache != null;
        WebSocketSession target = (WebSocketSession) cache.get(user_id);
        executorService.submit(()->{
            try {
                assert target != null;
                if (target.isOpen()) {
                    target.sendMessage(new TextMessage(message));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
