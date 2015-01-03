package org.foo;

import org.foo.conf.SpringAopConfiguration;
import org.foo.serivce.FooService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringAopExampleMain {
	public static void main(String[] args) {
	
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringAopConfiguration.class);
		FooService fooService = applicationContext.getBean(FooService.class);
		fooService.helloDefaultLogging("John Snow",FooService.Gender.MALE);
		fooService.helloCustomizedTemplate("John Snow",FooService.Gender.MALE);
		fooService.helloCustomizedLogLevel("John Snow",FooService.Gender.MALE);
		fooService.helloMdc("John Snow",FooService.Gender.MALE);
		fooService.helloDoNotLog();
		try {
			fooService.helloDifferentLogLevelForExceptions("John",FooService.Gender.MALE);
		} catch (IllegalArgumentException e) {
			//
		}
		
		try {
			fooService.helloDifferentLogLevelForExceptions(null,FooService.Gender.MALE);
		} catch (NullPointerException e) {
			//
		}
		applicationContext.close();
		
	}
}
