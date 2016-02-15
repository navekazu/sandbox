package tools.doma2.sample.dao;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import tools.doma2.sample.config.Doma2SimpleConfig;
import tools.doma2.sample.entity.Employee;

import java.util.List;

@Dao(config = Doma2SimpleConfig.class)
public interface EmployeeDao {
    @Select
    Employee selectById(Integer id);

    @Select
    List<String> selectAllName();
}
