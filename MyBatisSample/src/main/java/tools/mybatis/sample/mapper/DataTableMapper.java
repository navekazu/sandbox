package tools.mybatis.sample.mapper;

import org.apache.ibatis.annotations.Select;

/**
 * Created by k_watanabe on 2016/01/18.
 */
public interface DataTableMapper {
    public String selectValue(int id);

    @Select("select value from data_table where id = 2")
    public String selectValueId2();

    public String selectValue2();
}
