package com.jiangcz.application.spring.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 类名称：LoggerAspect<br>
 * 类描述：<br>
 * 创建时间：2018年08月08日<br>
 *
 * @author jiangcheng
 * @version 1.0.0
 */
@Aspect//表示该类是切面类
@Component//将该类注入到IOC容器
@Slf4j
public class LoggerAspect {

    ////表示before方法执行的时机
    @Before("execution(public int com.jiangcz.com.jiangcz.aop.invocation.CalImpl.*(..))")
    public void before(JoinPoint jointPoint){
        //获取方法名
        String name = jointPoint.getSignature().getName();
        //获取参数列表
        String args = Arrays.toString(jointPoint.getArgs());
        log.info("{} 的参数是: {}",name,args);
        System.out.println(name+"的参数是:"+args);
    }

    @After("execution(public int com.jiangcz.com.jiangcz.aop.invocation.CalImpl.*(..))")
    public void after(JoinPoint joinPoint){
        //获取方法名
        String name = joinPoint.getSignature().getName();
        log.info("{} 方法结束",name);
        System.out.println(name+"方法结束");
    }

    @AfterReturning(value = "execution(public int com.jiangcz.com.jiangcz.aop.invocation.CalImpl.*(..))",returning = "result")
    public void afterReturn(JoinPoint joinPoint,Object result){
        //获取方法名
        String name = joinPoint.getSignature().getName();
        log.info("{} 方法的结果是 {}",name,result);
        System.out.println(name+"方法的结果是"+result);
    }

    @AfterThrowing(value = "execution(public int com.jiangcz.com.jiangcz.aop.invocation.CalImpl.*(..))",throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint,Exception ex){
        //获取方法名
        String name = joinPoint.getSignature().getName();
        log.info("{} 方法抛出异常 {}",name,ex);
        System.out.println(name+"方法抛出异常:"+ex);
    }
}