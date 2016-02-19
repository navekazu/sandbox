package tools.doma2.sample.domain;

import org.seasar.doma.Domain;

// 内部ドメイン（列挙型）
@Domain(valueType = Integer.class, factoryMethod = "of")
public enum JobType {
    SALES(1),
    MANAGER(2),
    ANALYST(3),
    PRESIDENT(4),
    ;

    private final Integer jobType;

    private JobType(Integer jobType) {
        this.jobType = jobType;
    }

    // ドメイン値を返すメソッドは「getValue」でなければならない
    public Integer getValue() {
        return jobType;
    }

    public static JobType of(Integer type) {
        for (JobType jobType: JobType.values()) {
            if (jobType.jobType.equals(type)) {
                return jobType;
            }
        }
        throw new IllegalArgumentException();
    }
}
