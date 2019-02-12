package services;

import ddd.DomainEntity;
import ddd.annotation.Entity;

import javax.annotation.Nonnull;
import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.requireNonNull;

@Entity
public class CustomerAccount extends DomainEntity implements OperateAnAccount {

    private final Customer customer;
    private double accountBalance;
    private List<AccountOperation> accountOperations;

    public CustomerAccount(final String id, @Nonnull final Customer customer, double accountBalance) {
        super(id);
        this.customer = requireNonNull(customer);
        this.accountBalance = accountBalance;
        this.accountOperations = new ArrayList<>();
    }

    @Nonnull
    public Customer getCustomer() {
        return customer;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    @Nonnull
    public List<AccountOperation> getAllAccountOperations() {
        return accountOperations;
    }

    public void updateAccountBalance(double accountBalance) {
        this.accountBalance += accountBalance;
    }

    public void addANewAccountOperation(AccountOperation accountOperations) {
        this.accountOperations.add(accountOperations);
    }

    @Override
    public void deposit(double amount) {
        double checkedAmount = checkAmount(amount);

        updateAccountBalance(checkedAmount);

        addANewAccountOperation(new AccountOperation("", OperationType.DEPOSIT, checkedAmount));
        System.out.println(OperationType.DEPOSIT.toString() + " of " + checkedAmount
                + ", the balance of your account is: " + getAccountBalance() + ".");
    }

    @Override
    public void withdrawal(double amount) throws OperationNotSupportedException {
        double checkedAmount = checkAmount(amount);

        if (getAccountBalance() >= checkedAmount) {
            updateAccountBalance(checkedAmount * (-1));
        } else {
            throw new OperationNotSupportedException("Not enough balance.");
        }

        addANewAccountOperation(new AccountOperation("", OperationType.WITHDRAWAL, checkedAmount));
        System.out.println(OperationType.WITHDRAWAL.toString() + " of " + checkedAmount
                + ", the balance of your account is: " + getAccountBalance() + ".");
    }

    @Override
    public void displayBalance() {
        System.out.println("The balance of your account is: " + getAccountBalance() + ".");
    }

    @Override
    public void displayOperations() {
        System.out.println("All operations on your account: ");
        getAllAccountOperations().forEach(op -> {
            System.out.println(op.getOperationDate().toString() + " ### "
                    + op.getOperationType().toString() + " ### "
                    + String.valueOf(op.getOperationAmount()));
        });
    }

    private double checkAmount ( double amount){
        if (amount > 0 && amount % 10 == 0) {
            return amount;
        } else {
            throw new IllegalArgumentException("Amount must be a multiple of 10 and greater than 0.");
        }
    }
}
