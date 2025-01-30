package com.example.SpringAOP.Aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointCutConfig {

	@Pointcut("execution(* com.example.SpringAOP.*.*.*(..))")
	public void businessPackageConfig() {}
	
	
	@Pointcut("@annotation(com.example.SpringAOP.buisness.TrackTime)")
	public void trackTimeAnnotation() {
	
	}
}
