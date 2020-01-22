package com.smoothstack.december.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LoggerAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @After("execution(* com.smoothstack.december.dao.*.*(..))")
    public void before(JoinPoint joinPoint) {
        logger.info(" Allowed execution for {}", joinPoint);
    }

}
