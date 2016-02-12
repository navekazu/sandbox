package tools.doma2.sample.config;

import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.dialect.Dialect;

import javax.sql.DataSource;

public class Doma2Config implements Config {
    @Override
    public DataSource getDataSource() {
        return null;
    }

    /**
     * データベースの方言を定義する
     * @return
     */
    @Override
    public Dialect getDialect() {
        return null;
    }
}
