package com.web.shop.exception;

/**
 * @anthor sily
 * @date 2020/1/13 - 13:59
 */
public class AddSuccessException extends RuntimeException {
    public AddSuccessException(String message, Throwable cause) {
        super(message, cause);
    }

    public AddSuccessException(String message) {
        super(message);
    }
}
