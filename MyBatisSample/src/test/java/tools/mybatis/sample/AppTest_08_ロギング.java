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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tools.mybatis.sample.domain.DataTable;
import tools.mybatis.sample.mapper.DataTableMapper;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class AppTest_08_ロギング {
    private Logger logger = LoggerFactory.getLogger(AppTest_08_ロギング.class);
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

        // ログ出力にどの実装を使用するかは、mybatis-config.xmlに記述する
        // <configuration>
        //   <settings>
        //     ...
        //     <setting name="logImpl" value="SLF4J"/>
        //     ...
        //   </settings>
        // </configuration>

        // あとはSLF4J(Logback)の設定をする
        // <configuration>
        //   <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
        //     <encoder>
        //       <pattern>%d{HH:mm:ss.SSS} %-5level %logger{10} %msg%n</pattern>
        //     </encoder>
        //   </appender>
        //   <logger name="tools.mybatis.sample.mapper.DataTableMapper" level="DEBUG" />
        //   <root>
        //     <appender-ref ref="STDOUT" />
        //   </root>
        // </configuration>

        // マッパーを指定して出力する場合は上記のようにし、パッケージ全体のマッパーを指定する場合は下記のようにする
        //   <logger name="tools.mybatis.sample.mapper" level="DEBUG" />

    }

    @Test
    public void ログ出力の確認() {

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
}
