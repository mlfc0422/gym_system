package com.mlfc.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Rest<Object> handleException(Exception ex) {
        // 记录异常日志
        log.info("异常信息：{}", ex.getMessage());
        return Rest.error(ex.getMessage());
    }
}
