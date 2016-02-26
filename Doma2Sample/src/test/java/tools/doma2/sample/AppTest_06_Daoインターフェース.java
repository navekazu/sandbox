package tools.doma2.sample;

import org.dbunit.IDatabaseTester;
import org.junit.*;
import org.seasar.doma.jdbc.tx.TransactionManager;
import tools.doma2.sample.config.Doma2SimpleConfig;
import tools.doma2.sample.dao.EmployeeDao;
import tools.doma2.sample.dao.EmployeeDaoImpl;
import tools.doma2.sample.entity.Employee;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AppTest_06_Daoインターフェース extends AppTest {
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
    public void デフォルトメソッド() {
        TransactionManager tm = Doma2SimpleConfig.singleton().getTransactionManager();

        tm.required(() -> {
            // デフォルトメソッドでは任意の処理を記述できる
            EmployeeDao employeeDao = new EmployeeDaoImpl();
            assertEquals(Integer.valueOf(employeeDao.count()), Integer.valueOf(1));
        });
    }
}
