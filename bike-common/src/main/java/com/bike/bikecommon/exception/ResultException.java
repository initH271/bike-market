package com.bike.bikecommon.exception;

/**
 * Date:2023/11/3
 * Author:丐版小杨哥
 * Description:
 */
public class ResultException {
    String errMessage;

    public ResultException(String errMessage) {
        this.errMessage = errMessage;
    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }
}
