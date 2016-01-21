package tools.mybatis.sample.mapper;

import org.apache.ibatis.annotations.Select;
import tools.mybatis.sample.domain.DataTable;

/**
 * Created by k_watanabe on 2016/01/18.
 */
public interface DataTableMapper {
    public String selectValue(int id);

    @Select("select value from data_table where id = 2")
    public String selectValueId2();

    public String selectValue2();

    public void insertValue(DataTable data);
    public void updateValue(DataTable data);
    public void deleteValue(int id);
}
