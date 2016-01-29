package samples.websocketsample;

import org.eclipse.jetty.util.component.LifeCycle;

import javax.websocket.*;
import java.io.IOException;
import java.net.URI;

@ClientEndpoint
public class SampleClient {
    private WebSocketContainer container;
    private Session session;

    public SampleClient() {
    }

    public void connectServer() throws IOException, DeploymentException {
        URI uri = URI.create("ws://localhost:8080/hello/");
        container = ContainerProvider.getWebSocketContainer();
        session = container.connectToServer(SampleServerEndpoint.class, uri);
    }

    public void closeConnect() throws Exception {
        try {
            session.close();

        } finally {
            if (container instanceof LifeCycle) {
                ((LifeCycle)container).stop();
            }
        }
    }

    public void sendMessage(String message) throws IOException, InterruptedException {
        session.getBasicRemote().sendText(message);
        Thread.sleep(10000);
    }

    @OnMessage
    public void handleMessage(String message, Session sess) {
        System.out.println("Got your message -------> (" + message + "). Thanks !");
    }

}
