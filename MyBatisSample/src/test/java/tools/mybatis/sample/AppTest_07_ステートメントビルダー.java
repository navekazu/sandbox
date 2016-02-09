package tools.mybatis.sample;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.excel.XlsDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tools.mybatis.sample.domain.DataTable;
import tools.mybatis.sample.mapper.DataTableMapper;
import tools.mybatis.sample.mapper.SqlMapper;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by k_watanabe on 2016/02/09.
 */
public class AppTest_07_ステートメントビルダー {
    private Logger logger = LoggerFactory.getLogger(AppTest_07_ステートメントビルダー.class);
    private SqlSessionFactory sqlSessionFactory;
    private IDatabaseTester databaseTester;

    @Before
    public void setup() throws Exception {
        // DBUnit setup
        databaseTester = new JdbcDatabaseTester(
                "org.h2.Driver",
                "jdbc:h2:file:testdb_development/testdb;DB_CLOSE_ON_EXIT=FALSE",
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
    public void シンプルなクエリのテスト() {

        try (SqlSession session = sqlSessionFactory.openSession()) {
            SqlMapper mapper = session.getMapper(SqlMapper.class);
            List<DataTable> list = mapper.simpleQuery();
            assertEquals(list.size(), 1);
            assertEquals(list.get(0).getValue(), "value_1");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void 匿名内部クラスのテスト() {

        try (SqlSession session = sqlSessionFactory.openSession()) {
            SqlMapper mapper = session.getMapper(SqlMapper.class);
            mapper.deleteDataTable();
            Integer count = mapper.countDataTable();
            assertEquals(count.intValue(), 4);
            session.rollback();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void メソッドチェーンのテスト() {

        try (SqlSession session = sqlSessionFactory.openSession()) {
            SqlMapper mapper = session.getMapper(SqlMapper.class);
            mapper.insertDataTable();
            Integer count = mapper.countDataTable();
            assertEquals(count.intValue(), 6);
            session.rollback();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void 条件分岐のテスト() {
/*
        try (SqlSession session = sqlSessionFactory.openSession()) {
            SqlMapper mapper = session.getMapper(SqlMapper.class);
            List<DataTable> list;

            list = mapper.selectDataTable(null, null);
            assertEquals(list.size(), 5);

            list = mapper.selectDataTable(1, null);
            assertEquals(list.size(), 1);

            list = mapper.selectDataTable(null, "value%");
            assertEquals(list.size(), 5);

            list = mapper.selectDataTable(null, "value_1");
            assertEquals(list.size(), 1);

            list = mapper.selectDataTable(2, "value_1");
            assertEquals(list.size(), 0);

        } catch(Exception e) {
            e.printStackTrace();
        }
*/
    }
}
