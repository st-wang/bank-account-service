package services;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class AccountOperationTest {

    @Test
    public void should_create_an_account_operation() {
        //Given
        AccountOperation operation = new AccountOperation("", OperationType.DEPOSIT, 100);
        //Then
        assertThat(operation.getId()).isNotNull();
        assertThat(operation.getOperationDate()).isNotNull();
        assertThat(operation.getOperationType()).isEqualTo(OperationType.DEPOSIT);
        assertThat(operation.getOperationAmount()).isEqualTo(100);
    }

}