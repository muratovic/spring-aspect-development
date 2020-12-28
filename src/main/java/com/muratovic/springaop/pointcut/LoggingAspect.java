package com.muratovic.springaop.pointcut;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

@Component
@Aspect
public class LoggingAspect {

    private static Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    private ThreadLocal<SimpleDateFormat> sdf = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("[yyyy-mm-dd hh:mm:ss:SSS]");
        }
    };

    @Pointcut("within(com.muratovic..*) && execution(* com.muratovic.springaop.service.StudentService.*(..))")
    public void serviceMethods() {
    }

    @Pointcut("within(com.muratovic..*) && @annotation(com.muratovic.springaop.annotations.Loggable)")
    public void loggableMethods() {
    }

    @Before("serviceMethods()")
    public void logMethodCall(JoinPoint jp) {
        String methodName = jp.getSignature().getName();
        logger.info(sdf.get().format(new Date()) + " - Service method will be executed: " + methodName);
    }

    @Before("loggableMethods()")
    public void logMethod(JoinPoint jp) {
        String methodName = jp.getSignature().getName();
        logger.info(sdf.get().format(new Date()) + " - Loggable method will be executed: " + methodName);
    }
}
