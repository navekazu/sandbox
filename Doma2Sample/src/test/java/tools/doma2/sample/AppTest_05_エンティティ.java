package tools.doma2.sample;

import org.dbunit.IDatabaseTester;
import org.junit.*;
import org.seasar.doma.jdbc.tx.TransactionManager;
import tools.doma2.sample.config.Doma2SimpleConfig;
import tools.doma2.sample.dao.CompanySectionDao;
import tools.doma2.sample.dao.CompanySectionDaoImpl;
import tools.doma2.sample.dao.EmployeeDao;
import tools.doma2.sample.dao.EmployeeDaoImpl;
import tools.doma2.sample.domain.Email;
import tools.doma2.sample.domain.JobType;
import tools.doma2.sample.entity.CompanySection;
import tools.doma2.sample.entity.Employee;

import java.util.List;
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
    public void エンティティリスナ_ネーミング規約() {
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

    @Test
    public void イミュータブルなエンティティ() {
        TransactionManager tm = Doma2SimpleConfig.singleton().getTransactionManager();

        tm.required(() -> {
            // マスタ等、更新されない値
            CompanySectionDao  companySectionDao = new CompanySectionDaoImpl();
            List<CompanySection> list = companySectionDao.selectAll();

            assertEquals(list.get(0).id, Integer.valueOf(1));
            assertEquals(list.get(1).id, Integer.valueOf(2));
            assertEquals(list.get(2).id, Integer.valueOf(3));

            // イミュータブルだから更新できない
            // list.get(0).name = "not update";
        });
    }

    @Test
    public void アノテーション_OriginalStates() {
        TransactionManager tm = Doma2SimpleConfig.singleton().getTransactionManager();

        tm.required(() -> {
            EmployeeDao employeeDao = new EmployeeDaoImpl();
            Employee employee = employeeDao.selectById(1);

            // 取得時の値が@OriginalStatesを付けたフィールドに入れられている
            // @OriginalStatesは自身のエンティティ型と同じでなければならない
            assertEquals(employee.id, employee.originalStates.id);
            assertEquals(employee.name, employee.originalStates.name);
            assertEquals(employee.email, employee.originalStates.email);
            assertEquals(employee.jobType, employee.originalStates.jobType);
        });
    }
}
