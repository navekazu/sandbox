package tools.selenidesamples;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.screenshot;
import static org.junit.Assert.assertTrue;

public class AppTest {
    @BeforeClass
    public static void beforeClass() throws Exception {
        // http://selenium-release.storage.googleapis.com/index.html
        System.setProperty("webdriver.ie.driver", "C:\\SeleniumDriver\\IEDriverServer.exe");

        // https://github.com/mozilla/geckodriver/releases
        System.setProperty("webdriver.gecko.driver", "C:\\SeleniumDriver\\geckodriver.exe");

        // http://chromedriver.storage.googleapis.com/index.html
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver.exe");

//        Configuration.browser = WebDriverRunner.FIREFOX;
//        Configuration.browser = WebDriverRunner.CHROME;
        Configuration.browser = WebDriverRunner.INTERNET_EXPLORER;
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

    /*
    @Test
    public void seleniumTest() throws Exception {
//        WebDriver driver = new ChromeDriver();
//        WebDriver driver = new FirefoxDriver();
        WebDriver driver = new InternetExplorerDriver();
        driver.navigate().to("http://www.yahoo.co.jp/");
        driver.findElement(By.id("srchtxt")).sendKeys("selenium");
        driver.findElement(By.id("srchbtn")).click();
        driver.quit();
    }
    */

    @Test
    public void selenideTest() throws Exception {
        open("http://www.yahoo.co.jp/");
//        $(By.id("srchtxt")).val("selenide");
//        $(By.id("srchbtn")).click();
        $("#srchtxt").val("selenide");
        $("#srchbtn").click();
        $("#yschsp").shouldHave(text("selenide"));
//        screenshot("saved");
    }
}
