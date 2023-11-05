package com.bike.bikecommon.exception;

/**
 * Date:2023/11/3
 * Author:丐版小杨哥
 * Description:
 */
public class BikeException extends RuntimeException {
    String errMessage;

    public BikeException() {
        super();
    }

    public BikeException(String message) {
        super(message);
        this.errMessage = message;
    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }

}
