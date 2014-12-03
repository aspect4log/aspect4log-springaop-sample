package org.foo;

import org.foo.conf.SpringAopConfiguration;
import org.foo.serivce.FooService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
	
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringAopConfiguration.class);
		FooService fooService = applicationContext.getBean(FooService.class);
		fooService.helloDefaultLogging("John Snow",FooService.Gender.MALE);
		fooService.helloCustomizedTemplate("John Snow",FooService.Gender.MALE);
		fooService.helloCustomizedLogLevel("John Snow",FooService.Gender.MALE);
		fooService.helloMdc("John Snow",FooService.Gender.MALE);
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
		
	}
}
