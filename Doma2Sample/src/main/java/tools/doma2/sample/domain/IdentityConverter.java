package tools.doma2.sample.domain;

import org.seasar.doma.ExternalDomain;
import org.seasar.doma.jdbc.domain.DomainConverter;

@ExternalDomain
public class IdentityConverter implements DomainConverter<Identity<?>, Integer> {

    public Integer fromDomainToValue(Identity<?> domain) {
        return domain.getValue();
    }

    @SuppressWarnings("rawtypes")
    public Identity<?> fromValueToDomain(Integer value) {
        if (value == null) {
            return null;
        }
        return new Identity(value);
    }
}