package com.shyb.masterslave.datasource;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author wzh
 * @date 2019/6/13 - 16:04
 */
@Aspect
@Component
@Slf4j
@Order(1)
public class DatasourceAop {
    /**
     * mapper层只读方法
     */
    private static final String[] reads = {"countByExample","selectByExample","selectByPrimaryKey","selectByExampleWithBLOBs"};
    /**
     * 当前线程是否使用过主库
     */
    private static final ThreadLocal<Boolean> FLAG = new ThreadLocal<Boolean>();
    @Pointcut("execution(* com.shyb.masterslave.mapper.user..*.*(..))")
    public void user(){
    };
    @Pointcut("execution(* com.shyb.masterslave.mapper.order..*.*(..))")
    public void order(){
    }


    @Before("user()")
    public void userDatasource(JoinPoint joinPoint){
        if(!isUserMaster() && isReadMethod(joinPoint)){
            CustomerContextHolder.setCustomerType(DbType.DATASOURCE_USER_READ);
        }else{
            FLAG.set(true);
            CustomerContextHolder.setCustomerType(DbType.DATASOURCE_USER);
        }
        log.info("当前数据库:"+CustomerContextHolder.getCustomerType());
    }

    @Before("order()")
    public void orderDatasource(JoinPoint joinPoint){
        if(!isUserMaster() && isReadMethod(joinPoint)){
            CustomerContextHolder.setCustomerType(DbType.DATASOURCE_ORDER_READ);
        }else{
            FLAG.set(true);
            CustomerContextHolder.setCustomerType(DbType.DATASOURCE_ORDER);
        }
        log.info("当前数据库:"+CustomerContextHolder.getCustomerType());
    }

    @After(value = "user() || order()")
    public void clearDatasource(JoinPoint joinPoint){
        log.info("清除数据库"+CustomerContextHolder.getCustomerType());
        CustomerContextHolder.clearCustomerType();
    }
    private Boolean isReadMethod(JoinPoint joinPoint){
        return Arrays.asList(reads).contains(joinPoint.getSignature().getName());
    }
    private Boolean isUserMaster(){
        return FLAG.get() == null ? false : FLAG.get();
    }
}
