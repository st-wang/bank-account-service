package services;

import ddd.DomainEntity;
import ddd.annotation.Entity;

import javax.annotation.Nonnull;

import static java.util.Objects.requireNonNull;

@Entity
public class Customer extends DomainEntity {

    private final String customerName;
    private String password;

    public Customer(String id, @Nonnull String customerName, @Nonnull String password) {
        super(id);
        this.customerName = requireNonNull(customerName);
        this.password = requireNonNull(password);
    }

    @Nonnull
    public String getCustomerName() {
        return customerName;
    }

    @Nonnull
    public String getPassword() {
        return password;
    }
}
