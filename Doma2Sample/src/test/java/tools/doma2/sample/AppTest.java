package tools.doma2.sample;

// 以下に従ってDoma2を使う
// http://doma.readthedocs.org/ja/stable/

import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.excel.XlsDataSet;
import org.dbunit.operation.DatabaseOperation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class AppTest {

    public static void deleteAfterCreateDatabase(String database, String ddl, String dml) throws Exception {
        // drop database
        if (Files.exists(Paths.get(database))) {
            Files.list(Paths.get(database)).forEach(path -> {
                try {
                    Files.delete(path);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        // DBUnit setup
        IDatabaseTester databaseTester = new JdbcDatabaseTester(
                "org.h2.Driver",
                String.format("jdbc:h2:file:%s/testdb;DB_CLOSE_ON_EXIT=FALSE", database),
                "sa", // user
                ""    // pass
        );

        // execute ddl
        Connection conn = databaseTester.getConnection().getConnection();
        Statement statement = conn.createStatement();
        List<String> sqlList = new ArrayList<>();
        String[] ddls = readFile(ddl).split(";\\n");     // ";" か "/" で終わる行ごとに分ける
        String[] dmls = readFile(dml).split(";\\n");     // ";" か "/" で終わる行ごとに分ける
        sqlList.addAll(Arrays.asList(ddls));
        sqlList.addAll(Arrays.asList(dmls));
        sqlList.stream()
                .filter(sql -> sql.trim().length() >= 1)
                .forEach(sql -> {
                    try {
                        statement.execute(sql);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });

        conn.commit();              // DDLだから必要ないかもしれないが、SQLiteみたいにcommitしないとならないものもあるので念のため

        databaseTester.onTearDown();
    }

    private static String readFile(String path) throws IOException {
        if (path==null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        Files.readAllLines(Paths.get(path)).stream().forEach(line -> sb.append(line).append("\n"));
        return sb.toString();
    }

    public IDatabaseTester getDatabaseTester(String database, String dmlExcel) throws Exception {
        // DBUnit setup
        IDatabaseTester databaseTester = new JdbcDatabaseTester(
            "org.h2.Driver",
            String.format("jdbc:h2:file:%s/testdb;DB_CLOSE_ON_EXIT=FALSE", database),
            "sa", // user
            ""    // pass
        );


        // execute dml
        databaseTester.setDataSet(
                new XlsDataSet(new File(dmlExcel))
        );
        databaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
        databaseTester.onSetup();

        return databaseTester;
    }

}
