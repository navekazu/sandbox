package tools.mybatis.sample.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DataTable {
    private Integer id;
    private String value;
}
