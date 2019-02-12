package services;

import javax.naming.OperationNotSupportedException;

public interface OperateAnAccount {

    void deposit(double amount);

    void withdrawal(double amount) throws OperationNotSupportedException;

    void displayBalance();

    void displayOperations();
}
