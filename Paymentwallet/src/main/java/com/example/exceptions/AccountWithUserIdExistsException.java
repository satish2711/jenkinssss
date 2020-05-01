package com.example.exceptions;

public class AccountWithUserIdExistsException extends RuntimeException{
    public AccountWithUserIdExistsException(String msg){
        super(msg);
    }

    public AccountWithUserIdExistsException(String msg,Throwable e){
        super(msg,e);
    }

}

