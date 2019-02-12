package services;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import javax.naming.OperationNotSupportedException;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerAccountTest {
    private final Customer CUSTOMER = new Customer("id", "customer_name", "password");

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void should_create_a_customer_account() {
        //Given
        CustomerAccount account = new CustomerAccount("", CUSTOMER, 0);
        //Then
        assertThat(account.getId()).isNotNull();
        assertThat(account.getCustomer()).isEqualTo(CUSTOMER);
        assertThat(account.getAccountBalance()).isEqualTo(0D);
        assertThat(account.getAllAccountOperations()).isNotNull();
        assertThat(account.getAllAccountOperations().size()).isEqualTo(0);
    }

    @Test
    public void should_not_create_a_customer_account_with_a_null_customer() {
        thrown.expect(NullPointerException.class);
        //Given
        //When
        new CustomerAccount("", null, 0);
    }


    @Test
    public void should_update_account_balance_with_positive_amount() {
        //Given
        CustomerAccount account = create_a_customer_account(0);
        //When
        account.updateAccountBalance(100);
        //Then
        assertThat(account.getAccountBalance()).isEqualTo(100);
    }


    @Test
    public void should_update_account_balance_with_negative_amount() {
        //Given
        CustomerAccount account = create_a_customer_account(100);
        //When
        account.updateAccountBalance(-20);
        //Then
        assertThat(account.getAccountBalance()).isEqualTo(80);
    }

    @Test
    public void should_add_a_new_account_operation() {
        //Given
        CustomerAccount account = create_a_customer_account(100);
        //When
        account.addANewAccountOperation(new AccountOperation("", OperationType.DEPOSIT, 10D));
        //Then
        assertThat(account.getAllAccountOperations().size()).isEqualTo(1);
    }

    @Test
    public void should_make_a_deposit_to_an_account() {
        //Given
        CustomerAccount account = create_a_customer_account(100);
        //When
        account.deposit(100);
        //Then
        assertThat(account.getAccountBalance()).isEqualTo(200);
    }

    @Test
    public void should_not_make_a_deposit_with_illegal_amount() {
        thrown.expect(IllegalArgumentException.class);
        //Given
        //When
        CustomerAccount account = create_a_customer_account(100);
        account.deposit(15);
    }

    @Test
    public void should_make_a_withdrawal_to_an_account() throws OperationNotSupportedException {
        //Given
        CustomerAccount account = create_a_customer_account(100);
        //When
        account.withdrawal(50);
        //Then
        assertThat(account.getAccountBalance()).isEqualTo(50);
    }

    @Test
    public void should_not_make_a_withdrawal_with_illegal_amount() throws OperationNotSupportedException {
        thrown.expect(IllegalArgumentException.class);
        //Given
        //When
        CustomerAccount account = create_a_customer_account(100);
        account.withdrawal(15);
    }

    @Test
    public void should_throw_an_exception_when_withdrawal_amount_is_greater_than_balance() throws OperationNotSupportedException {
        thrown.expect(OperationNotSupportedException.class);
        //Given
        //When
        CustomerAccount account = create_a_customer_account(100);
        account.withdrawal(150);
    }

    @Test
    public void should_display_balance_of_account() {
        //Given
        CustomerAccount account = create_a_customer_account(100);
        //When
        account.deposit(10);
        account.displayBalance();
    }

    @Test
    public void should_display_operations_of_account() throws OperationNotSupportedException {
        //Given
        CustomerAccount account = create_a_customer_account(100);
        //When
        account.deposit(10);
        account.withdrawal(80);
        account.displayOperations();
    }

    private CustomerAccount create_a_customer_account(double amount) {
        return new CustomerAccount("id", CUSTOMER, amount);
    }
}
