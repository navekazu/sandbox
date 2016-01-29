package samples.websocketsample;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Set;

@ClientEndpoint
@ServerEndpoint("/hello/")
public class SampleServerEndpoint {
    @OnMessage
    public void handleMessage(String message, Session sess) throws IOException {
        System.out.println("Got your message (" + message + "). Thanks !");

        Set ss = sess.getOpenSessions();
        sess.getOpenSessions().forEach(s -> {
            s.getAsyncRemote().sendText("aaaaaa");
        });
    }

    @OnOpen
    public void handleOpen(Session sess) {
        System.out.println("開始します：" + sess.getId());
    }

    @OnClose
    public void handleClose(Session sess) {
        System.out.println("終了します：" + sess.getId());
    }

    @OnError
    public void handleError(Session sess, Throwable t) {
        System.out.println("エラーです：" + sess.getId());
        t.printStackTrace();
    }
}
