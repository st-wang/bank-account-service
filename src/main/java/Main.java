import services.Customer;
import services.CustomerAccount;

import javax.naming.OperationNotSupportedException;

public class Main {
    public static void main(String[] args) throws OperationNotSupportedException {

        Customer customer = new Customer("", "name", "password");
        CustomerAccount account = new CustomerAccount("", customer, 1500);

        account.deposit(1200);
        account.withdrawal(2000);

        account.displayBalance();

        account.withdrawal(100);

        account.displayOperations();
    }
}
