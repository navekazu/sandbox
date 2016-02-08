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
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Unit test for simple App.
 * see -> http://www.mybatis.org/mybatis-3/ja/sqlmap-xml.html
 */
public class AppTest_04_MapperXMLファイル {
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
    public void insertしてupdateしてdelete() {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            DataTableMapper mapper = session.getMapper(DataTableMapper.class);

            // insert
            mapper.insertValue(new DataTable(999, "value_999"));
            assertEquals(mapper.selectValue(999), "value_999");

            // update
            mapper.updateValue(new DataTable(999, "value_999___"));
            assertEquals(mapper.selectValue(999), "value_999___");

            // delete
            mapper.deleteValue(999);
            assertNull(mapper.selectValue(999));
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Test
    public void ResultMapを使用する() {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            DataTableMapper mapper = session.getMapper(DataTableMapper.class);
            DataTable dataTable = mapper.selectValueByResultMap(1);
            assertEquals(dataTable.getId().intValue(), 1);
            assertEquals(dataTable.getValue(), "value_1");

        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Test
    public void 複数行を取得する() {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            DataTableMapper mapper = session.getMapper(DataTableMapper.class);
            List<DataTable> list = mapper.selectMultiRow();
            assertEquals(list.size(), 5);

        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
