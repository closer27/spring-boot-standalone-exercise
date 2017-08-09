package io.icednut.spring.exercise.common;

import io.icednut.spring.exercise.board.BoardDTO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.List;

public class XmlAdvice {
    public void beforeLog(JoinPoint jp) {
        // Basic
        System.out.println("[사전 처리] 비즈니스 로직 수행 전 동작");

//        // Advanced
//        String method = jp.getSignature().getName();
//        Object[] args = jp.getArgs();
//        System.out.println("[사전 처리] " + method + "() 메소드 Args 정보 : " + (args.length > 0 ? args[0].toString() : ""));
    }

    public void afterLog(JoinPoint jp, Object returnObj) {
        // Basic
//        System.out.println("[사전 처리] 비즈니스 로직 수행 후 동작");
//
//        // Advanced
//        String method = jp.getSignature().getName();
//        System.out.println(returnObj);
//        if (returnObj instanceof List) {
//            List<BoardDTO> boardList = (List<BoardDTO>) returnObj;
//            for (BoardDTO board : boardList) {
//                System.out.println("받아온 board 목록 ---> " + board.toString());
//            }
//        }
//
//        System.out.println("[사후 처리] " + method + "() 메소드 리턴값 : " + returnObj.toString());
    }

    public void exceptionLog(JoinPoint jp, Exception exceptObj) {
        // Basic
//        System.out.println("[예외 처리] 비즈니스 로직 수행 중 예외 발생");
//
//        // Advanced
//        String method = jp.getSignature().getName();
//        System.out.println("[사후 처리] " + method + "() 메소드 리턴값 : " + exceptObj.getMessage());
    }

    public void finallyLog() {
//        System.out.println("[사후 처리] 비즈니스 로직 수행 후 무조건 동작");
    }

    public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
//        System.out.println("[BEFORE]: 비지니스 메소드 수행 전에 처리할 내용...");
        Object returnOjb = pjp.proceed();
//        System.out.println("[AFTER]: 비즈니스 메소드 수행 후에 처리할 내용...");
        return returnOjb;
    }
}
