package com.ecom.inventory.exception;

public class InventoryNotFoundException extends RuntimeException {
    public InventoryNotFoundException(String msg)
    {
    	super(msg);
    }
}
