package toole.newwarekitest;

import org.junit.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

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
    public void 和暦のテスト() {
        Calendar today = Calendar.getInstance();
        today.set(2016, 6, 14, 0, 0, 0);

        Calendar future = Calendar.getInstance();
        future.set(2020, 0, 1, 0, 0, 0);

        Calendar startHeisei = Calendar.getInstance();
        startHeisei.setTimeInMillis(-1357603200000L);

        Locale locale = new Locale("ja", "JP", "JP");
        SimpleDateFormat sdfLong = new SimpleDateFormat("GGGGyy/MM/dd HH:mm:ss.SSS", locale);

        System.out.println(sdfLong.format(today.getTime()));
        System.out.println(sdfLong.format(future.getTime()));
        System.out.println(sdfLong.format(startHeisei.getTime()));
    }

    @Test
    public void シリアル値のチェック() {
        Calendar future = Calendar.getInstance();
        future.set(2020, 0, 1, 9, 0, 0);
        System.out.println(future.getTimeInMillis());
    }

    @Test
    public void プロパティ地のチェック() {
        System.getProperties().keySet().stream().forEach(k -> System.out.println("getProperties -> "+k+":"+System.getProperties().get(k)));

    }
}

