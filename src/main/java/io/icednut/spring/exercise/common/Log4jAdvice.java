package io.icednut.spring.exercise.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
@Aspect
public class Log4jAdvice {
    @Pointcut("execution(* io.icednut.spring.exercise..*Impl.*(..))")
    public void allPointcut() {}

    @Pointcut("execution(* io.icednut.spring.exercise..*Impl.get*(..))")
    public void getPointcut() {}

    @Before("allPointcut()")
    public void printLogging() {
        System.out.println("[공통 로그-Log4j 비지니스 로직 수행 전 동작");
    }

    @AfterThrowing(pointcut = "allPointcut()", throwing = "exceptObj")
    public void exceptionLogging(JoinPoint jp, Exception exceptObj) {
        String method = jp.getSignature().getName();
        System.out.println(method + "() 메소드 수행 중 예외 발생!");

        if (exceptObj instanceof SQLException) {
            System.out.println("SQL 수행 중 예외 발생");
        } else {
            System.out.println("기타 예외 발생");
        }
    }
}
