package com.bike.bikecommon.exception;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;


/**
 * Date:2023/11/3
 * Author:丐版小杨哥
 * Description:
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 系统异常处理器
     *
     * @param e
     * @return
     */
    @ExceptionHandler(BikeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultException customException(BikeException e) {
        String errMessage = e.getErrMessage();
        return new ResultException(errMessage);
    }

    /**
     * 全集异常处理器
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultException exception(Exception e) {
        String message = e.getMessage();
        log.error("系统异常{}", e.getMessage(), e);
        ResultException resultException = new ResultException(CommonError.UNKOWN_ERROR.getErrMessage());
        return resultException;
    }

    /**
     * 参数异常处理器
     *
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultException MethodArgumentNotValidException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        List<FieldError> errorsList = bindingResult.getFieldErrors();
        List<String> error = new ArrayList<>();
        errorsList.stream().forEach(item -> {
            error.add(item.toString());
        });
        String errorMessage = StringUtils.join(error, ',');
        ResultException resultException = new ResultException(errorMessage);
        return resultException;
    }
}