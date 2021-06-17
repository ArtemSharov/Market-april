package ru.gb.artem.marketapril.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Aspect
@Component
public class AppLoggingAspect {

    public Map<String, Long> map = new ConcurrentHashMap<>();

    public String getStatistic(){
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, Long> pair : map.entrySet()){
            sb.append(pair.getKey()).append(" ").append(pair.getValue());

        }
        return sb.toString();
    }

    @Around("execution(public * ru.gb.artem.marketapril.services.*.*(..))")
    public Object methodProfiling(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("start profiling");
        long begin = System.currentTimeMillis();
        Object out = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        long duration = end - begin;
        String serviceName = proceedingJoinPoint.getSignature().getDeclaringType().getSimpleName();
        map.merge(serviceName,duration, Long::sum);
        System.out.println((MethodSignature) proceedingJoinPoint.getSignature() + " duration: " + duration);
        System.out.println("end profiling");
        return out;
    }
}
