package com.evertonmartins.ecommerce.services.exceptions;

public class ResourceNotFoudException extends RuntimeException{

    public ResourceNotFoudException(String msg){
        super(msg);
    }
}
