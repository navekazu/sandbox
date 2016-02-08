package tools.mybatis.sample;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
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
import tools.mybatis.sample.domain.EnvInfo;
import tools.mybatis.sample.mapper.DataTableMapper;
import tools.mybatis.sample.mapper.EnvInfoMapper;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class AppTest_06_JavaAPI {
//    private SqlSessionFactory sqlSessionFactory;
//    private IDatabaseTester databaseTester;

    @Before
    public void setup() throws Exception {
        // DBUnit setup
        /*
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
        */


        // MyBatis setup
//        String resource = "mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // NOTE:
        // MyBatis を Spring や Guice といった依存性注入（DI = Dependency Injection）フレームワークと組み合わせて使う場合、
        // SqlSession は DI フレームワークによって作成・注入されます。
        // SqlSessionFactoryBuilder や SqlSessionFactory を使う必要はありませんので、SqlSession の章まで飛ばして構いません。
        // DIフレームワークとの組み合わせについては MyBatis-Spring および MyBatis-Guice のマニュアルを参照してください。
    }

    @Test
    public void SqlSessionFactoryBuilderのテスト() {
        SqlSession session = null;

        // default(development)環境につなぐ
        try {
            // MyBatis setup
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            session = sqlSessionFactory.openSession();
            EnvInfoMapper mapper = session.getMapper(EnvInfoMapper.class);
            EnvInfo info = mapper.selectEnvInfo(1);
            assertEquals(info.getValue(), "development");

        } catch(Exception e) {

        } finally {
            if (session!=null) {
                session.close();
            }
        }

        // development環境につなぐ
        try {
            // MyBatis setup
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, "development");
            session = sqlSessionFactory.openSession();
            EnvInfoMapper mapper = session.getMapper(EnvInfoMapper.class);
            EnvInfo info = mapper.selectEnvInfo(1);
            assertEquals(info.getValue(), "development");

        } catch(Exception e) {

        } finally {
            if (session!=null) {
                session.close();
            }
        }

        // production環境につなぐ
        try {
            // MyBatis setup
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, "production");
            session = sqlSessionFactory.openSession();
            EnvInfoMapper mapper = session.getMapper(EnvInfoMapper.class);
            EnvInfo info = mapper.selectEnvInfo(1);
            assertEquals(info.getValue(), "production");

        } catch(Exception e) {

        } finally {
            if (session!=null) {
                session.close();
            }
        }
    }

    @Test
    public void SqlSessionFactoryのテスト() {

        try {
            // MyBatis setup
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            // 引数なしのopenSession
            // ・トランザクションスコープが開始されます（つまり auto-commit ではないということです）。
            // ・Connection オブジェクトは、現在の environment で設定されている DataSource インスタンスから取得されます。
            // ・ドライバーまたはデータソースのデフォルトのトランザクション分離レベルが適用されます。
            // ・PreparedStatement は再利用されず、バッチ更新も行われません。
            try (SqlSession session = sqlSessionFactory.openSession()) {
                EnvInfoMapper mapper = session.getMapper(EnvInfoMapper.class);
                EnvInfo info = mapper.selectEnvInfo(1);
                assertEquals(info.getValue(), "development");
            }

        } catch(Exception e) {

        } finally {
        }
    }

    @Test
    public void SqlSessionのテスト() throws Exception {

        // MyBatis setup
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try (SqlSession session = sqlSessionFactory.openSession()) {
            String value = session.selectOne("tools.mybatis.sample.mapper.EnvInfoMapper.selectValue", 1);
            assertEquals(value, "development");

            List<String> valuesList = session.selectList("tools.mybatis.sample.mapper.EnvInfoMapper.selectValue", 1);
            assertEquals(valuesList.size(), 1);
            assertEquals(valuesList.get(0), "development");

            // 使い道がわからないので飛ばす
            //Map<Integer, String> valuesMap = session.selectMap("tools.mybatis.sample.mapper.EnvInfoMapper.selectValue", 1, "id");
            //assertEquals(valuesMap.size(), 1);
            //assertEquals(valuesMap.get(1), "development");

            // RowBoundsで指定された数のレコードをスキップする
            List<DataTable> dataTableList = session.selectList("tools.mybatis.sample.mapper.DataTableMapper.selectMultiRow", null, new RowBounds(1, 3));
            assertEquals(dataTableList.size(), 3);
            assertEquals(dataTableList.get(0).getValue(), "value_2");
            assertEquals(dataTableList.get(1).getValue(), "value_3");
            assertEquals(dataTableList.get(2).getValue(), "value_4");

        }

    }
}
