package org.foo.aspect;

import net.sf.aspect4log.Log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
//@Aspect
public class FooLogAspect {

	@Around("(execution(!@net.sf.aspect4log.Log *(@net.sf.aspect4log.Log *).*(..))|| execution(!@net.sf.aspect4log.Log *.new(..)))  && @within(log)")
//	@Around("(execution(!@net.sf.aspect4log.Log *(@net.sf.aspect4log.Log *).*(..)))  && @within(log)")
//	@Around("execution(!@net.sf.aspect4log.Log *(@net.sf.aspect4log.Log *).*(..)) && @target(log)")
	public Object logNotAnnotatedMethondsInAnnotatedClasses(ProceedingJoinPoint pjp, Log log) throws Throwable {
		return pjp.proceed();
	}

	@Around("(execution(@net.sf.aspect4log.Log *.new(..)) || execution(@net.sf.aspect4log.Log * *.*(..)) ) && @annotation(log)")
//	@Around("@annotation(log)")
	public Object logAnnotatedMethods(ProceedingJoinPoint pjp, Log log) throws Throwable {
		return pjp.proceed();
	}
}
