package tools.designpatternsample;

import org.junit.*;
import tools.designpatternsample.creationalPatterns.builder.Foo;

import static org.junit.Assert.assertEquals;

public class CreationalPatternsTest {

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
    public void builderTest() {
        Foo foo = Foo.builder()
                .value(100)
                .build();
        assertEquals(100, foo.getValue());
    }

}
