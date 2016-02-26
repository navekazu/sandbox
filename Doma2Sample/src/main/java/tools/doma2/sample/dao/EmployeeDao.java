package tools.doma2.sample.dao;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.builder.SelectBuilder;
import tools.doma2.sample.config.Doma2SimpleConfig;
import tools.doma2.sample.entity.Employee;

import java.util.List;

@Dao(config = Doma2SimpleConfig.class)
public interface EmployeeDao {
    @Select
    Employee selectById(Integer id);

    @Select
    List<String> selectAllName();

    @Insert
    int insert(Employee entity);

    default int count() {
        Config config = Config.get(this);
        SelectBuilder builder = SelectBuilder.newInstance(config);
        builder.sql("select count(*) from employee");
        return builder.getScalarSingleResult(int.class);
    }
}
