package tools.doma2.sample;

import org.dbunit.IDatabaseTester;
import org.junit.*;
import tools.doma2.sample.dao.EmployeeDao;
import tools.doma2.sample.dao.EmployeeDaoImpl;

/**
 * 下記を参考にIntelliJでの設定を行った.
 * http://d.hatena.ne.jp/taedium/20121229/p1
 *
 *   クラスパスの設定は不要だった
 *
 *   File -> Settingsの内容は、
 *     「Store generated source relative to の項目で Module content root を選択」したうえで、
 *       Production sources directory -> target/apt_generated
 *       Test sources directory ->  target/apt_generated_test
 *     とした。
 *     （apt_generatedがpom.xmlに追加したDomaのビルドプラグインと同じになるようにした）
 *
 *   ソースフォルダの設定はDomaのビルドプラグインに合わせて、apt_generatedを見るようにした
 */
public class AppTest_03_基本型 extends AppTest {
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
        EmployeeDao employeeDao = new EmployeeDaoImpl();
    }
}
