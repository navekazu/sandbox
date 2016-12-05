package tools.selenidesamples;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

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
    public void test() throws Exception {
        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("http://www.google.co.jp/");

//        open("http://www.google.co.jp/");
    }
}
