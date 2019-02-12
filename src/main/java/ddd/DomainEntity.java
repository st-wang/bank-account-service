package ddd;

import ddd.annotation.Entity;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.annotation.Nonnull;
import java.util.UUID;

import static org.apache.commons.lang3.StringUtils.isBlank;

@Entity
public class DomainEntity {
    protected final String id;

    protected DomainEntity(@Nonnull String id) {
        this.id = computeIdIfDoesntExist(id);
    }

    private String computeIdIfDoesntExist(String id) {

        String entityId = id;

        if (isBlank(entityId)) {
            entityId = UUID.randomUUID().toString();
        }
        return entityId;
    }

    @Nonnull
    public final String getId() {
        return id;
    }

    @Override
    public final int hashCode() {
        return new HashCodeBuilder(3, 21) //
                .append(id) //
                .toHashCode();
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DomainEntity other = (DomainEntity) obj;
        return new EqualsBuilder() //
                .append(id, other.id) //
                .isEquals();
    }
}

