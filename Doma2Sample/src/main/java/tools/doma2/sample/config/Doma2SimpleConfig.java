package tools.doma2.sample.config;

import org.seasar.doma.SingletonConfig;
import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.dialect.Dialect;
import org.seasar.doma.jdbc.dialect.H2Dialect;
import org.seasar.doma.jdbc.tx.LocalTransactionDataSource;
import org.seasar.doma.jdbc.tx.LocalTransactionManager;
import org.seasar.doma.jdbc.tx.TransactionManager;

import javax.sql.DataSource;

/**
 * シンプルな定義.
 *
 * シンプルな定義は次の場合に適しています。
 * ・DIコンテナで管理しない
 * ・ローカルトランザクションを使用する
 */
@SingletonConfig
public class Doma2SimpleConfig implements Config {
    private static final Doma2SimpleConfig CONFIG = new Doma2SimpleConfig();
    private final Dialect dialect;
    private final LocalTransactionDataSource dataSource;
    private final TransactionManager transactionManager;

    private Doma2SimpleConfig() {
        dialect = new H2Dialect();
        dataSource = new LocalTransactionDataSource(
                "jdbc:h2:file:./testdb_development/testdb;DB_CLOSE_ON_EXIT=FALSE", "sa", null);
        transactionManager = new LocalTransactionManager(
                dataSource.getLocalTransaction(getJdbcLogger()));
    }

    /**
     * データベースの方言を定義する
     * @return 方言
     */
    @Override
    public Dialect getDialect() {
        return dialect;
    }

    /**
     * データソースを返す
     * @return データソース
     */
    @Override
    public DataSource getDataSource() {
        return dataSource;
    }

    /**
     * トランザクションマネージャを返す
     * @return トランザクションマネージャ
     */
    @Override
    public TransactionManager getTransactionManager() {
        return transactionManager;
    }

    /**
     * 定義のシングルトンオブジェクトを返す
     * @return シングルトンオブジェクト
     */
    public static Doma2SimpleConfig singleton() {
        return CONFIG;
    }
}
