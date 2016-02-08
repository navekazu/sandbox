package tools.mybatis.sample;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.excel.XlsDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Before;
import org.junit.Test;
import tools.mybatis.sample.mapper.DataTableMapper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple App.
 * see -> http://www.mybatis.org/mybatis-3/ja/getting-started.html
 */
public class AppTest_02_スタートガイド {
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
    public void 文字列で実行するSQLを指定する場合() {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            assertEquals(session.selectOne("tools.mybatis.sample.mapper.DataTableMapper.selectValue", 1), "value_1");
        } finally {
            session.close();
        }
    }

    @Test
    public void インターフェースで実行するSQLを指定する場合() {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            DataTableMapper mapper = session.getMapper(DataTableMapper.class);
            assertEquals(mapper.selectValue(1), "value_1");
        } finally {
            session.close();
        }
    }

    @Test
    public void インターフェースのメソッドに付けたアノテーションで実行するSQLを指定する場合() {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            DataTableMapper mapper = session.getMapper(DataTableMapper.class);
            assertEquals(mapper.selectValueId2(), "value_2");
        } finally {
            session.close();
        }
    }
}
