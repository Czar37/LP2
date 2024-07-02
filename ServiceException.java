package com.sistema.Exception;

public class ServiceException extends Exception{
    public ServiceException(String message, Throwable e){
        super(message, e);
    }
}
