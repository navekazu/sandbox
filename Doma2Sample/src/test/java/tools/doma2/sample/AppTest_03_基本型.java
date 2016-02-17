package tools.doma2.sample;

import org.dbunit.IDatabaseTester;
import org.junit.*;
import tools.doma2.sample.dao.EmployeeDao;
import tools.doma2.sample.dao.EmployeeDaoImpl;

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
