package tools.doma2.sample.domain;

import org.seasar.doma.Domain;

// 内部ドメイン
@Domain(valueType=String.class, factoryMethod = "of")
public class Email {
    private final String email;

    public Email(String value) {
        this.email = value;
    }

    // ドメイン値を返すメソッドは「getValue」でなければならない
    public String getValue() {
        return this.email;
    }

    /**
     * ファクトリメソッド
     * @param value メールアドレス
     * @return ドメインクラスのインスタンス
     */
    public static Email of(String value) {
        return new Email(value);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Email)){
            return false;
        }
        Email e = (Email)o;

        if (e==null) {
            return false;
        }

        if (email==null && e.getValue()!=null) {
            return false;
        }

        if (email!=null && e.getValue()==null) {
            return false;
        }

        if (!email.equals(e.getValue())) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return email;
    }


    // ドメイン固有の振る舞いを記述

    /**
     * @以降のドメイン名を返す
     * @return ドメイン名
     */
    public String getDomainName() {
        return this.email.substring(email.indexOf("@"));
    }
}
