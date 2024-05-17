package com.mlfc.common;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class LoggingAspect {

    @Before("execution(* com.mlfc.service.Impl.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        log.info("方法签名：{}{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
        log.info("参数：{}", joinPoint.getArgs());
    }

    @AfterReturning(pointcut = "execution(* com.mlfc.service.Impl.*.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        log.info("执行完成");
        log.info("返回值：{}", result);
    }
}
