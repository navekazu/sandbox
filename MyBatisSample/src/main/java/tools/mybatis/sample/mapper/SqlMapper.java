package tools.mybatis.sample.mapper;

import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;
import tools.mybatis.sample.domain.DataTable;

import java.util.List;

/**
 * Created by k_watanabe on 2016/02/09.
 */
public interface SqlMapper {

    static class SqlProvider {
        public String simpleQuery() {
            return new SQL(){{
                SELECT("id, value");
                FROM("data_table");
                WHERE("id=1");
                WHERE("value='value_1'");
            }}.toString();
        }

        public String countDataTable() {
            return new SQL(){{
                SELECT("count(*)");
                FROM("data_table");
            }}.toString();
        }

        public String deleteDataTable() {
            return new SQL(){{
                DELETE_FROM("data_table");
                WHERE("id=1");
            }}.toString();
        }

        public String insertDataTable() {
            return new SQL()
                    .INSERT_INTO("data_table")
                    .VALUES("id", "6")
                    .VALUES("value", "'value_6'")
                    .toString();
        }

        /*
        public String selectDataTable(final Integer id, final String value) {
            return new SQL(){{
                SELECT("id, value");
                FROM("data_table");
                if (id!=null) {
                    WHERE("id=${id}");
                }
                if (value!=null) {
                    WHERE("value like ${value}");
                }
            }}.toString();
        }
        */

    }

    @SelectProvider(type = SqlProvider.class, method = "simpleQuery")
    public List<DataTable> simpleQuery();

    @SelectProvider(type = SqlProvider.class, method = "countDataTable")
    public Integer countDataTable();

    @SelectProvider(type = SqlProvider.class, method = "deleteDataTable")
    public void deleteDataTable();

    @SelectProvider(type = SqlProvider.class, method = "insertDataTable")
    public void insertDataTable();

//    @SelectProvider(type = SqlProvider.class, method = "selectDataTable")
//    public List<DataTable> selectDataTable(Integer id, String value);
}
