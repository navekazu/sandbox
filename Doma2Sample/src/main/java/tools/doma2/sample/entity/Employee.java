package tools.doma2.sample.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.OriginalStates;
import org.seasar.doma.Version;
import org.seasar.doma.jdbc.entity.NamingType;
import tools.doma2.sample.domain.Email;
import tools.doma2.sample.domain.Identity;
import tools.doma2.sample.domain.JobType;

import java.io.Serializable;
import java.util.Optional;

@Entity(naming = NamingType.SNAKE_LOWER_CASE, listener=EmployeeEntityListener.class)
public class Employee implements Serializable {
    @Id
//    public Identity<Employee> id;   // 次のエラーが出るので使用をやめる → エラー :(20, 31) java: [DOMA4096] クラス[tools.doma2.sample.domain.Identity<tools.doma2.sample.entity.Employee>]は、永続対象の型としてサポートされていません。@ExternalDomainでマッピングすることを意図している場合、登録や設定が不足している可能性があります。@DomainConvertersを注釈したクラスと注釈処理のオプション（doma.domain.converters）を見直してください。
    public Integer id;
    public Optional<String> name;
    public Optional<Email> email;
    public Optional<JobType> jobType;

    @OriginalStates
    public Employee originalStates;
}
