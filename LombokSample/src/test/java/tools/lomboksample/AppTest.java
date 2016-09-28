package tools.lomboksample;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class AppTest {

    @BeforeClass
    public static void beforeClass() throws Exception {
    }

    @AfterClass
    public static void afterClass() throws Exception {
    }

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void test() {
        SubEntity sub = new SubEntity();
        sub.setField01(1);
        sub.setField02(2);

        assertEquals(1, sub.getField01());
        assertEquals(2, sub.getField02());
    }
}
