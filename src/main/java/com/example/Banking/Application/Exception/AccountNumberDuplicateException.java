package com.example.Banking.Application.Exception;

public class AccountNumberDuplicateException extends RuntimeException {
    String messege;
    public AccountNumberDuplicateException(String messege) {
        super(messege);
        this.messege = messege;
    }
}
