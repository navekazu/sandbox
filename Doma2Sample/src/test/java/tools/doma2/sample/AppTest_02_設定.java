package tools.doma2.sample;

import org.dbunit.IDatabaseTester;
import org.dbunit.operation.DatabaseOperation;
import org.junit.*;

import static org.junit.Assert.assertEquals;

public class AppTest_02_設定 extends AppTest {
    private IDatabaseTester databaseTester;

    @BeforeClass
    public static void beforeClass() throws Exception {
        deleteAfterCreateDatabase("./testdb_development", "ddl.sql", "dml.sql");
    }

    @AfterClass
    public static void afterClass() {
    }

    @Before
    public void before() throws Exception {
        databaseTester = getDatabaseTester("./testdb_development", "TestData.xls");
    }

    @After
    public void after() throws Exception {
        databaseTester.onTearDown();
    }

    @Test
    public void test1() {
        // Doma2SimpleConfigクラスが「設定」の章の内容
    }
}
