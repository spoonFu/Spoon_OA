package com.spoon.service.sys;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 使用切面来记录日期
 * @author FuShaoxing E-mail: xinyu2010@126.com
 * @version createTime：2014年12月8日 下午10:03:33
 */
@Aspect
public class LogAop {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Pointcut(value = "execution(* *.save(..))")
	public void cut(ProceedingJoinPoint point) {
		Object[] args = point.getArgs();
		for (Object o : args) {
			System.out.println(o);
		}
	}

	/*@Around("cut()")
	public void around(ProceedingJoinPoint point){
		System.out.println("捕捉到方法:"+point);
		try{
			point.proceed();
			logger.info("测试logger");
			System.out.println("方法执行成功!");
		}catch (Throwable e) {
			System.out.println("方法执行失败!");
		}
	}*/
	@Before("cut()")
	public void before() {
		logger.info("切面信息：before");
	}

	@After("cut()")
	public void after() {
		logger.info("切面信息：after");
	}

	@AfterReturning(pointcut = "cut()", returning = "retVal")
	public void afterReturning(Object retVal) {
		System.out.println("获取的返回值："+retVal);
		logger.info("切面信息：afterRturning");
	}
}
