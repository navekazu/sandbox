package tools.doma2.sample;

import org.dbunit.IDatabaseTester;
import org.junit.*;
import tools.doma2.sample.domain.Email;
import tools.doma2.sample.domain.Identity;
import tools.doma2.sample.domain.JobType;
import tools.doma2.sample.entity.Employee;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class AppTest_04_ドメインクラス extends AppTest {
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
        Employee emp = new Employee();
        emp.id = 0;
        emp.name = Optional.of("John");
        emp.email = Optional.of(Email.of("test@test.com"));
        emp.jobType = Optional.of(JobType.SALES);

        assertEquals(emp.id, Integer.valueOf(0));
    }
}
