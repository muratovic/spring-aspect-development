package com.muratovic.springaop.pointcut;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

@Component
@Aspect
public class PerformanceAspect {

    private static Logger logger = Logger.getLogger(PerformanceAspect.class.getName());

    @Pointcut("within(com.muratovic..*) && execution(* com.muratovic.springaop.service.StudentService.*(..))")
    public void serviceClassMethods() {
    }

    @Around("serviceClassMethods()")
    public Object measureMethodExecutionTime(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.nanoTime();
        Object retval = pjp.proceed();
        long end = System.nanoTime();
        String methodName = pjp.getSignature().getName();
        logger.info("Execution of " + methodName + " took " + TimeUnit.NANOSECONDS.toMillis(end - start) + " ms");
        return retval;
    }
}
