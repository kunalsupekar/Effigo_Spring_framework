package com.example.SpringAOP.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoginAspect {

	private Logger logger=LoggerFactory.getLogger(getClass());

	
	@Before("com.example.SpringAOP.Aspect.CommonPointCutConfig.businessPackageConfig()")//WHEN
	public void logMethodcall(JoinPoint joinPoint) {
		logger.info("Before Aspect - {} is called with arguments: {}"
				,  joinPoint, joinPoint.getArgs());//WHAT		
	}
	
	@After("execution(* com.example.SpringAOP.*.*.*(..))")//WHEN
	public void logMethodcallAfter(JoinPoint joinPoint) {
		logger.info("After Aspect - {} has executed "
				,  joinPoint);//WHAT		
	}
}
