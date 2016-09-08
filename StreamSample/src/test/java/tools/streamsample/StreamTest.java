package tools.streamsample;

import org.junit.*;

import java.util.stream.Stream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StreamTest {
    @Test
    public void 空に対するallMatchのテスト() {
        Stream<String> stream1 = Stream.of("foo");
        assertTrue(stream1.allMatch(s -> "foo".equals(s)));

        Stream<String> stream2 = Stream.of("");
        assertFalse(stream2.allMatch(s -> "foo".equals(s)));

        Stream<String> stream3 = Stream.of();
        assertTrue(stream3.allMatch(s -> "foo".equals(s)));
    }
}
