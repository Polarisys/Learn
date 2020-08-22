package com.web.shop.exception;

/**
 * @anthor sily
 * @date 2020/1/13 - 14:02
 */
public class ErrorNumberException extends RuntimeException {
    public ErrorNumberException() {
        super();
    }

    public ErrorNumberException(String message) {
        super(message);
    }
}
