package tools.doma2.sample;

import org.dbunit.IDatabaseTester;
import org.junit.*;
import org.seasar.doma.jdbc.tx.TransactionManager;
import tools.doma2.sample.config.Doma2SimpleConfig;
import tools.doma2.sample.dao.EmployeeDao;
import tools.doma2.sample.dao.EmployeeDaoImpl;
import tools.doma2.sample.domain.Email;
import tools.doma2.sample.domain.JobType;
import tools.doma2.sample.entity.Employee;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class AppTest_05_エンティティ extends AppTest {
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
        TransactionManager tm = Doma2SimpleConfig.singleton().getTransactionManager();

        tm.required(() -> {
            Employee emp = new Employee();
            emp.id = 0;
            emp.name = Optional.of("John");
            emp.email = Optional.of(Email.of("test@test.com"));
            emp.jobType = Optional.of(JobType.SALES);

            EmployeeDao employeeDao = new EmployeeDaoImpl();

            // insert/update/deleteの前後の処理をListenerで実装できる
            // エンティティのアノテーションに「listener=EmployeeEntityListener.class」を入れてListenerを通知し、
            // 「naming = NamingType.SNAKE_LOWER_CASE」でネーミング規約を宣言している。
            employeeDao.insert(emp);
        });
    }
}
