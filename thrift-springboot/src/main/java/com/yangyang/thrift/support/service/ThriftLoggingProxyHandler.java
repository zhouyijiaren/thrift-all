package com.yangyang.thrift.support.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * ThriftLoggingProxyHandler
 * <p>
 * thrift 服务调用 aop 日志记录
 * </p>
 *
 * @author chenshunyang
 */
@Component
@Aspect
public class ThriftLoggingProxyHandler {

    //对于有Service注解的类, 通过AOP拦截, 进行日志的集中输出
    @Around(value = "@within(com.yangyang.thrift.support.annotions.EnableThriftServer)")
    public Object log(ProceedingJoinPoint pjp) {
        Object result = null;
        // *) 函数调用前, 拦截处理, 作ThreadLocal的初始化工作
        ThriftLogUtility.beforeInvoke(pjp.getTarget().getClass(), pjp.getSignature().getName(), pjp.getArgs()); // -----(1)
        try {
            result = pjp.proceed();
            // *) 函数成功返回后, 拦截处理, 进行日志的集中输出
            ThriftLogUtility.returnInvoke(result); // -----(2)
        } catch (Throwable e) {
            // *) 出现异常后, 拦截处理, 进行日志集中输入 // -----(3)
            ThriftLogUtility.throwableInvoke("[result = exception: {%s}]", e.getMessage());
        }
        return result;
    }

}
