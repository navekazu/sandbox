package tools.doma2.sample.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;

import java.util.Optional;

@Entity
public class Employee {
    @Id
    Integer id;
    Optional<String> name;
    Optional<String> email;
}
