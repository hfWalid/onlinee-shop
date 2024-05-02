package com.onlineshop.productservice.config.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Aspect
@Component
//@Profile("DEV")
public class LoggingServiceAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingServiceAspect.class);

    @Before("execution(* com.onlineshop.productservice.service.*.*(..))")
    public void logBeforeServiceExecution(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String[] parameterNames = methodSignature.getParameterNames();
        Object[] args = joinPoint.getArgs();

        StringBuilder logMessage = new StringBuilder("Before executing service method: ");
        logMessage.append(methodSignature.toShortString());
        logMessage.append(" with arguments: [");

        StringBuilder openBracket = new StringBuilder("{");
        for (int i = 0; i < parameterNames.length; i++) {
            logMessage.append(openBracket.append(parameterNames[i]).append(" = ").append(args[i]).append("}"));
            if (i < parameterNames.length - 1) {
                logMessage.append(", ");
            }
        }
        logMessage.append("]");
        logger.info(logMessage.toString());
    }

    @After("execution(* com.onlineshop.productservice.service.*.*(..))")
    public void logAfterServiceExecution(JoinPoint joinPoint) {
        logger.info("After executing service method: {}", joinPoint.getSignature().toShortString());
    }

    @AfterReturning(pointcut = "execution(* com.onlineshop.productservice.service.*.*(..))", returning = "result")
    public void logAfterServiceReturning(JoinPoint joinPoint, Object result) {
        logger.info("After returning from service method: {}. Returned: {}", joinPoint.getSignature().toShortString(), result);
    }

    @AfterThrowing(pointcut = "execution(* com.onlineshop.productservice.service.*.*(..))", throwing = "exception")
    public void logAfterServiceThrowing(JoinPoint joinPoint, Exception exception) {
        logger.error("Exception thrown from service method: {}. Exception: {}", joinPoint.getSignature().toShortString(), exception.getMessage());
    }
}
