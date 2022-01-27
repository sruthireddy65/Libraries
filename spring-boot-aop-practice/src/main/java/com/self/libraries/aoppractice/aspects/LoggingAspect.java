package com.self.libraries.aoppractice.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    /*
      1. Applied for all getName() methods in any package with public modifier and String return type
            @Before("execution(public String getName())")
      2. Applied for all getName() methods irrespective of access modifier and package
            @Before("execution(String getName())")
      3. Applied to all getters without any argument and irrespective of package, return type and access modifier
            @Before("execution(* get*())")
      4. To apply to all getters in specific package and its subpackages
            @Before("execution(* com.self.libraries.aoppractice..get*(..)")
            .. -> 0 or more
            * -> 1 or more
      5. To apply to methods containing get in their name in specific package and its subpackages
            @Before("execution(* com.self.libraries..*get*(..))")
      6. Apply to all methods in a package
            @Before("execution(* com.self.libraries.aoppractice.services.*.*(..)")
     */
    @Before("execution(* com.self.libraries.aoppractice..get*())")
    public void loggingAdvice(){
        System.out.println("execution: logging advice executed");
    }

    /*
    1. Apply to all methods in a class
        @Before("within(com.self.libraries.aoppractice.services.ShapeService)")
    2. Apply to all methods of all classes in a package
        @Before("within(com.self.libraries.aoppractice.services.*)")
     */
    @Before("within(com.self.libraries.aoppractice.services.*)")
    public void loggingAdviceForWithin(JoinPoint joinPoint){
        System.out.println("within: logging advice executed "+ joinPoint);
    }

    /*
    1. Apply to methods taking String as argument
        @Before(args(String))
     */
    @Before("within(com.self.libraries.aoppractice.entities.Circle) && args(..)")
    public void loggingAdviceForArgs(JoinPoint joinPoint){
        System.out.println("Args: logging advice executed " + joinPoint);
    }

    /*
    Pointcut expressions are used to avoid defining expressions for each advice when we want to apply multiple advices for
    methods matching same expression.
    JoinPoints are used to get access to the method which matches pointcut expression and for which aspect is applied.
    joinPoint.getTarget() gives access to the object on whose methods aspects were applied
     */
    @Pointcut("execution(* com.self.libraries.aoppractice.entities.*.set*(..))")
    public void allSettersInEntities(){}

    /*
    After gets executed even if target method fails.
    To execute only if method succeeds use @AfterReturning. returning property is used to get returned value.
    To execute only if method fails use @AfterThrowing. throwing property is used to get exeception.
     */
    @After("allSettersInEntities()")
    public void setterAdvice(JoinPoint joinPoint){
        System.out.println("setter advice "+ joinPoint);
        Object object = joinPoint.getTarget();
    }

    @Before("execution(* com.self.libraries.aoppractice.services.TestService.*(..))")
    public void testAdvice(){
        System.out.println("test advice");
    }
}
