package tools.jaxbsample;

import org.junit.Before;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import javax.xml.bind.JAXB;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Before
    public void setup() {
    }

    @Test
    public void marshal() {
        Reaf root = new Reaf();
        root.putValue("testKey1", "testValue1");
        root.putValue("testKey2", "testValue2");

        Reaf child = new Reaf();
        root.addChild(child);
        child.putValue("testKey1", "testValue1");
        child.putValue("testKey2", "testValue2");

        child = new Reaf();
        root.addChild(child);
        child.putValue("testKey1", "testValue1");
        child.putValue("testKey2", "testValue2");

        JAXB.marshal(root, System.out);
    }

    @Test
    public void unmarshal() {
        Reaf root = new Reaf();
        root.putValue("testKey1", "testValue1");
        root.putValue("testKey2", "testValue2");

        Reaf child = new Reaf();
        root.addChild(child);
        child.putValue("testKey1", "testValue1");
        child.putValue("testKey2", "testValue2");

        child = new Reaf();
        root.addChild(child);
        child.putValue("testKey1", "testValue1");
        child.putValue("testKey2", "testValue2");

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        JAXB.marshal(root, out);
        
        ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
        Reaf unmarchaled = JAXB.unmarshal(in, Reaf.class);
        
        assertEquals(root, unmarchaled);
    }
}
