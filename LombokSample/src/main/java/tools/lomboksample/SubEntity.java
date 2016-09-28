package tools.lomboksample;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubEntity extends SuperEntity {
    private int field02;
}
