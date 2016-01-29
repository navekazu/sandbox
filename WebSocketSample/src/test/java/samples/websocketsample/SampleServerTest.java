package samples.websocketsample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class SampleServerTest {
    private SampleServer server;
    @Before
    public void before() throws Exception {
        server = new SampleServer();
        server.start();
    }

    @After
    public void after() throws Exception {
        server.stop();
    }

    @Test
    public void test() throws Exception {
        SampleClient client1 = new SampleClient();
        SampleClient client2 = new SampleClient();
        client1.connectServer();
        client2.connectServer();

        client1.sendMessage("Hello1");

        client1.closeConnect();
        client2.closeConnect();
    }
}
