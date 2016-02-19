package tools.doma2.sample.domain;

import java.io.Serializable;

// 型パラメータを利用した内部ドメイン
public class Identity<T> implements Serializable {
    private final Integer value;

    public Identity(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
