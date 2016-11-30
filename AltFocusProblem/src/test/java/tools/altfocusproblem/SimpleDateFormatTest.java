package tools.altfocusproblem;

import org.junit.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class SimpleDateFormatTest {

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
    public void testFormatStreamPattern() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
        Date date = new Date();
        String expected = sdf.format(date);

        List<Integer> sampleData = new ArrayList<>();
        IntStream.rangeClosed(1, 3000000).forEach(i -> sampleData.add(i));

        sampleData.stream().forEach(i -> assertEquals(expected, sdf.format(date)));
    }
    @Test
    public void testFormatParallelStreamPattern() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
        Date date = new Date();
        String expected = sdf.format(date);

        List<Integer> sampleData = new ArrayList<>();
        IntStream.rangeClosed(1, 3000000).forEach(i -> sampleData.add(i));

        ForkJoinPool forkJoinPool = new ForkJoinPool(10000);
        forkJoinPool.submit(() ->
                        sampleData.parallelStream()
                                .forEach(i -> assertEquals(expected, sdf.format(date)))
        );
    }

    @Test
    public void testParseStreamPattern() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
        String date = "2016/11/16 11:09:08.012";
        Date expected = sdf.parse(date);

        List<Integer> sampleData = new ArrayList<>();
        IntStream.rangeClosed(1, 30000).forEach(i -> sampleData.add(i));

        sampleData.stream().forEach(i -> {
            try {
                assertEquals(expected, sdf.parse(date));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        });
    }
    @Test
    public void testParseParallelStreamPattern() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
        String date = "2016/11/16 11:09:08.012";
        Date expected = sdf.parse(date);

        List<Integer> sampleData = new ArrayList<>();
        IntStream.rangeClosed(1, 30000).forEach(i -> sampleData.add(i));

        ForkJoinPool forkJoinPool = new ForkJoinPool(10000);
        forkJoinPool.submit(() ->
                        sampleData.parallelStream()
                                .forEach(i -> {
                                    try {
                                        assertEquals(expected, sdf.parse(date));
                                    } catch (ParseException e) {
                                        e.printStackTrace();
                                    }
                                })
        );
    }
}
