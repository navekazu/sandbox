package tools.doma2.sample.entity;

import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

@Entity(immutable = true)
@Table(name="company_section")
public class CompanySection {
    @Id
    public final Integer id;
    public final String name;

    public CompanySection(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
