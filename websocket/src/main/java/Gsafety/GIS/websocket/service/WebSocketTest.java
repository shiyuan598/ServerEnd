package Gsafety.GIS.websocket.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint(value = "/connect/{userid}")
@Component
public class WebSocketTest {
    private static ConcurrentHashMap<String, WebSocketTest> webSocketSet = new ConcurrentHashMap<String, WebSocketTest>();
    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;
    //当前发消息的人员编号
    private String userid = "";

    @OnOpen
    public void onOpen(@PathParam(value = "userid") String param, Session session) {
        this.session = session;
        this.userid = param;
        webSocketSet.put(this.userid, this);
        System.out.println(this.userid + "加入WebSocket连接...");
    }

    @OnClose
    public void onClose(Session session) {
        if (!userid.equals("")) {
            webSocketSet.remove(this.userid);
            System.out.println(this.userid + "关闭WebSocket连接...");
        }
    }

    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("WebSocket连接错误...");
        error.printStackTrace();
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        try {
            System.out.println(this.userid + "发送消息：" + message);
            String receiver = "";
            JSONObject jsonObject = JSONObject.parseObject(message); //将字符串{“id”：1}
            receiver = jsonObject.getString("receiver");
            System.out.println("接收者：" + receiver);

            if (this.userid.contains("gis")) {
                receiver = this.userid.replace("gis", "");
            } else {
                receiver = this.userid + "gis";
            }

            if (webSocketSet.get(receiver) != null) {
                webSocketSet.get(receiver).session.getBasicRemote().sendText(message);
            } else {
                System.out.println("用户" + receiver + "不在线！");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
