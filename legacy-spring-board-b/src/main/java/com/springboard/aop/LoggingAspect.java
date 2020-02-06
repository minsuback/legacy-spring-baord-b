package com.springboard.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAspect {

	public void logBefore(JoinPoint joinPoint) {
		System.out.println(String.format("Before %s.%s", joinPoint.getTarget().getClass().getName(),
				joinPoint.getSignature().getName()));
	}

	public void logAfter(JoinPoint joinPoint) {
		System.out.println(String.format("After %s.%s", joinPoint.getTarget().getClass().getName(),
				joinPoint.getSignature().getName()));
	}

	public Object writeLog(ProceedingJoinPoint joinPoint) {

		long start = System.currentTimeMillis();

		Object returnValue = null;
		try {
			// 실제 메서드 호출
			returnValue = joinPoint.proceed();
		} catch (Throwable e) {
		}

		long stop = System.currentTimeMillis();

		System.out.printf("Execution Lap of %s.%s: %d\n", joinPoint.getTarget().getClass().getName(),
				joinPoint.getSignature().getName(), (stop - start));

		return returnValue;
	}
	
}
