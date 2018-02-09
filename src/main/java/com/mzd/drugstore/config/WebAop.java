package com.mzd.drugstore.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

//使用@Aspect注解将一个java类定义为切面类
@Aspect
@Component
//在该项目中暂时不用aop了
public class WebAop {
    /**
     * 使用@Pointcut定义一个切入点，可以是一个规则表达式，比如某个package下的所有函数，也可以是一个注解等
     */
    //两个..代表所有子目录，最后括号里的两个..代表所有参数
    @Pointcut("execution(public * com.mzd.drugstore..constant.*.*(..))")
    public void WebPointCut() {
    }


    @Before("WebPointCut()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        System.out.println(("请求地址 : " + request.getRequestURL().toString()));
        System.out.println("HTTP METHOD : " + request.getMethod());
        System.out.println("IP : " + request.getRemoteAddr());
        System.out.println("那个类的那个方法 : " + joinPoint.getSignature().getDeclaringTypeName() + "."
                + joinPoint.getSignature().getName());
        System.out.println("参数 : " + Arrays.toString(joinPoint.getArgs()));

    }


    @AfterReturning(returning = "ret", pointcut = "WebPointCut()")// returning的值和doAfterReturning的参数名一致
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        System.out.println("返回值 : " + ret);
    }

    @Around("WebPointCut()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object ob = pjp.proceed();// ob 为方法的返回值
        System.out.println("耗时 : " + (System.currentTimeMillis() - startTime));
        return ob;
    }
}
