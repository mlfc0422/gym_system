package com.mlfc.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Rest<Object> handleOtherExceptions(Exception ex) {
        log.error("其他类型异常信息：{}", ex.getMessage());
        return Rest.error("操作失败");
    }

    @ExceptionHandler(MyCustomException.class)
    @ResponseBody
    public Rest<Object> handleMyCustomException(MyCustomException ex) {
        log.error("自定义异常信息：{}", ex.getMessage());
        return Rest.error(ex.getMessage());
    }
}

