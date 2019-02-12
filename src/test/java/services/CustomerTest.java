package services;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerTest {
    private final String ID = "customer_id";
    private final String NAME = "customer_name";
    private final String PASSWORD = "password";

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void should_create_a_customer() {
        //Given
        Customer customer = new Customer(ID, NAME, PASSWORD);
        //Then
        assertThat(customer.getId()).isEqualTo("customer_id");
        assertThat(customer.getCustomerName()).isEqualTo("customer_name");
        assertThat(customer.getPassword()).isEqualTo("password");
    }

    @Test
    public void should_not_create_a_customer_with_null_name() {
        thrown.expect(NullPointerException.class);
        //Given
        //When
        new Customer(ID, null, PASSWORD);
    }

    @Test
    public void should_not_create_a_customer_with_null_password() {
        thrown.expect(NullPointerException.class);
        //Given
        //When
        new Customer(ID, NAME, null);
    }
}