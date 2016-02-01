package tools.mybatis.sample;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.excel.XlsDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Before;
import org.junit.Test;
import tools.mybatis.sample.domain.DataTable;
import tools.mybatis.sample.mapper.DataTableMapper;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by k_watanabe on 2016/01/25.
 */
public class AppTest_05_動的SQL {
    private SqlSessionFactory sqlSessionFactory;
    private IDatabaseTester databaseTester;

    @Before
    public void setup() throws Exception {
        // DBUnit setup
        databaseTester = new JdbcDatabaseTester(
                "org.h2.Driver",
                "jdbc:h2:file:testdb/testdb;DB_CLOSE_ON_EXIT=FALSE",
                "sa", // user
                ""    // pass
        );
        databaseTester.setDataSet(
                new XlsDataSet(new File("TestData.xls"))
        );
        databaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
        databaseTester.onSetup();

        // MyBatis setup
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void if文() {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            DataTableMapper mapper = session.getMapper(DataTableMapper.class);
            DataTable dataTable;

            dataTable = mapper.specificationIf1(DataTable.builder().id(1).build());
            assertEquals(dataTable.getId().intValue(), 1);

            dataTable = mapper.specificationIf1(DataTable.builder().id(1).value("miss").build());
            assertNull(dataTable);

            List<DataTable> list;
            list = mapper.specificationIf2(DataTable.builder().id(1).build());
            assertEquals(list.get(0).getId().intValue(), 1);

            list = mapper.specificationIf2(DataTable.builder().value("value_1").build());
            assertEquals(list.get(0).getId().intValue(), 1);

            list = mapper.specificationIf2(DataTable.builder().build());
            assertEquals(list.size(), 5);

        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    @Test
    public void set文() {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            DataTableMapper mapper = session.getMapper(DataTableMapper.class);
            DataTable dataTable;
            List<DataTable> list;

            mapper.specificationSet(DataTable.builder().id(1).value("aaaa").build());
            dataTable = mapper.specificationIf1(DataTable.builder().id(1).build());
            assertEquals(dataTable.getValue(), "aaaa");

            mapper.specificationSet(DataTable.builder().id(1).value("value_1").build());

        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Test
    public void choose文() {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            DataTableMapper mapper = session.getMapper(DataTableMapper.class);
            DataTable dataTable;
            List<DataTable> list;

            // 「<when test="id != null">」に該当して、ID=1が取れるはず
            list = mapper.specificationChoose(DataTable.builder().id(1).build());
            assertEquals(list.size(), 1);

            // 「<when test="value != null">」に該当して、VALUE=value_1が取れるはず
            list = mapper.specificationChoose(DataTable.builder().value("value_1").build());
            assertEquals(list.size(), 1);

            // 「<otherwise>」に該当して、ID=1が取れるはず
            list = mapper.specificationChoose(DataTable.builder().build());
            assertEquals(list.size(), 1);


        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Test
    public void trim文() {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            DataTableMapper mapper = session.getMapper(DataTableMapper.class);
            List<DataTable> list;

            // whereの直後の最初のandが削除され、SQLエラーは発生しない
            list = mapper.specificationTrimWhere(DataTable.builder().id(1).build());
            assertEquals(list.size(), 1);

            // setの最後の , が削除され、SQLエラーは発生しない
            mapper.specificationTrimSet(DataTable.builder().id(1).value("aaa").build());
            list = mapper.specificationTrimWhere(DataTable.builder().value("aaa").build());
            assertEquals(list.size(), 1);

            mapper.specificationTrimSet(DataTable.builder().id(1).value("value_1").build());
            list = mapper.specificationTrimWhere(DataTable.builder().id(1).build());
            assertEquals(list.size(), 1);

        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Test
    public void foreach文() {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            DataTableMapper mapper = session.getMapper(DataTableMapper.class);
            List<DataTable> list;
            List<Integer> ids = new ArrayList<>();
            ids.add(1);
            ids.add(2);
            ids.add(5);

            list = mapper.specificationForeach(ids);
            assertEquals(list.size(), 3);


        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
