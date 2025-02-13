package com.petfoster.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceMonitoringAspect {

    private static final Logger logger = LoggerFactory.getLogger(PerformanceMonitoringAspect.class);

    // Define the pointcut to target all methods in the services package
    @Pointcut("execution(* com.petfoster.services..*(..))")
    public void monitor() {
    }

    // Around advice to log execution time and log method details
    @Around("monitor()")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        // Log method entry
        logger.info("Entering method: " + joinPoint.getSignature().toShortString());
        Object[] args = joinPoint.getArgs();
        if (args != null && args.length > 0) {
            StringBuilder params = new StringBuilder();
            for (Object arg : args) {
                params.append(arg).append(" ");
            }
            logger.info("With arguments: " + params.toString().trim());
        } else {
            logger.info("No arguments.");
        }

        long start = System.currentTimeMillis();  // Start time for performance monitoring
        Object proceed = joinPoint.proceed();     // Proceed with method execution
        long executionTime = System.currentTimeMillis() - start;  // Calculate execution time

        // Log execution time
        logger.info(joinPoint.getSignature().toShortString() + " executed in " + executionTime + "ms");

        return proceed;
    }
}
