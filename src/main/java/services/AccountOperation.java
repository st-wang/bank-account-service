package services;

import ddd.DomainEntity;
import ddd.annotation.Entity;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

@Entity
public class AccountOperation extends DomainEntity {

    private final LocalDateTime operationDate;
    private final OperationType operationType;
    private double operationAmount;

    public AccountOperation(String id, OperationType operationType, final double operationAmount) {
        super(id);
        this.operationDate = now();
        this.operationType = operationType;
        this.operationAmount = operationAmount;
    }

    public LocalDateTime getOperationDate() {
        return operationDate;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public double getOperationAmount() {
        return operationAmount;
    }
}
