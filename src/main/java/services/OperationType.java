package services;

import ddd.annotation.ValueType;

@ValueType
public enum OperationType {
    DEPOSIT, WITHDRAWAL, BALANCE_QUERY, OPERATION_QUERY
}
