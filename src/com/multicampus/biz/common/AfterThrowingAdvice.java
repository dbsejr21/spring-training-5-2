package com.multicampus.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

//@Service("afterThrowing")
@Aspect
public class AfterThrowingAdvice {

	@AfterThrowing(pointcut="PointcutCommon.allPointcut()", throwing="exceptObj")
	public void exceptionLog(JoinPoint jp, Exception exceptObj) {
		String method = jp.getSignature().getName();
		
		if(exceptObj instanceof EmptyResultDataAccessException) {
			System.out.println("검색 결과가 반드시 하나는 있어야 합니다.");
		} else {
			System.out.println("[예외 처리] " + method + 
					"() 메소드에서 발생된 예외 메시지 : " + 
						exceptObj.getMessage());
		}
	}
}
