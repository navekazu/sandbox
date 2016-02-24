package tools.doma2.sample.dao;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import tools.doma2.sample.config.Doma2SimpleConfig;
import tools.doma2.sample.entity.CompanySection;

import java.util.List;

@Dao(config = Doma2SimpleConfig.class)
public interface CompanySectionDao {
    @Select
    public List<CompanySection> selectAll();
}
